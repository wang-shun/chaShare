package com.holley.charging.model.pob;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.holley.common.constants.charge.ChargeCurrentTypeEnum;
import com.holley.common.constants.share.EquipmentTypeEnum;
import com.holley.common.util.DateUtil;
import com.holley.common.util.StringUtil;

public class PobChargingPile implements Serializable {

    private static final long serialVersionUID = -283234841837665525L;

    private Integer           id;

    private String            pileCode;

    private String            pileName;

    private Integer           stationId;

    private Short             status;

    private Short             pileType;

    private Integer           pileModel;

    private Short             intfType;

    private Short             chaWay;

    private Short             comType;

    private String            comAddr;

    private String            comSubAddr;

    private Short             isApp;

    private Short             isTimeCha;

    private Short             isRationCha;

    private Short             isMoneyCha;

    private Short             isControl;

    private Short             isChaLoad;

    private Date              buildTime;

    private String            doc;

    private Short             isFee;

    private Integer           feeRule;

    private BigDecimal        chargeFee;

    private BigDecimal        parkFee;

    private BigDecimal        serviceFee;

    private String            payWay;

    private String            address;

    private Short             isLock;

    private String            lockCode;

    private String            softVersion;

    private String            hardVersion;

    private Date              updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPileCode() {
        return pileCode;
    }

    public void setPileCode(String pileCode) {
        this.pileCode = pileCode == null ? null : pileCode.trim();
    }

    public String getPileName() {
        return pileName;
    }

    public void setPileName(String pileName) {
        this.pileName = pileName == null ? null : pileName.trim();
    }

    public Integer getStationId() {
        return stationId;
    }

    public void setStationId(Integer stationId) {
        this.stationId = stationId;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Short getPileType() {
        return pileType;
    }

    public void setPileType(Short pileType) {
        this.pileType = pileType;
    }

    public Integer getPileModel() {
        return pileModel;
    }

    public void setPileModel(Integer pileModel) {
        this.pileModel = pileModel;
    }

    public Short getIntfType() {
        return intfType;
    }

    public void setIntfType(Short intfType) {
        this.intfType = intfType;
    }

    public Short getChaWay() {
        return chaWay;
    }

    public void setChaWay(Short chaWay) {
        this.chaWay = chaWay;
    }

    public Short getComType() {
        return comType;
    }

    public void setComType(Short comType) {
        this.comType = comType;
    }

    public String getComAddr() {
        return comAddr;
    }

    public void setComAddr(String comAddr) {
        this.comAddr = comAddr == null ? null : comAddr.trim();
    }

    public String getComSubAddr() {
        return comSubAddr;
    }

    public void setComSubAddr(String comSubAddr) {
        this.comSubAddr = comSubAddr == null ? null : comSubAddr.trim();
    }

    public Short getIsApp() {
        return isApp;
    }

    public void setIsApp(Short isApp) {
        this.isApp = isApp;
    }

    public Short getIsTimeCha() {
        return isTimeCha;
    }

    public void setIsTimeCha(Short isTimeCha) {
        this.isTimeCha = isTimeCha;
    }

    public Short getIsRationCha() {
        return isRationCha;
    }

    public void setIsRationCha(Short isRationCha) {
        this.isRationCha = isRationCha;
    }

    public Short getIsMoneyCha() {
        return isMoneyCha;
    }

    public void setIsMoneyCha(Short isMoneyCha) {
        this.isMoneyCha = isMoneyCha;
    }

    public Short getIsControl() {
        return isControl;
    }

    public void setIsControl(Short isControl) {
        this.isControl = isControl;
    }

    public Short getIsChaLoad() {
        return isChaLoad;
    }

    public void setIsChaLoad(Short isChaLoad) {
        this.isChaLoad = isChaLoad;
    }

    public Date getBuildTime() {
        return buildTime;
    }

    public void setBuildTime(Date buildTime) {
        this.buildTime = buildTime;
    }

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc == null ? null : doc.trim();
    }

    public Short getIsFee() {
        return isFee;
    }

    public void setIsFee(Short isFee) {
        this.isFee = isFee;
    }

    public Integer getFeeRule() {
        return feeRule;
    }

    public void setFeeRule(Integer feeRule) {
        this.feeRule = feeRule;
    }

    public BigDecimal getChargeFee() {
        return chargeFee;
    }

    public void setChargeFee(BigDecimal chargeFee) {
        this.chargeFee = chargeFee;
    }

    public BigDecimal getParkFee() {
        return parkFee;
    }

    public void setParkFee(BigDecimal parkFee) {
        this.parkFee = parkFee;
    }

    public BigDecimal getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(BigDecimal serviceFee) {
        this.serviceFee = serviceFee;
    }

    public String getPayWay() {
        return payWay;
    }

    public void setPayWay(String payWay) {
        this.payWay = payWay == null ? null : payWay.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Short getIsLock() {
        return isLock;
    }

    public void setIsLock(Short isLock) {
        this.isLock = isLock;
    }

    public String getLockCode() {
        return lockCode;
    }

    public void setLockCode(String lockCode) {
        this.lockCode = lockCode == null ? null : lockCode.trim();
    }

    public String getSoftVersion() {
        return softVersion;
    }

    public void setSoftVersion(String softVersion) {
        this.softVersion = softVersion == null ? null : softVersion.trim();
    }

    public String getHardVersion() {
        return hardVersion;
    }

    public void setHardVersion(String hardVersion) {
        this.hardVersion = hardVersion == null ? null : hardVersion.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    // ADD
    public int getEquipmentType() {
        if (ChargeCurrentTypeEnum.AC.getShortValue().equals(chaWay)) {// 交流
            return EquipmentTypeEnum.AC.getValue();
        } else if (ChargeCurrentTypeEnum.DC.getShortValue().equals(chaWay)) {// 直流
            return EquipmentTypeEnum.DC.getValue();
        }
        return EquipmentTypeEnum.OTHER.getValue();
    }

    public String getEquipmentName() {
        if (StringUtil.isNotEmpty(pileName) && pileName.length() > 3) {
            return pileName.substring(0, 3);
        }
        return pileName;
    }

    public String getProductionDate() {
        if (buildTime != null) {
            return DateUtil.DateToShortStr(buildTime);
        }
        return null;
    }
}
