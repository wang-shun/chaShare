package com.holley.charging.model.bus;

import java.math.BigDecimal;
import java.util.Date;

import com.holley.common.constants.charge.PayWayEnum;
import com.holley.common.constants.charge.RechargeStatusEnum;
import com.holley.common.util.DateUtil;
import com.holley.common.util.NumberUtil;

public class BusRecharge {

    private Integer    id;

    private String     tradeNo;

    private Integer    userId;

    private Short      status;

    private BigDecimal money;

    private Short      payWay;

    private String     accountInfo;

    private BigDecimal fee;

    private Date       addTime;

    private String     addIp;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo == null ? null : tradeNo.trim();
    }

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

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
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

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getAddIp() {
        return addIp;
    }

    public void setAddIp(String addIp) {
        this.addIp = addIp == null ? null : addIp.trim();
    }

    public String getPayWayDesc() {
        String result = "";
        if (payWay != null) {
            result = PayWayEnum.getText(payWay);
        }
        return result;
    }

    public String getStatusDesc() {
        String result = "";
        if (status != null) {
            result = RechargeStatusEnum.getText(status);
        }
        return result;
    }

    public String getMoneyDesc() {
        if (money == null) return "";
        return NumberUtil.formateScale2Str(money);
    }

    public String getAddTimeDesc() {
        String result = "";
        if (addTime != null) {
            result = DateUtil.DateToLongStr(addTime);
        }
        return result;
    }

}
