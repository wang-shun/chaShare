package com.holley.charging.model.def;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Description: 充电接口状态
 *
 * @author shen.cheng@holley.cn
 */
public class StationStatusInfoBase {

    @JSONField(name = "Total")
    private Integer                 total;             // 总条数
    @JSONField(name = "StationStatusInfos")
    private List<StationStatusInfo> stationStatusInfos;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<StationStatusInfo> getStationStatusInfos() {
        return stationStatusInfos;
    }

    public void setStationStatusInfos(List<StationStatusInfo> stationStatusInfos) {
        this.stationStatusInfos = stationStatusInfos;
    }

}
