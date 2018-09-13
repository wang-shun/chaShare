package com.holley.charging.model.bus;

import java.math.BigDecimal;
import java.util.Date;

import com.holley.common.constants.charge.ChargeDealStatusEnum;
import com.holley.common.constants.charge.ChargePayStatusEnum;
import com.holley.common.constants.charge.PayWayEnum;
import com.holley.common.util.DateUtil;
import com.holley.common.util.NumberUtil;
import com.holley.platform.util.RoleUtil;

public class BusPayment {

    private Integer    id;

    private Integer    userId;

    private Integer    pileId;

    private String     tradeNo;

    private Short      chaMode;

    private Short      dealStatus;

    private BigDecimal parkFee;

    private BigDecimal chaFee;

    private BigDecimal serviceFee;

    private Date       startTime;

    private Date       endTime;

    private Integer    chaLen;

    private Double     chaPower;

    private BigDecimal shouldMoney;

    private BigDecimal actualMoney;

    private Short      payWay;

    private String     accountInfo;

    private Short      payStatus;

    private Short      isBill;

    private Date       updateTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPileId() {
        return pileId;
    }

    public void setPileId(Integer pileId) {
        this.pileId = pileId;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo == null ? null : tradeNo.trim();
    }

    public Short getChaMode() {
        return chaMode;
    }

    public void setChaMode(Short chaMode) {
        this.chaMode = chaMode;
    }

    public Short getDealStatus() {
        return dealStatus;
    }

    public void setDealStatus(Short dealStatus) {
        this.dealStatus = dealStatus;
    }

    public BigDecimal getParkFee() {
        return parkFee;
    }

    public void setParkFee(BigDecimal parkFee) {
        this.parkFee = parkFee;
    }

    public BigDecimal getChaFee() {
        return chaFee;
    }

    public void setChaFee(BigDecimal chaFee) {
        this.chaFee = chaFee;
    }

    public BigDecimal getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(BigDecimal serviceFee) {
        this.serviceFee = serviceFee;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
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

    public BigDecimal getShouldMoney() {
        return shouldMoney;
    }

    public void setShouldMoney(BigDecimal shouldMoney) {
        this.shouldMoney = shouldMoney;
    }

    public BigDecimal getActualMoney() {
        return actualMoney;
    }

    public void setActualMoney(BigDecimal actualMoney) {
        this.actualMoney = actualMoney;
    }

    public Short getPayWay() {
        return payWay;
    }

    public void setPayWay(Short payWay) {
        this.payWay = payWay;
    }

    public String getAccountInfo() {
        return accountInfo;
    }

    public void setAccountInfo(String accountInfo) {
        this.accountInfo = accountInfo == null ? null : accountInfo.trim();
    }

    public Short getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Short payStatus) {
        this.payStatus = payStatus;
    }

    public Short getIsBill() {
        return isBill;
    }

    public void setIsBill(Short isBill) {
        this.isBill = isBill;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }


  
}
