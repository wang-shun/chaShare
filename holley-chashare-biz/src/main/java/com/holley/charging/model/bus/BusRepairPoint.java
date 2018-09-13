package com.holley.charging.model.bus;

import java.util.Date;

import com.holley.common.constants.charge.ShowStausEnum;
import com.holley.common.util.DateUtil;

public class BusRepairPoint {

    private Integer id;

    private String  name;

    private String  address;

    private Short   isShow;

    private String  lng;

    private String  lat;

    private String  phone;

    private String  tel;

    private String  workTime;

    private Date    addTime;

    private double  distance; // 距离

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Short getIsShow() {
        return isShow;
    }

    public void setIsShow(Short isShow) {
        this.isShow = isShow;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng == null ? null : lng.trim();
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat == null ? null : lat.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime == null ? null : workTime.trim();
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String getIsShowDesc() {
        if (isShow == null) return "";
        String desc = ShowStausEnum.getText(isShow.shortValue());
        return desc == null ? "" : desc;
    }

    public String getAddTimeDesc() {
        if (addTime == null) return "";
        return DateUtil.DateToLongStr(addTime);
    }

}
