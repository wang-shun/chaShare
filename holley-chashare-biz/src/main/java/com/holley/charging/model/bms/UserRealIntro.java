package com.holley.charging.model.bms;

import com.holley.common.constants.charge.UserTypeEnum;

/**
 * 用户概要信息
 * 
 * @author lenovo
 */
public class UserRealIntro {

    private Integer userid;
    private String  username;
    private String  realname;
    private String  phone;
    private Short   usertype;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Short getUsertype() {
        return usertype;
    }

    public void setUsertype(Short usertype) {
        this.usertype = usertype;
    }

    public String getUsertypeDesc() {
        if (usertype == null) return "";
        String desc = UserTypeEnum.getText(usertype.intValue());
        return desc == null ? "" : desc;
    }

}
