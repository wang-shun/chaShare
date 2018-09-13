package com.holley.charging.model.bus;

import java.math.BigDecimal;
import java.util.Date;

import com.holley.common.constants.BillMarkTypeEnum;
import com.holley.common.util.DateUtil;
import com.holley.common.util.NumberUtil;

public class BusBillsDetail {

    private Integer    id;

    private Integer    recordId;

    private Integer    userId;

    private String     checkCycle;

    private BigDecimal totalFee;

    private BigDecimal appFeeIn;

    private BigDecimal chaFeeIn;

    private BigDecimal serviceFeeIn;

    private BigDecimal parkFeeIn;

    private Short      checkMark;

    private Date       addTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCheckCycle() {
        return checkCycle;
    }

    public void setCheckCycle(String checkCycle) {
        this.checkCycle = checkCycle == null ? null : checkCycle.trim();
    }

    public BigDecimal getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(BigDecimal totalFee) {
        this.totalFee = totalFee;
    }

    public BigDecimal getAppFeeIn() {
        return appFeeIn;
    }

    public void setAppFeeIn(BigDecimal appFeeIn) {
        this.appFeeIn = appFeeIn;
    }

    public BigDecimal getChaFeeIn() {
        return chaFeeIn;
    }

    public void setChaFeeIn(BigDecimal chaFeeIn) {
        this.chaFeeIn = chaFeeIn;
    }

    public BigDecimal getServiceFeeIn() {
        return serviceFeeIn;
    }

    public void setServiceFeeIn(BigDecimal serviceFeeIn) {
        this.serviceFeeIn = serviceFeeIn;
    }

    public BigDecimal getParkFeeIn() {
        return parkFeeIn;
    }

    public void setParkFeeIn(BigDecimal parkFeeIn) {
        this.parkFeeIn = parkFeeIn;
    }

    public Short getCheckMark() {
        return checkMark;
    }

    public void setCheckMark(Short checkMark) {
        this.checkMark = checkMark;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

}
