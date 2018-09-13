package com.holley.charging.model.bus;

import java.util.Date;

import com.holley.common.constants.charge.PileApplyValidStatusEnum;
import com.holley.common.util.DateUtil;

public class BusPileApply {

    private Integer id;

    private String  realName;

    private String  phone;

    private String  address;

    private String  remark;

    private Integer userId;

    private Date    addtime;

    private Short   validStatus;

    private String  validRemark;

    private Date    validTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
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

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public Short getValidStatus() {
        return validStatus;
    }

    public void setValidStatus(Short validStatus) {
        this.validStatus = validStatus;
    }

    public String getValidRemark() {
        return validRemark;
    }

    public void setValidRemark(String validRemark) {
        this.validRemark = validRemark == null ? null : validRemark.trim();
    }

    public Date getValidTime() {
        return validTime;
    }

    public void setValidTime(Date validTime) {
        this.validTime = validTime;
    }


    public String getAddTimeDesc() {
        if (addtime == null) return "";
        return DateUtil.DateToLongStr(addtime);
    }

    public String getValidStatusDesc() {
        if (validStatus == null) return "";
        String desc = PileApplyValidStatusEnum.getText(validStatus.intValue());
        return validStatus == null ? "" : desc;
    }

    public String getValidTimeDesc() {
        if (validTime == null) return "";
        return DateUtil.DateToLongStr(validTime);
    }

}
