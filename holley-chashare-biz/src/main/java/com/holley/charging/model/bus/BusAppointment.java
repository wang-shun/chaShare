package com.holley.charging.model.bus;

import java.math.BigDecimal;
import java.util.Date;

import com.holley.common.constants.charge.AppointmentPayStatusEnum;
import com.holley.common.constants.charge.AppointmentStatusEnum;
import com.holley.common.constants.charge.PayWayEnum;
import com.holley.common.util.DateUtil;
import com.holley.common.util.NumberUtil;

public class BusAppointment {

    private Integer    id;

    private Integer    userId;

    private Integer    pileId;

    private String     appNo;

    private Date       startTime;

    private Date       endTime;

    private Integer    appLen;

    private BigDecimal appFee;

    private Short      appStatus;

    private Short      payWay;

    private String     accountInfo;

    private Short      payStatus;

    private Short      isBill;

    private Date       addTime;

    private String     userName;

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

    public String getAppNo() {
        return appNo;
    }

    public void setAppNo(String appNo) {
        this.appNo = appNo == null ? null : appNo.trim();
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

    public Integer getAppLen() {
        return appLen;
    }

    public void setAppLen(Integer appLen) {
        this.appLen = appLen;
    }

    public BigDecimal getAppFee() {
        return appFee;
    }

    public void setAppFee(BigDecimal appFee) {
        this.appFee = appFee;
    }

    public Short getAppStatus() {
        return appStatus;
    }

    public void setAppStatus(Short appStatus) {
        this.appStatus = appStatus;
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

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    // DESC
    public String getAppStatusDesc() {
        String result = "";
        if (appStatus != null) {
            if ((AppointmentStatusEnum.ORDERING.getShortValue() == appStatus) && (new Date().getTime() > endTime.getTime())) {
                result = AppointmentStatusEnum.OVERDUE.getText();
            } else {
                result = AppointmentStatusEnum.getText(appStatus);
            }
        } else {
            result = "未知";
        }
        return result;
    }

    public String getIsBillDesc() {
        String result = "";
        if (isBill != null) {
            switch (isBill) {
                case 1:
                    result = "已入账";
                    break;
                case 2:
                    result = "未入账";
                    break;
                default:
                    result = "未知";
            }
        } else {
            result = "未知";
        }
        return result;
    }

    public String getAddTimeDesc() {
        String result = "";
        if (addTime != null) {
            result = DateUtil.DateToLongStr(addTime);
        } else {
            result = "";
        }
        return result;
    }

    public String getAppFeeDesc() {
        String result = "0";
        if (appFee != null) {
            result = NumberUtil.formateScale2Str(appFee);
        }
        return result;
    }

    public String getPayStatusDesc() {
        String result = "未知";
        if (payStatus != null) {
            result = AppointmentPayStatusEnum.getText(payStatus);
        }
        return result;
    }

    public String getStartTimeDesc() {
        String result = "";
        if (startTime != null) {
            result = DateUtil.DateToLongStr(startTime);
        } else {
            result = "";
        }
        return result;
    }

    public String getEndTimeDesc() {
        String result = "";
        if (endTime != null) {
            result = DateUtil.DateToLongStr(endTime);
        } else {
            result = "";
        }
        return result;
    }

    public String getPayWayDesc() {
        String result = "未知";
        if (payWay != null) {
            result = PayWayEnum.getText(payWay);
        }
        return result;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
