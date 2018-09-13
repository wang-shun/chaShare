package com.holley.charging.model.bms;

import com.holley.charging.model.bus.BusBillsDetail;

public class BillsDetailIn extends BusBillsDetail {

    private String  phone;
    private String  stationPileName;
    private Integer pileId;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStationPileName() {
        return stationPileName;
    }

    public void setStationPileName(String stationPileName) {
        this.stationPileName = stationPileName;
    }

    public Integer getPileId() {
        return pileId;
    }

    public void setPileId(Integer pileId) {
        this.pileId = pileId;
    }

}
