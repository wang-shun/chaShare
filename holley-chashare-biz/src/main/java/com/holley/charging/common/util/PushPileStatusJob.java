package com.holley.charging.common.util;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import redis.clients.jedis.exceptions.JedisException;

import com.holley.charging.model.def.ConnectorStatusInfo;
import com.holley.charging.service.share.CommonService;
import com.holley.common.constants.charge.PileStatusEnum;
import com.holley.common.dataobject.PileStatusBean;
import com.holley.platform.model.sys.SysSecretKey;

public class PushPileStatusJob extends JobBase {

    private final static Logger                   logger = Logger.getLogger(PushPileStatusJob.class);
    private boolean                               isRun  = true;
    private ConcurrentHashMap<String, ChargeInfo> task   = null;
    private SysSecretKey                          sysSecretKey;

    public PushPileStatusJob(String operatorID, LocalCacheUtil localCacheUtil, CommonService commonService, ConcurrentHashMap<String, ChargeInfo> task) {
        super(operatorID, localCacheUtil, commonService);
        this.task = task;
        sysSecretKey = localCacheUtil.getSecretKeyByOperatorID(operatorID);
    }

    @Override
    public void run() {
        logger.info(operatorID + "推送任务：" + Thread.currentThread().getName() + "启动。。。");
        while (isRun) {
            try {
                if (!task.isEmpty()) {
                    // System.out.println(Thread.currentThread().getName() + ":===" + task.size());
                    for (Map.Entry<String, ChargeInfo> e : task.entrySet()) {
                        ChargeInfo chargeInfo = e.getValue();
                        try {
                            PileStatusBean p = localCacheUtil.returnPileStatusBean(chargeInfo.getPileId());// 获取实时桩状态
                            // TEST
                            // if (p.getId().equals(125)) {
                            // p.setStatus(PileStatusEnum.BUSYING);
                            // }
                            // TEST
                            if (p != null && chargeInfo.getUpStatus() != p.getStatus().getValue()) {
                                logger.info(operatorID + ">>>" + chargeInfo.getConnectorID() + "推送。。。" + p.getStatus());
                                ConnectorStatusInfo cinfo = new ConnectorStatusInfo();
                                chargeInfo.setUpdateTime(new Date());
                                if (chargeInfo.getUpStatus() == PileStatusEnum.CHARGING.getValue()) {
                                    if (chargeInfo.getCount() >= 1) {
                                        cinfo.setStatus(this.localCacheUtil.returnPileStatus(p.getStatus()).getValue());
                                        cinfo.setConnectorID(chargeInfo.getConnectorID());
                                        JSONObject jsonobj = QueryActionUtil.notificationStationStatus(cinfo, sysSecretKey);
                                        if (jsonobj != null) {
                                            chargeInfo.setUpStatus(p.getStatus().getValue());
                                            chargeInfo.setCount(0);
                                        }
                                    } else {
                                        chargeInfo.setCount(chargeInfo.getCount() + 1);
                                    }
                                } else {

                                    cinfo.setStatus(this.localCacheUtil.returnPileStatus(p.getStatus()).getValue());
                                    cinfo.setConnectorID(chargeInfo.getConnectorID());
                                    JSONObject jsonobj = QueryActionUtil.notificationStationStatus(cinfo, sysSecretKey);
                                    if (jsonobj != null) {
                                        chargeInfo.setUpStatus(p.getStatus().getValue());
                                        chargeInfo.setCount(0);
                                    }
                                }
                            }

                        } catch (JedisException je) {
                            logger.info(operatorID + "redisPool error");
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        TimeUnit.SECONDS.sleep(1);
                    }
                } else {
                    TimeUnit.SECONDS.sleep(5);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
