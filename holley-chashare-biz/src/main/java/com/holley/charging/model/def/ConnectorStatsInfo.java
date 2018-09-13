package com.holley.charging.model.def;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Description: 充电接口统计信息
 *
 * @author shen.cheng@holley.cn
 */
public class ConnectorStatsInfo {

    @JSONField(name = "ConnectorID")
    private String connectorID;         // 充电设备接口编码
    @JSONField(name = "ConnectorElectricity")
    private String connectorElectricity; // 充电设备接口累计电量

    public String getConnectorID() {
        return connectorID;
    }

    public void setConnectorID(String connectorID) {
        this.connectorID = connectorID;
    }

    public String getConnectorElectricity() {
        return connectorElectricity;
    }

    public void setConnectorElectricity(String connectorElectricity) {
        this.connectorElectricity = connectorElectricity;
    }

}
