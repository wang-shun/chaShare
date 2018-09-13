package com.holley.charging.model.def;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Description: 统计信息
 *
 * @author shen.cheng@holley.cn
 */
public class StationStatsInfoBase {

    @JSONField(name = "StationStats")
    private StationStatsInfo stationStats;

    public StationStatsInfo getStationStats() {
        return stationStats;
    }

    public void setStationStats(StationStatsInfo stationStats) {
        this.stationStats = stationStats;
    }

}
