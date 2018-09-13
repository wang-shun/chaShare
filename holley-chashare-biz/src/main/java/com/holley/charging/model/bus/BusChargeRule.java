package com.holley.charging.model.bus;

import java.math.BigDecimal;
import java.util.Date;

import com.holley.common.util.NumberUtil;

public class BusChargeRule {

    private Integer    id;

    private String     name;

    private BigDecimal jianFee;

    private BigDecimal fengFee;

    private BigDecimal pingFee;

    private BigDecimal guFee;

    private String     remark;

    private Date       addTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public BigDecimal getJianFee() {
        if (jianFee != null) {
            jianFee = jianFee.setScale(2);
        }
        return jianFee;
    }

    public void setJianFee(BigDecimal jianFee) {
        this.jianFee = jianFee;
    }

    public BigDecimal getFengFee() {
        if (fengFee != null) {
            fengFee = NumberUtil.formateScale2(fengFee);
        }
        return fengFee;
    }

    public void setFengFee(BigDecimal fengFee) {
        this.fengFee = fengFee;
    }

    public BigDecimal getPingFee() {
        if (pingFee != null) {
            pingFee = NumberUtil.formateScale2(pingFee);
        }
        return pingFee;
    }

    public void setPingFee(BigDecimal pingFee) {
        this.pingFee = pingFee;
    }

    public BigDecimal getGuFee() {
        if (guFee != null) {
            guFee = NumberUtil.formateScale2(guFee);
        }
        return guFee;
    }

    public void setGuFee(BigDecimal guFee) {
        this.guFee = guFee;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}
