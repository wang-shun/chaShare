package com.holley.charging.model.bms;

public class StationRealData {

    private Integer stationid;
    private String  stationname;
    private String  address;
    private String  busmecname;
    private String  bustypedesc;
    private String  citydesc;
    private Integer pilenum;    // 电桩个数
    private Integer idlenum;    // 空闲数
    private Integer chargenum;  // 充电数
    private Integer appnum;     // 预约数
    private Integer offlinenum; // 离线数
    private Integer faultnum;   // 故障数
    private Integer unknownum;  // 未知数

    public Integer getStationid() {
        return stationid;
    }

    public void setStationid(Integer stationid) {
        this.stationid = stationid;
    }

    public String getStationname() {
        return stationname;
    }

    public void setStationname(String stationname) {
        this.stationname = stationname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBusmecname() {
        return busmecname;
    }

    public void setBusmecname(String busmecname) {
        this.busmecname = busmecname;
    }

    public String getBustypedesc() {
        return bustypedesc;
    }

    public void setBustypedesc(String bustypedesc) {
        this.bustypedesc = bustypedesc;
    }

    public String getCitydesc() {
        return citydesc;
    }

    public void setCitydesc(String citydesc) {
        this.citydesc = citydesc;
    }

    public Integer getPilenum() {
        return pilenum;
    }

    public void setPilenum(Integer pilenum) {
        this.pilenum = pilenum;
    }

    public Integer getIdlenum() {
        return idlenum;
    }

    public void setIdlenum(Integer idlenum) {
        this.idlenum = idlenum;
    }

    public Integer getChargenum() {
        return chargenum;
    }

    public void setChargenum(Integer chargenum) {
        this.chargenum = chargenum;
    }

    public Integer getAppnum() {
        return appnum;
    }

    public void setAppnum(Integer appnum) {
        this.appnum = appnum;
    }

    public Integer getOfflinenum() {
        return offlinenum;
    }

    public void setOfflinenum(Integer offlinenum) {
        this.offlinenum = offlinenum;
    }

    public Integer getFaultnum() {
        return faultnum;
    }

    public void setFaultnum(Integer faultnum) {
        this.faultnum = faultnum;
    }

    public Integer getUnknownum() {
        return unknownum;
    }

    public void setUnknownum(Integer unknownum) {
        this.unknownum = unknownum;
    }

}
