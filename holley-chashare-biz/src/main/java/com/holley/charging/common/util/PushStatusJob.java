package com.holley.charging.common.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.holley.charging.model.def.ConnectorStatusInfo;
import com.holley.charging.model.pob.PobChargingPile;
import com.holley.charging.service.share.CommonService;
import com.holley.common.constants.share.ConnectorStatusTypeEnum;
import com.holley.common.constants.share.RetTypeEnum;
import com.holley.common.dataobject.PileStatusBean;

/**
 * Description:
 *
 * @author shen.cheng@holley.cn
 */
public class PushStatusJob extends JobBase {

    private final static Logger               logger             = Logger.getLogger(PushStatusJob.class);
    private Map<Integer, ConnectorStatusInfo> connectorStatusMap = new HashMap<Integer, ConnectorStatusInfo>();
    private boolean                           isInit             = false;

    public PushStatusJob(String operatorID, LocalCacheUtil localCacheUtil, CommonService commonService) {
        super(operatorID, localCacheUtil, commonService);
    }

    @Override
    public void run() {
        while (isRun) {
            try {
                if (connectorStatusMap.size() > 0 && isInit) {
                    List<PobChargingPile> refreshPiles = localCacheUtil.refreshPile();
                    if (refreshPiles != null && refreshPiles.size() > 0) {
                        refreshConnectorStatusMap(refreshPiles);
                    }
                    logger.info("初始化完毕进入正常循环任务:" + connectorStatusMap.size());
                    for (Map.Entry<Integer, ConnectorStatusInfo> entry : connectorStatusMap.entrySet()) {
                        PileStatusBean sbean = null;
                        try {
                            sbean = localCacheUtil.returnPileStatusBean(entry.getKey());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        ConnectorStatusInfo cinfo = entry.getValue();

                        if (sbean != null) {

                            int status = this.localCacheUtil.returnPileStatus(sbean.getStatus()).getValue();
                            if (status != cinfo.getStatus()) {
                                logger.info(cinfo.getConnectorID() + "状态：" + sbean.getStatus() + "开始推送！！");
                                cinfo.setStatus(status);
                                boolean isok = notificationStationStatus(cinfo);
                            }
                        }
                        TimeUnit.MILLISECONDS.sleep(500);
                    }
                } else {
                    List<PobChargingPile> list = localCacheUtil.getAllPile();
                    if (list != null) {
                        logger.info("启动初始化推送的桩数量:" + list.size());
                    }
                    for (PobChargingPile pile : list) {
                        PileStatusBean p = null;
                        try {
                            p = localCacheUtil.returnPileStatusBean(pile.getId());// 获取实时桩状态
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        ConnectorStatusInfo cinfo = new ConnectorStatusInfo();
                        if (p != null) {
                            cinfo.setStatus(this.localCacheUtil.returnPileStatus(p.getStatus()).getValue());
                        } else {
                            cinfo.setStatus(ConnectorStatusTypeEnum.OFF_LINE.getValue());
                        }
                        cinfo.setConnectorID(pile.getPileCode());
                        if (!connectorStatusMap.containsKey(pile.getId())) {
                            connectorStatusMap.put(pile.getId(), cinfo);
                        }
                        notificationStationStatus(cinfo);// 推送
                        TimeUnit.MILLISECONDS.sleep(500);
                    }
                    isInit = true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void refreshConnectorStatusMap(List<PobChargingPile> newPiles) {
        for (PobChargingPile p : newPiles) {
            if (!connectorStatusMap.containsKey(p.getId())) {
                ConnectorStatusInfo newcInfo = new ConnectorStatusInfo();
                newcInfo.setConnectorID(p.getPileCode());
                newcInfo.setStatus(-1);
                connectorStatusMap.put(p.getId(), newcInfo);
            }
        }
    }

    private boolean notificationStationStatus(ConnectorStatusInfo cinfo) {
        try {
            JSONObject jsonobj = QueryActionUtil.notificationStationStatus(cinfo, localCacheUtil.getSecretKeyByOperatorID(operatorID));
            if (jsonobj == null) {
                logger.info("token获取失败。" + cinfo.getConnectorID() + "：状态推送失败！！！");
                return false;
            }

            int ret = getDataInt(jsonobj, "Ret");
            String data = getDataStr(jsonobj, "Data");
            JSONObject jsondata = getDecodeData(data, localCacheUtil.getSecretKeyByOperatorID(operatorID));

            if (RetTypeEnum.SUCCESS.getValue() == ret && getDataInt(jsondata, "Status") == 0) {
                logger.info(cinfo.getConnectorID() + "：状态推送成功！！！");
                return true;
            } else {
                // logger.info(cinfo.getConnectorID() + "：状态推送失败！！！");
                return false;
            }

        } catch (Exception e) {
            logger.info(cinfo.getConnectorID() + "：状态推送失败！！！");
            e.printStackTrace();
            return false;
        }
    }

}
