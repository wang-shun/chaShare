package com.holley.charging.model.bms;

import com.holley.charging.model.bus.BusBills;
import com.holley.common.constants.charge.UserTypeEnum;

public class BillsInfo extends BusBills {

    private String username;
    private Short  usertype;
    private String phone;

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

    public String getUsertypeDesc() {
        if (usertype == null) return "";
        String desc = UserTypeEnum.getText(usertype.intValue());
        return desc == null ? "" : desc;
    }

}
