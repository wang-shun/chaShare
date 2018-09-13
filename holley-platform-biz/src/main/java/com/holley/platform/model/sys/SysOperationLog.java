package com.holley.platform.model.sys;

import java.io.Serializable;
import java.util.Date;

import com.holley.common.constants.LogTypeEnum;
import com.holley.common.constants.charge.UserTypeEnum;
import com.holley.common.util.DateUtil;

public class SysOperationLog implements Serializable {

    private static final long serialVersionUID = 2175517891439482448L;

    private Integer           id;

    private Integer           userId;

    private Short             type;

    private String            described;

    private String            ip;

    private Date              addTime;

    private String            username;
    private Short             usertype;
    private String            phone;

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

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public String getDescribed() {
        return described;
    }

    public void setDescribed(String described) {
        this.described = described == null ? null : described.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Short getUsertype() {
        return usertype;
    }

    public void setUsertype(Short usertype) {
        this.usertype = usertype;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTypeDesc() {
        if (type == null) return "";
        String desc = LogTypeEnum.getName(type);
        return desc == null ? "" : desc;
    }

    public String getAddTimeDesc() {
        if (addTime == null) return "";
        return DateUtil.DateToLongStr(addTime);
    }

    public String getUsertypeDesc() {
        if (usertype == null) return "";
        String desc = UserTypeEnum.getText(usertype.intValue());
        return desc == null ? "" : desc;
    }

}
