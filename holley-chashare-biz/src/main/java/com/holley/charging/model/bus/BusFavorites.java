package com.holley.charging.model.bus;

import java.util.Date;

public class BusFavorites {
    private Integer id;

    private Integer userId;

    private Integer stationId;

    private Date addTime;

    private Short isShow;

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

    public Integer getStationId() {
        return stationId;
    }

    public void setStationId(Integer stationId) {
        this.stationId = stationId;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Short getIsShow() {
        return isShow;
    }

    public void setIsShow(Short isShow) {
        this.isShow = isShow;
    }
}