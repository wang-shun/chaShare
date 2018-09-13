package com.holley.charging.model.bms;

import java.math.BigDecimal;
import java.util.Date;

import com.holley.common.constants.BillMarkTypeEnum;
import com.holley.common.util.DateUtil;
import com.holley.common.util.NumberUtil;

public class BillsDetail {

    private Integer    recordId;
    private String     checkCycle;
    private BigDecimal totalFeeOut;
    private BigDecimal appFee;
    private BigDecimal chaFee;
    private BigDecimal serviceFee;
    private BigDecimal parkFee;
    private Short      checkMark;
    private Date       addTime;
    private Integer    pileId;
    private String     stationPileName;

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public String getCheckCycle() {
        return checkCycle;
    }

    public void setCheckCycle(String checkCycle) {
        this.checkCycle = checkCycle;
    }

    public BigDecimal getTotalFeeOut() {
        return totalFeeOut;
    }

    public void setTotalFeeOut(BigDecimal totalFeeOut) {
        this.totalFeeOut = totalFeeOut;
    }

    public BigDecimal getAppFee() {
        return appFee;
    }

    public void setAppFee(BigDecimal appFee) {
        this.appFee = appFee;
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

    public BigDecimal getParkFee() {
        return parkFee;
    }

    public void setParkFee(BigDecimal parkFee) {
        this.parkFee = parkFee;
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

    public Integer getPileId() {
        return pileId;
    }

    public void setPileId(Integer pileId) {
        this.pileId = pileId;
    }

    public String getStationPileName() {
        return stationPileName;
    }

    public void setStationPileName(String stationPileName) {
        this.stationPileName = stationPileName;
    }

    public String getCheckMarkDesc() {
        if (checkMark == null) return "";
        String desc = BillMarkTypeEnum.getText(checkMark.shortValue());
        return desc == null ? "" : desc;
    }

    public String getAddTimeDesc() {
        if (addTime == null) return "";
        return DateUtil.DateToLongStr(addTime);
    }

    public String getTotalFeeOutDesc() {
        if (totalFeeOut == null) return "";
        return NumberUtil.formateScale2Str(totalFeeOut);
    }

    public String getAppFeeDesc() {
        if (appFee == null) return "";
        return NumberUtil.formateScale2Str(appFee);
    }

    public String getChaFeeDesc() {
        if (chaFee == null) return "";
        return NumberUtil.formateScale2Str(chaFee);
    }

    public String getServiceFeeDesc() {
        if (serviceFee == null) return "";
        return NumberUtil.formateScale2Str(serviceFee);
    }

    public String getParkFeeDesc() {
        if (parkFee == null) return "";
        return NumberUtil.formateScale2Str(parkFee);
    }

    public String getTotalFeeDesc() {
        BigDecimal total = BigDecimal.ZERO;
        if (appFee != null) {
            total = total.add(appFee);
        }
        if (chaFee != null) {
            total = total.add(chaFee);
        }
        if (serviceFee != null) {
            total = total.add(serviceFee);
        }
        if (parkFee != null) {
            total = total.add(parkFee);
        }
        return NumberUtil.formateScale2Str(total);
    }

}
