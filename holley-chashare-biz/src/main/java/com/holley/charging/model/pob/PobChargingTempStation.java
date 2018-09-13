package com.holley.charging.model.pob;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.math.NumberUtils;

import com.holley.common.constants.charge.DeviceVerifyStatusEnum;
import com.holley.common.constants.charge.LinkTypeEnum;
import com.holley.common.constants.charge.RequestTypeEnum;
import com.holley.common.constants.charge.UserTypeEnum;
import com.holley.common.util.DateUtil;
import com.holley.common.util.StringUtil;
import com.holley.platform.model.sys.SysLink;
import com.holley.platform.util.CacheSysHolder;

public class PobChargingTempStation {

    private Integer id;

    private Integer realStationId;

    private String  stationName;

    private Integer province;

    private Integer city;

    private String  address;

    private String  lng;

    private String  lat;

    private Integer busMec;

    private Short   busType;

    private Short   openDay;

    private Short   openTime;

    private Short   parkType;

    private Short   isParkFee;

    private Short   isShow;

    private String  remark;

    private Short   requestType;

    private String  validRemark;

    private String  img;

    private Short   score;

    private Short   validStatus;

    private Date    operatTime;

    private String  linkMan;

    private String  linkPhone;

    private Integer fastNum;

    private Integer slowNum;

    private String  dataSource;

    private Date    updateTime;

    private Date    validTime;

    private String  busMecName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRealStationId() {
        return realStationId;
    }

    public void setRealStationId(Integer realStationId) {
        this.realStationId = realStationId;
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

    public Short getRequestType() {
        return requestType;
    }

    public void setRequestType(Short requestType) {
        this.requestType = requestType;
    }

    public String getValidRemark() {
        return validRemark;
    }

    public void setValidRemark(String validRemark) {
        this.validRemark = validRemark == null ? null : validRemark.trim();
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public Short getScore() {
        return score;
    }

    public void setScore(Short score) {
        this.score = score;
    }

    public Short getValidStatus() {
        return validStatus;
    }

    public void setValidStatus(Short validStatus) {
        this.validStatus = validStatus;
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

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getValidTime() {
        return validTime;
    }

    public void setValidTime(Date validTime) {
        this.validTime = validTime;
    }

    public String getRequestTypeDesc() {
        if (requestType == null) return "";
        String desc = RequestTypeEnum.getText(requestType.intValue());
        return desc == null ? "" : desc;
    }

    public String getValidStatusDesc() {
        if (validStatus == null) return "";
        String desc = DeviceVerifyStatusEnum.getText(validStatus.intValue());
        return desc;
    }

    public String getUpdateTimeStr() {
        if (updateTime == null) return "";
        return DateUtil.DateToLongStr(updateTime);
    }

    public String getValidTimeStr() {
        if (validTime == null) return "";
        return DateUtil.DateToLongStr(validTime);
    }

    public String getProvinceName() {
        if (province == null) return "";
        String desc = CacheSysHolder.getProvinceName(province);
        return desc == null ? "" : desc;
    }

    public String getCityName() {
        if (province == null || city == null) return "";
        String desc = CacheSysHolder.getCityName(province, city);
        return desc == null ? "" : desc;
    }

    public String getBusMecName() {
        return busMecName;
    }

    public void setBusMecName(String busMecName) {
        this.busMecName = busMecName;
    }

    public String getBusTypeDesc() {
        if (busType == null) return "";
        String desc = UserTypeEnum.getText(busType.intValue());
        return desc == null ? "" : desc;
    }

    public String getOpenDayDesc() {
        if (openDay == null) return "";
        String desc = CacheSysHolder.getSysLinkName(LinkTypeEnum.OPEN_DAY.getValue(), openDay.toString());
        return desc == null ? "" : desc;
    }

    public String getOpenTimeDesc() {
        if (openTime == null) return "";
        String desc = CacheSysHolder.getSysLinkName(LinkTypeEnum.OPEN_TIME.getValue(), openTime.toString());
        return desc == null ? "" : desc;
    }

    public String getParkTypeDesc() {
        if (parkType == null) return "";
        String desc = CacheSysHolder.getSysLinkName(LinkTypeEnum.PARK_TYPE.getValue(), parkType.toString());
        return desc == null ? "" : desc;
    }

    public String getOperatTimeStr() {
        if (operatTime == null) return "";
        return DateUtil.DateToLongStr(operatTime);
    }

    public String getOpenDayDesc2() {
        String result = "未知";
        if (openDay != null) {
            List<SysLink> openDayList = CacheSysHolder.getLinkListBytypeId(LinkTypeEnum.OPEN_DAY.getValue());
            for (SysLink link : openDayList) {
                if (NumberUtils.toShort(link.getValue()) == openDay) {
                    result = link.getName();
                    break;
                }
            }
        }
        return result;
    }

    public String getOpenTimeDesc2() {
        String result = "未知";
        if (openTime != null) {
            List<SysLink> openTimeList = CacheSysHolder.getLinkListBytypeId(LinkTypeEnum.OPEN_TIME.getValue());
            for (SysLink link : openTimeList) {
                if (NumberUtils.toShort(link.getValue()) == openTime) {
                    result = link.getName();
                    break;
                }
            }
        }
        return result;
    }

    public String getValidStatusDesc2() {
        // 审核类型：待审核，审核中，审核通过，审核不通过
        String result = "未知";
        if (validStatus != null) {
            result = CacheSysHolder.getSysLinkName(LinkTypeEnum.VALID_TYPE.getValue(), validStatus.toString());
        }

        return result;
    }

    public String getRequestTypeDesc2() {
        // 审核类型：待审核，审核中，审核通过，审核不通过
        String result = "未知";
        if (requestType != null) {
            result = CacheSysHolder.getSysLinkName(LinkTypeEnum.REQUEST_TYPE.getValue(), requestType.toString());
        }
        return result;
    }

    public String getParkTypeDesc2() {
        String result = "";
        if (parkType != null) {
            List<SysLink> parkTypeList = CacheSysHolder.getLinkListBytypeId(LinkTypeEnum.PARK_TYPE.getValue());
            for (SysLink link : parkTypeList) {
                if (NumberUtils.toShort(link.getValue()) == parkType) {
                    result = link.getName();
                    break;
                }
            }
        }
        return result;
    }

    public String getProvinceDesc2() {
        String result = "";
        if (province != null) {
            result = StringUtil.defaultIfNull(CacheSysHolder.getProvinceName(province), "");
        }
        return result;
    }

    public String getCityDesc2() {
        String result = "";
        if (city != null) {
            result = StringUtil.defaultIfNull(CacheSysHolder.getCityName(province, city), "");
        }
        return result;
    }

    public String getScoreDesc2() {
        String result = "0分";
        if (score != null) {
            if (score >= 50) {
                result = "5分";
            } else {
                double temp = (score * 5) / 50;
                result = temp + "分";
            }

        }
        return result;
    }

    public String getUpdateTimeDesc2() {
        String result = "";
        if (updateTime != null) {
            result = DateUtil.DateToLongStr(updateTime);
        } else {
            result = "";
        }
        return result;
    }

}
