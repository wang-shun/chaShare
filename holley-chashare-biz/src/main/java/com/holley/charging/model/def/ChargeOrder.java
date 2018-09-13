package com.holley.charging.model.def;

import java.math.BigDecimal;

import com.alibaba.fastjson.annotation.JSONField;

public class ChargeOrder {

    @JSONField(name = "StartChargeSeq")
    private String     startChargeSeq; // 订单号
    @JSONField(name = "TotalPower")
    private BigDecimal totalPower;    // 总电量
    @JSONField(name = "TotalMoney")
    private BigDecimal totalMoney;    // 总金额

    public String getStartChargeSeq() {
        return startChargeSeq;
    }

    public void setStartChargeSeq(String startChargeSeq) {
        this.startChargeSeq = startChargeSeq;
    }

    public BigDecimal getTotalPower() {
        return totalPower;
    }

    public void setTotalPower(BigDecimal totalPower) {
        this.totalPower = totalPower;
    }

    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
    }

}
