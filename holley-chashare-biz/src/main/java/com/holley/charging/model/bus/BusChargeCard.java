package com.holley.charging.model.bus;

import java.math.BigDecimal;
import java.util.Date;

import com.holley.common.constants.charge.ChargeCardTypeEnum;
import com.holley.common.util.DateUtil;

public class BusChargeCard {

    private Integer    id;

    private Integer    userId;

    private String     busNo;

    private String     cardNo;

    private Short      applicationType;

    private Date       startTime;

    private Date       endTime;

    private String     password;

    private Short      cardType;

    private Integer    worker;

    private String     badRecord;

    private BigDecimal usableMoney;

    private BigDecimal freezeMoney;

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

    public String getBusNo() {
        return busNo;
    }

    public void setBusNo(String busNo) {
        this.busNo = busNo == null ? null : busNo.trim();
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo == null ? null : cardNo.trim();
    }

    public Short getApplicationType() {
        return applicationType;
    }

    public void setApplicationType(Short applicationType) {
        this.applicationType = applicationType;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Short getCardType() {
        return cardType;
    }

    public void setCardType(Short cardType) {
        this.cardType = cardType;
    }

    public Integer getWorker() {
        return worker;
    }

    public void setWorker(Integer worker) {
        this.worker = worker;
    }

    public String getBadRecord() {
        return badRecord;
    }

    public void setBadRecord(String badRecord) {
        this.badRecord = badRecord == null ? null : badRecord.trim();
    }

    public BigDecimal getUsableMoney() {
        return usableMoney;
    }

    public void setUsableMoney(BigDecimal usableMoney) {
        this.usableMoney = usableMoney;
    }

    public BigDecimal getFreezeMoney() {
        return freezeMoney;
    }

    public void setFreezeMoney(BigDecimal freezeMoney) {
        this.freezeMoney = freezeMoney;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getStartTimeDesc() {
        if (startTime != null) {
            return DateUtil.DateToShortStr(startTime);
        }
        return "";
    }

    public String getEndTimeDesc() {
        if (endTime != null) {
            return DateUtil.DateToShortStr(endTime);
        }
        return "";
    }

    public String getCardTypeDesc() {
        if (cardType != null) {
            return ChargeCardTypeEnum.getText(cardType);
        } else {
            return "未知";
        }

    }
}
