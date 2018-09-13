package com.holley.charging.model.bus;

import java.math.BigDecimal;

import com.holley.common.constants.charge.BusRealVerifyStatusEnum;
import com.holley.common.util.DateUtil;

public class BusBussinessReal extends BusBussinessRealKey {

    private String     busName;

    private String     accRealName;

    private String     bankAccount;

    private String     bankName;

    private String     licenceImg;

    private String     corporateImg;

    private String     transatorImg;

    private Short      validStatus;

    private BigDecimal validMoney;

    private String     validCode;

    private String     remark;

    private Integer    userId;

    public String getBusName() {
        return busName;
    }

    public void setBusName(String busName) {
        this.busName = busName == null ? null : busName.trim();
    }

    public String getAccRealName() {
        return accRealName;
    }

    public void setAccRealName(String accRealName) {
        this.accRealName = accRealName == null ? null : accRealName.trim();
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount == null ? null : bankAccount.trim();
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    public String getLicenceImg() {
        return licenceImg;
    }

    public void setLicenceImg(String licenceImg) {
        this.licenceImg = licenceImg == null ? null : licenceImg.trim();
    }

    public String getCorporateImg() {
        return corporateImg;
    }

    public void setCorporateImg(String corporateImg) {
        this.corporateImg = corporateImg == null ? null : corporateImg.trim();
    }

    public String getTransatorImg() {
        return transatorImg;
    }

    public void setTransatorImg(String transatorImg) {
        this.transatorImg = transatorImg == null ? null : transatorImg.trim();
    }

    public Short getValidStatus() {
        return validStatus;
    }

    public void setValidStatus(Short validStatus) {
        this.validStatus = validStatus;
    }

    public BigDecimal getValidMoney() {
        return validMoney;
    }

    public void setValidMoney(BigDecimal validMoney) {
        this.validMoney = validMoney;
    }

    public String getValidCode() {
        return validCode;
    }

    public void setValidCode(String validCode) {
        this.validCode = validCode == null ? null : validCode.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getValidStatusDesc() {
        if (validStatus == null) return "";
        String desc = BusRealVerifyStatusEnum.getText(validStatus.intValue());
        return desc == null ? "" : desc;
    }

    public String getAddTimeStr() {
        if (getAddTime() == null) return "";
        return DateUtil.DateToLongStr(getAddTime());
    }

}
