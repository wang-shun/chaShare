package com.holley.charging.model.def;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

public class StationInfoBase extends PageBase {

    @JSONField(name = "StationInfos")
    private List<StationInfo> stationInfos;

    public List<StationInfo> getStationInfos() {
        return stationInfos;
    }

    public void setStationInfos(List<StationInfo> stationInfos) {
        this.stationInfos = stationInfos;
    }

}
