package com.holley.charging.model.def;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import com.holley.charging.common.util.ChargeInfo;
import com.holley.charging.common.util.ReaderResourceUtil;

/**
 * 充电配置 Description:
 *
 * @author shen.cheng@holley.cn
 */
public class ChargingConfig {

    private static long                            maxDelayTime = 90;                                       // 秒
    private static String                          domainOperatorId;
    private static String                          domainUrl;
    private static Map<String, ChargingConfigInfo> config       = new HashMap<String, ChargingConfigInfo>();

    /**
     * 运行商类型
     */
    public enum ChargingBussinessTypeEnum {
        ECW_CHARGING("348375727", "e充网"), DD_CHARING("101437000", "滴滴互联");

        private final String value;
        private final String text;

        ChargingBussinessTypeEnum(String value, String text) {
            this.value = value;
            this.text = text;
        }

        public String getValue() {
            return value;
        }

        public String getText() {
            return text;
        }

        public static String getText(String value) {
            ChargingBussinessTypeEnum task = getEnmuByValue(value);
            return task == null ? null : task.getText();
        }

        /**
         * 通过传入的值匹配枚举
         * 
         * @param value
         * @return
         */
        public static ChargingBussinessTypeEnum getEnmuByValue(String value) {
            for (ChargingBussinessTypeEnum record : ChargingBussinessTypeEnum.values()) {
                if (value.equals(record.getValue())) {
                    return record;
                }
            }
            return null;
        }

    }

    public static void init() {
        Properties p = ReaderResourceUtil.getClassPathProperties("openActive.properties");
        // 主站配置
        domainUrl = p.getProperty("domainUrl");
        domainOperatorId = p.getProperty("domainOperatorId");
        // 推送配置
        String[] chargeInfoKeys = p.getProperty("chargeInfoKeys").split(",");
        String[] notifyPayStatusInfoKeys = p.getProperty("notifyPayStatusInfoKeys").split(",");
        // 基本配置
        String[] operatorIds = p.getProperty("operatorIds").split(",");
        String[] activeUrls = p.getProperty("activeUrls").split(",");
        String[] payUrls = p.getProperty("payUrls").split(",");
        String[] chargingPhones = p.getProperty("chargingPhones").split(",");
        int size = operatorIds.length;
        ChargingConfigInfo info = null;
        for (int i = 0; i < size; i++) {
            info = new ChargingConfigInfo();
            info.setOperatorId(operatorIds[i]);
            info.setActiveUrl(activeUrls[i]);
            info.setPayUrl(payUrls[i]);
            info.setChargingPhone(chargingPhones[i]);
            info.setChargeInfoKey(chargeInfoKeys[i]);
            info.setNotifyPayStatusInfoKey(notifyPayStatusInfoKeys[i]);
            config.put(info.getOperatorId(), info);
        }
    }

    public static String getDomainOperatorId() {
        return domainOperatorId;
    }

    public static String getDomainUrl() {
        return domainUrl;
    }

    public static long getMaxDelayTime() {
        return maxDelayTime;
    }

    public static String getActiveUrl(String operatorId) {
        ChargingConfigInfo info = getChargingConfigInfo(operatorId);
        return info != null ? info.getActiveUrl() : null;
    }

    public static String getPayUrl(String operatorId) {
        ChargingConfigInfo info = getChargingConfigInfo(operatorId);
        return info != null ? info.getPayUrl() : null;
    }

    public static String getChargingPhone(String operatorId) {
        ChargingConfigInfo info = getChargingConfigInfo(operatorId);
        return info != null ? info.getChargingPhone() : null;
    }

    private static ChargingConfigInfo getChargingConfigInfo(String operatorId) {
        return config.get(operatorId);
    }

    public static Set<String> getOperatorIds() {
        return config.keySet();
    }

    public static String getOperatorIdByTradeNo(String tradeNo) {
        Set<String> oids = getOperatorIds();
        for (String oid : oids) {
            if (tradeNo.startsWith(oid) || tradeNo.startsWith("00000" + oid)) {
                return oid;
            }
        }
        return null;
    }

    public static ConcurrentHashMap<String, ChargeInfo> pushTask(ChargeInfo chargeInfo, String operatorId) {
        ChargingConfigInfo info = getChargingConfigInfo(operatorId);
        if (info != null) {
            return info.pushTask(chargeInfo);
        }
        return null;
    }

    public static String getChargeInfoKey(String operatorId) {
        ChargingConfigInfo info = getChargingConfigInfo(operatorId);
        if (info != null) {
            return info.getChargeInfoKey();
        }
        return null;
    }

    public static String getNotifyPayStatusInfoKey(String operatorId) {
        ChargingConfigInfo info = getChargingConfigInfo(operatorId);
        if (info != null) {
            return info.getNotifyPayStatusInfoKey();
        }
        return null;
    }

}
