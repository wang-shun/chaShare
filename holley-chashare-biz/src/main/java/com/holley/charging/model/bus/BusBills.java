package com.holley.charging.model.bus;

import java.math.BigDecimal;
import java.util.Date;

import com.holley.common.util.DateUtil;
import com.holley.common.util.NumberUtil;

public class BusBills {

    private Integer    id;

    private Integer    userId;

    private String     checkCycle;

    private BigDecimal totalFee;

    private BigDecimal appFeeIn;

    private BigDecimal chaFeeIn;

    private BigDecimal serviceFeeIn;

    private BigDecimal parkFeeIn;

    private BigDecimal rechargeFee;

    private BigDecimal cashFee;

    private BigDecimal appFeeOut;

    private BigDecimal chaFeeOut;

    private BigDecimal serviceFeeOut;

    private BigDecimal parkFeeOut;

    private Short      checkType;

    private Integer    receiptId;

    private Date       addTime;

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

    public BigDecimal getRechargeFee() {
        return rechargeFee;
    }

    public void setRechargeFee(BigDecimal rechargeFee) {
        this.rechargeFee = rechargeFee;
    }

    public BigDecimal getCashFee() {
        return cashFee;
    }

    public void setCashFee(BigDecimal cashFee) {
        this.cashFee = cashFee;
    }

    public BigDecimal getAppFeeOut() {
        return appFeeOut;
    }

    public void setAppFeeOut(BigDecimal appFeeOut) {
        this.appFeeOut = appFeeOut;
    }

    public BigDecimal getChaFeeOut() {
        return chaFeeOut;
    }

    public void setChaFeeOut(BigDecimal chaFeeOut) {
        this.chaFeeOut = chaFeeOut;
    }

    public BigDecimal getServiceFeeOut() {
        return serviceFeeOut;
    }

    public void setServiceFeeOut(BigDecimal serviceFeeOut) {
        this.serviceFeeOut = serviceFeeOut;
    }

    public BigDecimal getParkFeeOut() {
        return parkFeeOut;
    }

    public void setParkFeeOut(BigDecimal parkFeeOut) {
        this.parkFeeOut = parkFeeOut;
    }

    public Short getCheckType() {
        return checkType;
    }

    public void setCheckType(Short checkType) {
        this.checkType = checkType;
    }

    public Integer getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(Integer receiptId) {
        this.receiptId = receiptId;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getAddTimeDesc() {
        if (addTime == null) return "";
        return DateUtil.DateToLongStr(addTime);
    }

    public String getTotalFeeOutDesc() {
        BigDecimal totalOut;
        BigDecimal appOut = NumberUtil.getNotNUll(appFeeOut);
        BigDecimal chaOut = NumberUtil.getNotNUll(chaFeeOut);
        BigDecimal serviceOut = NumberUtil.getNotNUll(serviceFeeOut);
        BigDecimal parkOut = NumberUtil.getNotNUll(parkFeeOut);
        totalOut = NumberUtil.add(appOut, chaOut);
        totalOut = NumberUtil.add(totalOut, serviceOut);
        totalOut = NumberUtil.add(totalOut, parkOut);
        return totalOut.toString();
    }

    public String getTotalFeeInDesc() {
        BigDecimal totalIn;
        BigDecimal appIn = NumberUtil.getNotNUll(appFeeIn);
        BigDecimal chaIn = NumberUtil.getNotNUll(chaFeeIn);
        BigDecimal serviceIn = NumberUtil.getNotNUll(serviceFeeIn);
        BigDecimal parkIn = NumberUtil.getNotNUll(parkFeeIn);
        totalIn = NumberUtil.add(appIn, chaIn);
        totalIn = NumberUtil.add(totalIn, serviceIn);
        totalIn = NumberUtil.add(totalIn, parkIn);
        return totalIn.toString();
    }

    public String getTotalFeeDesc() {
        if (totalFee == null) return "";
        return NumberUtil.formateScale2Str(totalFee);
    }

    public String getAppFeeInDesc() {
        if (appFeeIn == null) return "";
        return NumberUtil.formateScale2Str(appFeeIn);
    }

    public String getChaFeeInDesc() {
        if (chaFeeIn == null) return "";
        return NumberUtil.formateScale2Str(chaFeeIn);
    }

    public String getServiceFeeInDesc() {
        if (serviceFeeIn == null) return "";
        return NumberUtil.formateScale2Str(serviceFeeIn);
    }

    public String getParkFeeInDesc() {
        if (parkFeeIn == null) return "";
        return NumberUtil.formateScale2Str(parkFeeIn);
    }

    public String getRechargeFeeDesc() {
        if (rechargeFee == null) return "";
        return NumberUtil.formateScale2Str(rechargeFee);
    }

    public String getCashFeeDesc() {
        if (cashFee == null) return "";
        return NumberUtil.formateScale2Str(cashFee);
    }

    public String getAppFeeOutDesc() {
        if (appFeeOut == null) return "";
        return NumberUtil.formateScale2Str(appFeeOut);
    }

    public String getChaFeeOutDesc() {
        if (chaFeeOut == null) return "";
        return NumberUtil.formateScale2Str(chaFeeOut);
    }

    public String getServiceFeeOutDesc() {
        if (serviceFeeOut == null) return "";
        return NumberUtil.formateScale2Str(serviceFeeOut);
    }

    public String getParkFeeOutDesc() {
        if (parkFeeOut == null) return "";
        return NumberUtil.formateScale2Str(parkFeeOut);
    }

    public String getReceiptIdDesc() {
        if (receiptId != null && receiptId > 0) {
            return "已开票";
        } else {
            return "未开票";
        }
    }
}
