package com.holley.charging.model.bms;

import com.holley.charging.model.bus.BusUserReceipt;

public class UserReceipt extends BusUserReceipt {

    private String username;
    private String userphone;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone;
    }

}
