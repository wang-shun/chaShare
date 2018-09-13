package com.holley.common.dataobject.charging.dcs;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class DcsMonitor implements Serializable {

    private static final long serialVersionUID = -5273942139425190442L;

    private Integer           pileId;

    private Integer           chaLen;

    private Double            chaPower;

    private BigDecimal        money;

    private String            outV;

    private String            outI;

    private Short             status;

    private Short             isOnline;

    private Short             isCharging;

    private Date              updateTime;

    public Integer getPileId() {
        return pileId;
    }

    public void setPileId(Integer pileId) {
        this.pileId = pileId;
    }

    public Integer getChaLen() {
        return chaLen;
    }

    public void setChaLen(Integer chaLen) {
        this.chaLen = chaLen;
    }

    public Double getChaPower() {
        return chaPower;
    }

    public void setChaPower(Double chaPower) {
        this.chaPower = chaPower;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getOutV() {
        return outV;
    }

    public void setOutV(String outV) {
        this.outV = outV == null ? null : outV.trim();
    }

    public String getOutI() {
        return outI;
    }

    public void setOutI(String outI) {
        this.outI = outI == null ? null : outI.trim();
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Short getIsOnline() {
        return isOnline;
    }

    public void setIsOnline(Short isOnline) {
        this.isOnline = isOnline;
    }

    public Short getIsCharging() {
        return isCharging;
    }

    public void setIsCharging(Short isCharging) {
        this.isCharging = isCharging;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
