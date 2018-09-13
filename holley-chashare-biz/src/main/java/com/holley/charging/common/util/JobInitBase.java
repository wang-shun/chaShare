package com.holley.charging.common.util;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.Resource;

import org.apache.commons.lang3.SerializationUtils;
import org.apache.log4j.Logger;

import com.holley.charging.model.def.ChargingConfig;
import com.holley.charging.model.pob.PobChargingPile;
import com.holley.charging.service.share.CommonService;

public class JobInitBase {

    private final static Logger logger          = Logger.getLogger(JobInitBase.class);
    private ExecutorService     fixThreadPool   = Executors.newFixedThreadPool(10);
    private ExecutorService     cacheThreadPool = Executors.newCachedThreadPool();
    // e充网
    // private static ConcurrentHashMap<String, ConcurrentHashMap<String, ChargeInfo>> TASK_MAP = new
    // ConcurrentHashMap<String, ConcurrentHashMap<String, ChargeInfo>>();
    // private final static String KEY_NAME = "TASK";
    // 滴滴互联
    // private static ConcurrentHashMap<String, ConcurrentHashMap<String, ChargeInfo>> TASK_MAP_DD = new
    // ConcurrentHashMap<String, ConcurrentHashMap<String, ChargeInfo>>();
    // private final static String KEY_NAME_DD = "TASK_DD";

    @Resource
    private LocalCacheUtil      localCacheUtil;
    @Resource
    private CommonService       commonService;

    private void init() {
        initJob();
    }

    // 主job初始化
    private void initJob() {
        initCountJob();
        Set<String> oids = ChargingConfig.getOperatorIds();
        // 多充电平台初始化
        for (String oid : oids) {
            // if (ChargingBussinessTypeEnum.DD_CHARING.getValue().equals(oid)) {
            initPushPayTask(oid);
            initChargeTask(oid);
            initPushTask(oid);
            // }
        }
    }

    // 计数任务
    private void initCountJob() {
        fixThreadPool.execute(new CountJob());
    }

    // 支付回调推送
    private void initPushPayTask(String oid) {
        fixThreadPool.execute(new NotifyPayStatusJob(oid, localCacheUtil, commonService));
    }

    // 桩充电服务
    private void initChargeTask(String oid) {
        Map<byte[], byte[]> doChargeMap = ShareChargeCache.getChargeInfoMap(oid);
        if (doChargeMap != null && !doChargeMap.isEmpty()) {
            for (Map.Entry<byte[], byte[]> e : doChargeMap.entrySet()) {
                ChargeInfo cinfo = SerializationUtils.deserialize(e.getValue());
                pushChargeJob(cinfo, oid);
            }
        }
    }

    // 单一运营商桩状态推送服务初始化
    private void initPushTask(String oid) {
        List<PobChargingPile> list = localCacheUtil.getAllPile();
        logger.info(oid + "推送桩数量：" + list.size());
        if (list != null && list.size() > 0) {
            Date now = new Date();
            for (PobChargingPile pile : list) {
                ChargeInfo chargeInfo = new ChargeInfo();
                chargeInfo.setConnectorID(pile.getPileCode());
                chargeInfo.setPileId(pile.getId());
                chargeInfo.setUpdateTime(now);
                pushTask(chargeInfo, oid);
            }
        }
    }

    public void pushTask(ChargeInfo chargeInfo, String oid) {
        ConcurrentHashMap<String, ChargeInfo> task = ChargingConfig.pushTask(chargeInfo, oid);
        if (task != null) {
            cacheThreadPool.execute(new PushPileStatusJob(oid, localCacheUtil, commonService, task));
        }
    }

    public void pushChargeJob(ChargeInfo cinfo, String oid) {
        cacheThreadPool.execute(new ChargeJob(oid, localCacheUtil, commonService, cinfo));
    }

    // public void pushTask(ChargeInfo chargeInfo, String oid) {
    // String connectorID = chargeInfo.getConnectorID();
    // String pushKeyName = getPushKeyName(oid);
    // ConcurrentHashMap<String, ConcurrentHashMap<String, ChargeInfo>> pushMap = getPushMap(oid);
    // if (StringUtil.isEmpty(connectorID)) {
    // return;
    // }
    // if (isContainsPushTask(connectorID, pushMap)) {
    // return;
    // }
    // if (isNotFull(pushMap)) {
    // pushTkForAuto(chargeInfo, pushMap);
    // } else {
    // logger.info(oid + "数量:" + pushMap.size());
    // ConcurrentHashMap<String, ChargeInfo> newMap = new ConcurrentHashMap<String, ChargeInfo>();
    // newMap.put(connectorID, chargeInfo);
    // int count = pushMap.size() + 1;
    // pushMap.put(pushKeyName + count, newMap);
    // cacheThreadPool.execute(new PushPileStatusJob(oid, localCacheUtil, commonService, newMap));
    // }
    // }
    //
    // private boolean isContainsPushTask(String connectorID, ConcurrentHashMap<String, ConcurrentHashMap<String,
    // ChargeInfo>> map) {
    // for (Map.Entry<String, ConcurrentHashMap<String, ChargeInfo>> e : map.entrySet()) {
    // if (e.getValue().containsKey(connectorID)) {
    // return true;
    // }
    // }
    // return false;
    // }
    //
    // private boolean isNotFull(ConcurrentHashMap<String, ConcurrentHashMap<String, ChargeInfo>> map) {
    // for (Map.Entry<String, ConcurrentHashMap<String, ChargeInfo>> e : map.entrySet()) {
    // if (e.getValue().size() < MAX_MAP_SIZE) {
    // return true;
    // }
    // }
    // return false;
    // }
    //
    // private void pushTkForAuto(ChargeInfo chargeInfo, ConcurrentHashMap<String, ConcurrentHashMap<String,
    // ChargeInfo>> map) {
    // for (Map.Entry<String, ConcurrentHashMap<String, ChargeInfo>> e : map.entrySet()) {
    // ConcurrentHashMap<String, ChargeInfo> tem = e.getValue();
    // if (tem.size() < MAX_MAP_SIZE) {
    // tem.put(chargeInfo.getConnectorID(), chargeInfo);
    // }
    // }
    // }

    // private String getPushKeyName(String oid) {
    // String tem = "";
    // ChargingBussinessTypeEnum b = ChargingBussinessTypeEnum.getEnmuByValue(oid);
    // switch (b) {
    // case ECW_CHARGING:
    // tem = KEY_NAME;
    // break;
    // case DD_CHARING:
    // tem = KEY_NAME_DD;
    // break;
    // default:
    // break;
    // }
    // return tem;
    // }
    //
    // /**
    // * @param 第三方充电平台oid
    // * @return
    // */
    // private ConcurrentHashMap<String, ConcurrentHashMap<String, ChargeInfo>> getPushMap(String oid) {
    // ConcurrentHashMap<String, ConcurrentHashMap<String, ChargeInfo>> tem = null;
    // ChargingBussinessTypeEnum b = ChargingBussinessTypeEnum.getEnmuByValue(oid);
    // switch (b) {
    // case ECW_CHARGING:
    // tem = TASK_MAP;
    // break;
    // case DD_CHARING:
    // tem = TASK_MAP_DD;
    // break;
    // default:
    // break;
    // }
    // return tem;
    // }

}
