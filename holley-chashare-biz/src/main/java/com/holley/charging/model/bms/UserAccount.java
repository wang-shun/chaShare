package com.holley.charging.model.bms;

import java.math.BigDecimal;
import java.util.Date;

import com.holley.common.constants.charge.AccountStatusEnum;
import com.holley.common.constants.charge.UserTypeEnum;
import com.holley.common.util.DateUtil;
import com.holley.common.util.NumberUtil;

public class UserAccount {

    private Integer    userId;
    private String     username;
    private String     phone;
    private Short      userType;
    private Short      status;
    private BigDecimal totalMoney;
    private BigDecimal usableMoney;
    private BigDecimal freezeMoney;
    private Date       updateTime;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Short getUserType() {
        return userType;
    }

    public void setUserType(Short userType) {
        this.userType = userType;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
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


}
