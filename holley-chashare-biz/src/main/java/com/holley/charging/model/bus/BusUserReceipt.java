package com.holley.charging.model.bus;

import java.math.BigDecimal;
import java.util.Date;

import com.holley.common.constants.charge.BillStatusEnum;
import com.holley.common.constants.charge.BillTypeEnum;
import com.holley.common.util.DateUtil;
import com.holley.common.util.NumberUtil;

public class BusUserReceipt {

    private Integer    id;

    private Integer    userId;

    private String     recipient;

    private String     phone;

    private String     expressNum;

    private String     expressCompany;

    private Short      billType;

    private String     billHead;

    private BigDecimal money;

    private Short      status;

    private String     address;

    private String     time;

    private Date       addTime;

    private String     validRemark;

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

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient == null ? null : recipient.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getExpressNum() {
        return expressNum;
    }

    public void setExpressNum(String expressNum) {
        this.expressNum = expressNum == null ? null : expressNum.trim();
    }

    public String getExpressCompany() {
        return expressCompany;
    }

    public void setExpressCompany(String expressCompany) {
        this.expressCompany = expressCompany == null ? null : expressCompany.trim();
    }

    public Short getBillType() {
        return billType;
    }

    public void setBillType(Short billType) {
        this.billType = billType;
    }

    public String getBillHead() {
        return billHead;
    }

    public void setBillHead(String billHead) {
        this.billHead = billHead == null ? null : billHead.trim();
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getValidRemark() {
        return validRemark;
    }

    public void setValidRemark(String validRemark) {
        this.validRemark = validRemark == null ? null : validRemark.trim();
    }

    public String getBillTypeDesc() {
        if (billType == null) return "";
        String desc = BillTypeEnum.getText(billType.intValue());
        return desc == null ? "" : desc;
    }

    public String getStatusDesc() {
        if (status == null) return "";
        String desc = BillStatusEnum.getText(status.intValue());
        return desc == null ? "" : desc;
    }

    public String getAddTimeDesc() {
        if (addTime == null) return "";
        return DateUtil.DateToLongStr(addTime);
    }

    public String getMoneyDesc() {
        if (money == null) return "";
        return NumberUtil.formateScale2Str(money);
    }
}
