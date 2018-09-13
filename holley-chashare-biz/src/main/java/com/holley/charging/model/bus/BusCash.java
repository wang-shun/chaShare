package com.holley.charging.model.bus;

import java.math.BigDecimal;
import java.util.Date;

import com.holley.common.constants.charge.CashStatusEnum;
import com.holley.common.constants.charge.CashVerifyStatusEnum;
import com.holley.common.constants.charge.CashWayEnum;
import com.holley.common.constants.charge.UserTypeEnum;
import com.holley.common.util.DateUtil;
import com.holley.common.util.NumberUtil;
import com.holley.common.util.StringUtil;

public class BusCash {

    private Integer    id;

    private Integer    userId;

    private BigDecimal money;

    private String     remark;

    private Date       addTime;

    private Date       validTime;

    private String     validRemark;

    private Short      validStatus;

    private Short      cashWay;

    private String     accountInfo;

    private Short      cashStatus;


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

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
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

    public Date getValidTime() {
        return validTime;
    }

    public void setValidTime(Date validTime) {
        this.validTime = validTime;
    }

    public String getValidRemark() {
        return validRemark;
    }

    public void setValidRemark(String validRemark) {
        this.validRemark = validRemark == null ? null : validRemark.trim();
    }

    public Short getValidStatus() {
        return validStatus;
    }

    public void setValidStatus(Short validStatus) {
        this.validStatus = validStatus;
    }

    public Short getCashWay() {
        return cashWay;
    }

    public void setCashWay(Short cashWay) {
        this.cashWay = cashWay;
    }

    public String getAccountInfo() {
        return accountInfo;
    }

    public void setAccountInfo(String accountInfo) {
        this.accountInfo = accountInfo == null ? null : accountInfo.trim();
    }

    public Short getCashStatus() {
        return cashStatus;
    }

    public void setCashStatus(Short cashStatus) {
        this.cashStatus = cashStatus;
    }

}
