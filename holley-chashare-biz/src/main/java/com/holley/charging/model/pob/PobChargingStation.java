package com.holley.charging.model.pob;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.math.NumberUtils;

import com.holley.common.constants.charge.LinkTypeEnum;
import com.holley.common.constants.charge.ShowStausEnum;
import com.holley.common.util.DateUtil;
import com.holley.common.util.StringUtil;
import com.holley.platform.model.sys.SysLink;
import com.holley.platform.util.CacheSysHolder;

public class PobChargingStation implements Serializable {

    private static final long serialVersionUID = 1225357644741113509L;

    private Integer           id;

    private String            stationName;

    private Integer           province;

    private Integer           city;

    private String            address;

    private String            lng;

    private String            lat;

    private Integer           busMec;

    private Short             busType;

    private Short             openDay;

    private Short             openTime;

    private Short             parkType;

    private Short             isParkFee;

    private Short             isShow;

    private String            remark;

    private String            img;

    private Date              updateTime;

    private Short             score;

    private Short             isValidate;

    private Date              operatTime;

    private String            linkMan;

    private String            linkPhone;

    private Integer           fastNum;

    private Integer           slowNum;

    private String            dataSource;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName == null ? null : stationName.trim();
    }

    public Integer getProvince() {
        return province;
    }

    public void setProvince(Integer province) {
        this.province = province;
    }

    public Integer getCity() {
        return city;
    }

    public void setCity(Integer city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
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

    public Integer getBusMec() {
        return busMec;
    }

    public void setBusMec(Integer busMec) {
        this.busMec = busMec;
    }

    public Short getBusType() {
        return busType;
    }

    public void setBusType(Short busType) {
        this.busType = busType;
    }

    public Short getOpenDay() {
        return openDay;
    }

    public void setOpenDay(Short openDay) {
        this.openDay = openDay;
    }

    public Short getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Short openTime) {
        this.openTime = openTime;
    }

    public Short getParkType() {
        return parkType;
    }

    public void setParkType(Short parkType) {
        this.parkType = parkType;
    }

    public Short getIsParkFee() {
        return isParkFee;
    }

    public void setIsParkFee(Short isParkFee) {
        this.isParkFee = isParkFee;
    }

    public Short getIsShow() {
        return isShow;
    }

    public void setIsShow(Short isShow) {
        this.isShow = isShow;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Short getScore() {
        return score;
    }

    public void setScore(Short score) {
        this.score = score;
    }

    public Short getIsValidate() {
        return isValidate;
    }

    public void setIsValidate(Short isValidate) {
        this.isValidate = isValidate;
    }

    public Date getOperatTime() {
        return operatTime;
    }

    public void setOperatTime(Date operatTime) {
        this.operatTime = operatTime;
    }

    public String getLinkMan() {
        return linkMan;
    }

    public void setLinkMan(String linkMan) {
        this.linkMan = linkMan == null ? null : linkMan.trim();
    }

    public String getLinkPhone() {
        return linkPhone;
    }

    public void setLinkPhone(String linkPhone) {
        this.linkPhone = linkPhone == null ? null : linkPhone.trim();
    }

    public Integer getFastNum() {
        return fastNum;
    }

    public void setFastNum(Integer fastNum) {
        this.fastNum = fastNum;
    }

    public Integer getSlowNum() {
        return slowNum;
    }

    public void setSlowNum(Integer slowNum) {
        this.slowNum = slowNum;
    }

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource == null ? null : dataSource.trim();
    }


}
