package com.holley.charging.common.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

import net.sf.json.JSONObject;

import org.apache.commons.lang3.SerializationUtils;
import org.apache.log4j.Logger;

import com.holley.charging.model.def.NotifyPayStatusInfo;
import com.holley.charging.service.share.CommonService;

/**
 * Description: 用于e充网支付结果推送
 *
 * @author shen.cheng@holley.cn
 */
public class NotifyPayStatusJob extends JobBase {

    private ConcurrentHashMap<String, NotifyPayStatusInfo> task   = new ConcurrentHashMap<String, NotifyPayStatusInfo>();
    private final static Logger                            logger = Logger.getLogger(NotifyPayStatusJob.class);

    public NotifyPayStatusJob(String operatorID, LocalCacheUtil localCacheUtil, CommonService commonService) {
        super(operatorID, localCacheUtil, commonService);
    }

    @SuppressWarnings("unused")
    @Override
    public void run() {
        logger.info(operatorID + ":notifyPayStatusJob...");
        while (isRun) {
            try {
                Map<byte[], byte[]> notifyPayStatusInfoMap = ShareChargeCache.getNotifyPayStatusInfoMap(operatorID);
                if (notifyPayStatusInfoMap != null && !notifyPayStatusInfoMap.isEmpty()) {
                    // logger.info("有" + notifyPayStatusInfoMap.size() + "个支付结果推送请求。。。");
                    NotifyPayStatusInfo notifyPayStatusInfo = null;
                    for (Map.Entry<byte[], byte[]> e : notifyPayStatusInfoMap.entrySet()) {
                        try {
                            String key = new String(e.getKey());
                            if (!task.containsKey(key)) {
                                notifyPayStatusInfo = SerializationUtils.deserialize(e.getValue());
                                task.put(key, notifyPayStatusInfo);
                            } else {
                                notifyPayStatusInfo = task.get(key);
                            }
                            isChain = false;
                            int seconds = notifyPayStatusInfo.getDelay();
                            long now = System.currentTimeMillis();
                            long updatetime = notifyPayStatusInfo.getUpdateTime();
                            System.out.println(operatorID + "时间：" + (now - updatetime) / 1000);
                            System.out.println(operatorID + "info：" + JSONObject.fromObject(notifyPayStatusInfo));
                            if (notifyPayStatusInfo.getPushCount() > 9) {
                                isChain = true;
                                ShareChargeCache.removeNotifyPayStatusInfo(e.getKey(), operatorID);
                                task.remove(key);

                            } else if ((now - updatetime) / 1000 >= seconds) {
                                String rs = "";
                                if (ShareChargeCache.islocal()) {
                                    rs = "success";
                                } else {
                                    rs = QueryActionUtil.notificationPayStatus(notifyPayStatusInfo.getParams(), operatorID);
                                }

                                if ("success".equals(rs)) {
                                    ShareChargeCache.removeNotifyPayStatusInfo(e.getKey(), operatorID);
                                    task.remove(key);
                                    isChain = true;
                                    logger.info(operatorID + "订单号：" + getLocalStartChargeSeq(notifyPayStatusInfo.getSeq()) + "推送成功。。。");
                                } else {
                                    int c = notifyPayStatusInfo.getPushCount() + 1;
                                    notifyPayStatusInfo.setPushCount(c);
                                    notifyPayStatusInfo.setDelay(getDelayTime(c));
                                    notifyPayStatusInfo.setUpdateTime(System.currentTimeMillis());
                                    ShareChargeCache.addOrUpdateNotifyPayStatusInfo(notifyPayStatusInfo, operatorID);
                                }
                            }
                        } catch (Exception ee) {
                            ee.printStackTrace();
                            logger.info(operatorID + "error:" + ee.getMessage());
                            logger.info(operatorID + "订单号：" + getLocalStartChargeSeq(notifyPayStatusInfo.getSeq()) + "推送支付结果失败。。。");
                        }
                        TimeUnit.MILLISECONDS.sleep(500);
                    }
                } else {
                    TimeUnit.SECONDS.sleep(5);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private int getDelayTime(int count) {
        int delay = 0;
        switch (count) {
            case 1:
                delay = 15;
                break;
            case 2:
                delay = 15;
                break;
            case 3:
                delay = 30;
                break;
            case 4:
                delay = 180;
                break;
            case 5:
                delay = 1800;
                break;
            case 6:
                delay = 1800;
                break;
            case 7:
                delay = 1800;
                break;
            case 8:
                delay = 1800;
                break;
            case 9:
                delay = 3600;
                break;
            default:
                break;
        }
        return delay;
    }
}
