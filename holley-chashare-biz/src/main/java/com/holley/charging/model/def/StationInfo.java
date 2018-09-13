package com.holley.charging.model.def;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import com.holley.common.constants.share.ConstructionEnum;
import com.holley.common.constants.share.StationStatusEnum;
import com.holley.common.constants.share.StationTypeEnum;

/**
 * Description: 站点信息
 *
 * @author shen.cheng@holley.cn
 */
public class StationInfo {

    @JSONField(name = "OperationID")
    private String              operationID;                                          // 运营商ID
    @JSONField(name = "StationID")
    private String              stationID;                                            // 充电站ID
    @JSONField(name = "StationName")
    private String              stationName;
    @JSONField(name = "EquipmentOwnerID")
    private String              equipmentOwnerID;                                     // 设备所属运营平台组织机构代码
    @JSONField(name = "CountryCode")
    private String              countryCode    = "CN";                                // 默认中国
    @JSONField(name = "AreaCode")
    private String              areaCode       = "110000";                            // 区域
    @JSONField(name = "Address")
    private String              address;                                              // 地址
    @JSONField(name = "StationTel")
    private String              stationTel;                                           // 站点电话
    @JSONField(name = "ServiceTel")
    private String              serviceTel;                                           // 服务电话
    @JSONField(name = "StationType")
    private Integer             stationType    = StationTypeEnum.PUBLIC.getValue();   // 1：公共50：个人100：公交（专用）101：环卫（专用）102：物流（专用）103：出租车（专用）255：其他
    @JSONField(name = "StationStatus")
    private Integer             stationStatus  = StationStatusEnum.SERVICE.getValue();
    @JSONField(name = "ParkNums")
    private Integer             parkNums       = 0;                                   // 车位数
    @JSONField(name = "StationLng")
    private String              stationLng;                                           // 经度
    @JSONField(name = "StationLat")
    private String              stationLat;                                           // 纬度
    @JSONField(name = "SiteGuide")
    private String              siteGuide      = "";                                  // 站点指引
    @JSONField(name = "Construction")
    private Integer             construction   = ConstructionEnum.PUBLIC.getValue();  // 建设场所
    @JSONField(name = "Pictures")
    private String[]            pictures       = {};                                  // 站点图片
    @JSONField(name = "MatchCars")
    private String              matchCars      = "";                                  // 使用车型描述
    @JSONField(name = "ParkInfo")
    private String              parkInfo       = "";                                  // 车位楼层及数量描述
    @JSONField(name = "BusineHours")
    private String              busineHours;                                          // 营业时间描述
    @JSONField(name = "ElectricityFee")
    private String              electricityFee = "0.0";                               // 充电费
    @JSONField(name = "ServiceFee")
    private String              serviceFee     = "0.0";                               // 服务费
    @JSONField(name = "ParkFee")
    private String              parkFee        = "0.0";                               // 停车费
    @JSONField(name = "Payment")
    private String              payment        = "充电卡";                               // 支付方式
    @JSONField(name = "SupportOrder")
    private Integer             supportOrder   = 0;                                   // 是否支持预约
    @JSONField(name = "Remark")
    private String              remark         = "";                                  // 其他备注信息
    @JSONField(name = "EquipmentInfos")
    private List<EquipmentInfo> equipmentInfos;

    public String getOperationID() {
        return operationID;
    }

    public void setOperationID(String operationID) {
        this.operationID = operationID;
    }

    public String getStationID() {
        return stationID;
    }

    public void setStationID(String stationID) {
        this.stationID = stationID;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getEquipmentOwnerID() {
        return equipmentOwnerID;
    }

    public void setEquipmentOwnerID(String equipmentOwnerID) {
        this.equipmentOwnerID = equipmentOwnerID;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStationTel() {
        return stationTel;
    }

    public void setStationTel(String stationTel) {
        this.stationTel = stationTel;
    }

    public String getServiceTel() {
        return serviceTel;
    }

    public void setServiceTel(String serviceTel) {
        this.serviceTel = serviceTel;
    }

    public Integer getStationType() {
        return stationType;
    }

    public void setStationType(Integer stationType) {
        this.stationType = stationType;
    }

    public Integer getStationStatus() {
        return stationStatus;
    }

    public void setStationStatus(Integer stationStatus) {
        this.stationStatus = stationStatus;
    }

    public Integer getParkNums() {
        return parkNums;
    }

    public void setParkNums(Integer parkNums) {
        this.parkNums = parkNums;
    }

    public String getStationLng() {
        return stationLng;
    }

    public void setStationLng(String stationLng) {
        this.stationLng = stationLng;
    }

    public String getStationLat() {
        return stationLat;
    }

    public void setStationLat(String stationLat) {
        this.stationLat = stationLat;
    }

    public String getSiteGuide() {
        return siteGuide;
    }

    public void setSiteGuide(String siteGuide) {
        this.siteGuide = siteGuide;
    }

    public Integer getConstruction() {
        return construction;
    }

    public void setConstruction(Integer construction) {
        this.construction = construction;
    }

    public String[] getPictures() {
        return pictures;
    }

    public void setPictures(String[] pictures) {
        this.pictures = pictures;
    }

    public String getMatchCars() {
        return matchCars;
    }

    public void setMatchCars(String matchCars) {
        this.matchCars = matchCars;
    }

    public String getParkInfo() {
        return parkInfo;
    }

    public void setParkInfo(String parkInfo) {
        this.parkInfo = parkInfo;
    }

    public String getBusineHours() {
        return busineHours;
    }

    public void setBusineHours(String busineHours) {
        this.busineHours = busineHours;
    }

    public String getElectricityFee() {
        return electricityFee;
    }

    public void setElectricityFee(String electricityFee) {
        this.electricityFee = electricityFee;
    }

    public String getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(String serviceFee) {
        this.serviceFee = serviceFee;
    }

    public String getParkFee() {
        return parkFee;
    }

    public void setParkFee(String parkFee) {
        this.parkFee = parkFee;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public Integer getSupportOrder() {
        return supportOrder;
    }

    public void setSupportOrder(Integer supportOrder) {
        this.supportOrder = supportOrder;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<EquipmentInfo> getEquipmentInfos() {
        return equipmentInfos;
    }

    public void setEquipmentInfos(List<EquipmentInfo> equipmentInfos) {
        this.equipmentInfos = equipmentInfos;
    }

}
