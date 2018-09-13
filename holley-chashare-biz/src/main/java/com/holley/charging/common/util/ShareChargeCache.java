package com.holley.charging.common.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.SerializationUtils;

import com.holley.charging.model.def.ChargingConfig;
import com.holley.charging.model.def.NotifyPayStatusInfo;
import com.holley.common.cache.RedisUtil;

public class ShareChargeCache extends RedisUtil {

    // 支付结果推送
    public synchronized static Map<byte[], byte[]> getNotifyPayStatusInfoMap(String oid) {
        return getByteMap(ChargingConfig.getNotifyPayStatusInfoKey(oid));
    }

    public synchronized static void addOrUpdateNotifyPayStatusInfo(NotifyPayStatusInfo notifyPayStatusInfo, String oid) {
        Map<byte[], byte[]> map = getNotifyPayStatusInfoMap(oid);
        map.put(notifyPayStatusInfo.getSeq().getBytes(), SerializationUtils.serialize(notifyPayStatusInfo));
        setHashByte(ChargingConfig.getNotifyPayStatusInfoKey(oid), map);
    }

    public synchronized static void removeNotifyPayStatusInfo(byte[] key, String oid) {
        hdel(ChargingConfig.getNotifyPayStatusInfoKey(oid), key);
    }

    // 充电中信息
    public static Map<byte[], byte[]> getChargeInfoMap(String oid) {
        return getByteMap(ChargingConfig.getChargeInfoKey(oid));
    }

    public static void addOrUpdateChargeInfo(ChargeInfo chargeInfo, String oid) {
        Map<byte[], byte[]> map = getChargeInfoMap(oid);
        map.put(chargeInfo.getTradeNo().getBytes(), SerializationUtils.serialize(chargeInfo));
        setHashByte(ChargingConfig.getChargeInfoKey(oid), map);
    }

    public static void removeChargeInfo(ChargeInfo chargeInfo, String oid) {
        hdel(ChargingConfig.getChargeInfoKey(oid), chargeInfo.getTradeNo().getBytes());
    }

    private synchronized static Map<byte[], byte[]> getByteMap(String key) {
        Map<byte[], byte[]> map = getHashByte(key);
        return map == null ? new HashMap<byte[], byte[]>() : map;
    }

    public static boolean islocal() {
        return false;
    }
}
