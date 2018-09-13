package com.holley.charging.model.bus;

import java.math.BigDecimal;
import java.util.Date;

import com.holley.common.util.NumberUtil;

public class BusAccount {

    private Integer    userId;

    private Short      status;

    private BigDecimal totalMoney;

    private BigDecimal usableMoney;

    private BigDecimal freezeMoney;

    private Date       updateTime;

    private BigDecimal totalin;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public BigDecimal getTotalMoney() {
        if (totalMoney != null) {
            totalMoney = NumberUtil.formateScale2(totalMoney);
        }
        return totalMoney;
    }

    public void setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
    }

    public BigDecimal getUsableMoney() {
        if (usableMoney != null) {
            usableMoney = NumberUtil.formateScale2(usableMoney);
        }
        return usableMoney;
    }

    public void setUsableMoney(BigDecimal usableMoney) {
        this.usableMoney = usableMoney;
    }

    public BigDecimal getFreezeMoney() {
        if (freezeMoney != null) {
            freezeMoney = NumberUtil.formateScale2(freezeMoney);
        }
        return freezeMoney;
    }

    public void setFreezeMoney(BigDecimal freezeMoney) {
        this.freezeMoney = freezeMoney;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public BigDecimal getTotalin() {
        return totalin;
    }

    public void setTotalin(BigDecimal totalin) {
        this.totalin = totalin;
    }

}
