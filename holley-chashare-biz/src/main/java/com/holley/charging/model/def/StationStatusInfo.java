package com.holley.charging.model.def;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Description: 充电站状态
 *
 * @author shen.cheng@holley.cn
 */
public class StationStatusInfo {

    @JSONField(name = "StationID")
    private String                    stationID;           // 充电站ID
    @JSONField(name = "ConnectorStatusInfos")
    private List<ConnectorStatusInfo> connectorStatusInfos; // 充电接口状态列表

    public String getStationID() {
        return stationID;
    }

    public void setStationID(String stationID) {
        this.stationID = stationID;
    }

    public List<ConnectorStatusInfo> getConnectorStatusInfos() {
        return connectorStatusInfos;
    }

    public void setConnectorStatusInfos(List<ConnectorStatusInfo> connectorStatusInfos) {
        this.connectorStatusInfos = connectorStatusInfos;
    }

}
