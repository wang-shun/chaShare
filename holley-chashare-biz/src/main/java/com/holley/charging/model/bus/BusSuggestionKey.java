package com.holley.charging.model.bus;

import java.util.Date;

public class BusSuggestionKey {
    private Date addTime;

    private Integer userId;

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}