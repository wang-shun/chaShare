package com.holley.charging.model.def;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.holley.charging.common.util.ChargeInfo;
import com.holley.common.util.StringUtil;

public class ChargingConfigInfo {

    private String                                                           chargeInfoKey;
    private String                                                           notifyPayStatusInfoKey;
    private String                                                           operatorId;                                                                         // 充电平台编号
    private String                                                           chargingPhone;                                                                      // 充电主号码
    private String                                                           activeUrl;                                                                          // 接口主地址
    private String                                                           payUrl;
    private int                                                              maxMapSize = 10;
    private ConcurrentHashMap<String, ConcurrentHashMap<String, ChargeInfo>> task       = new ConcurrentHashMap<String, ConcurrentHashMap<String, ChargeInfo>>();

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public String getChargingPhone() {
        return chargingPhone;
    }

    public void setChargingPhone(String chargingPhone) {
        this.chargingPhone = chargingPhone;
    }

    public String getActiveUrl() {
        return activeUrl;
    }

    public void setActiveUrl(String activeUrl) {
        this.activeUrl = activeUrl;
    }

    public String getPayUrl() {
        return payUrl;
    }

    public void setPayUrl(String payUrl) {
        this.payUrl = payUrl;
    }

    public String getChargeInfoKey() {
        return chargeInfoKey;
    }

    public void setChargeInfoKey(String chargeInfoKey) {
        this.chargeInfoKey = chargeInfoKey;
    }

    public String getNotifyPayStatusInfoKey() {
        return notifyPayStatusInfoKey;
    }

    public void setNotifyPayStatusInfoKey(String notifyPayStatusInfoKey) {
        this.notifyPayStatusInfoKey = notifyPayStatusInfoKey;
    }

    public ConcurrentHashMap<String, ChargeInfo> pushTask(ChargeInfo chargeInfo) {
        String connectorID = chargeInfo.getConnectorID();
        if (StringUtil.isEmpty(connectorID)) {
            return null;
        }
        if (isContainsPushTask(connectorID)) {
            return null;
        }
        if (isNotFull()) {
            pushTkForAuto(chargeInfo);
        } else {
            System.out.println(operatorId + "数量:" + task.size());
            ConcurrentHashMap<String, ChargeInfo> newMap = new ConcurrentHashMap<String, ChargeInfo>();
            newMap.put(connectorID, chargeInfo);
            int count = task.size() + 1;
            task.put("task" + count, newMap);
            return newMap;
        }
        return null;
    }

    private boolean isContainsPushTask(String connectorID) {
        for (Map.Entry<String, ConcurrentHashMap<String, ChargeInfo>> e : task.entrySet()) {
            if (e.getValue().containsKey(connectorID)) {
                return true;
            }
        }
        return false;
    }

    private boolean isNotFull() {
        for (Map.Entry<String, ConcurrentHashMap<String, ChargeInfo>> e : task.entrySet()) {
            if (e.getValue().size() < maxMapSize) {
                return true;
            }
        }
        return false;
    }

    private void pushTkForAuto(ChargeInfo chargeInfo) {
        for (Map.Entry<String, ConcurrentHashMap<String, ChargeInfo>> e : task.entrySet()) {
            ConcurrentHashMap<String, ChargeInfo> tem = e.getValue();
            if (tem.size() < maxMapSize) {
                tem.put(chargeInfo.getConnectorID(), chargeInfo);
            }
        }
    }
}
