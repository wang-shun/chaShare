package com.holley.charging.model.def;

import java.math.BigDecimal;

import com.alibaba.fastjson.annotation.JSONField;

public class PolicyInfo {

    @JSONField(name = "StartTime")
    private String     startTime;

    @JSONField(name = "ElecPrice")
    private BigDecimal elecPrice;

    @JSONField(name = "SevicePrice")
    private BigDecimal sevicePrice;

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public BigDecimal getElecPrice() {
        return elecPrice;
    }

    public void setElecPrice(BigDecimal elecPrice) {
        this.elecPrice = elecPrice;
    }

    public BigDecimal getSevicePrice() {
        return sevicePrice;
    }

    public void setSevicePrice(BigDecimal sevicePrice) {
        this.sevicePrice = sevicePrice;
    }

}
