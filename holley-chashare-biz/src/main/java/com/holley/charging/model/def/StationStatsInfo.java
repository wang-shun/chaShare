package com.holley.charging.model.def;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Description: 充电站统计信息
 *
 * @author shen.cheng@holley.cn
 */
public class StationStatsInfo {

    @JSONField(name = "StationID")
    private String           stationID;          // 充电站ID
    @JSONField(name = "StartTime")
    private String           startTime;          // 统计开始时间 yyyy-MM-dd
    @JSONField(name = "EndTime")
    private String           endTime;            // 充电结束时间 yyyy-MM-dd
    @JSONField(name = "StationElectricity")
    private String           stationElectricity; // 充电站累计电量
    @JSONField(name = "EquipmentStatsInfos")
    List<EquipmentStatsInfo> equipmentStatsInfos; // 充电设备统计信息列表

    public String getStationID() {
        return stationID;
    }

    public void setStationID(String stationID) {
        this.stationID = stationID;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getStationElectricity() {
        return stationElectricity;
    }

    public void setStationElectricity(String stationElectricity) {
        this.stationElectricity = stationElectricity;
    }

    public List<EquipmentStatsInfo> getEquipmentStatsInfos() {
        return equipmentStatsInfos;
    }

    public void setEquipmentStatsInfos(List<EquipmentStatsInfo> equipmentStatsInfos) {
        this.equipmentStatsInfos = equipmentStatsInfos;
    }

}
