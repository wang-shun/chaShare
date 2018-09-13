package com.holley.charging.model.def;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Description: 充电设备统计信息
 *
 * @author shen.cheng@holley.cn
 */
public class EquipmentStatsInfo {

    @JSONField(name = "EquipmentID")
    private String                   equipmentID;         // 设备编码
    @JSONField(name = "EquipmentElectricity")
    private String                   equipmentElectricity; // 充电设备接口累计电量
    @JSONField(name = "ConnectorStatsInfos")
    private List<ConnectorStatsInfo> connectorStatsInfos; // 充电设备接口统计信息列表

    public String getEquipmentID() {
        return equipmentID;
    }

    public void setEquipmentID(String equipmentID) {
        this.equipmentID = equipmentID;
    }

    public String getEquipmentElectricity() {
        return equipmentElectricity;
    }

    public void setEquipmentElectricity(String equipmentElectricity) {
        this.equipmentElectricity = equipmentElectricity;
    }

    public List<ConnectorStatsInfo> getConnectorStatsInfos() {
        return connectorStatsInfos;
    }

    public void setConnectorStatsInfos(List<ConnectorStatsInfo> connectorStatsInfos) {
        this.connectorStatsInfos = connectorStatsInfos;
    }

}
