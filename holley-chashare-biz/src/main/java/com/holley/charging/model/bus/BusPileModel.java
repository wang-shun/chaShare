package com.holley.charging.model.bus;

import java.util.Date;

import com.holley.common.constants.charge.ChargeCurrentTypeEnum;
import com.holley.common.constants.charge.ChargeInterfaceTypeEnum;
import com.holley.common.constants.charge.ChargePowerTypeEnum;
import com.holley.common.constants.charge.PileModelStatusEnum;
import com.holley.common.constants.charge.WhetherEnum;
import com.holley.common.util.DateUtil;

public class BusPileModel {

    private Integer id;

    private String  brand;

    private Short   chaWay;

    private Short   chaType;

    private String  num;

    private Short   isIntelligent;

    private Short   standard;

    private String  inV;

    private String  outV;

    private String  maxP;

    private String  ratP;

    private String  hull;

    private String  size;

    private String  proLevel;

    private String  lineLen;

    private String  rate;

    private String  meaAcc;

    private String  weight;

    private String  window;

    private String  workTem;

    private String  relaHum;

    private String  altitude;

    private Short   status;

    private String  insMethod;

    private String  workSta;

    private String  identify;

    private Date    updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand == null ? null : brand.trim();
    }

    public Short getChaWay() {
        return chaWay;
    }

    public void setChaWay(Short chaWay) {
        this.chaWay = chaWay;
    }

    public Short getChaType() {
        return chaType;
    }

    public void setChaType(Short chaType) {
        this.chaType = chaType;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num == null ? null : num.trim();
    }

    public Short getIsIntelligent() {
        return isIntelligent;
    }

    public void setIsIntelligent(Short isIntelligent) {
        this.isIntelligent = isIntelligent;
    }

    public Short getStandard() {
        return standard;
    }

    public void setStandard(Short standard) {
        this.standard = standard;
    }

    public String getInV() {
        return inV;
    }

    public void setInV(String inV) {
        this.inV = inV == null ? null : inV.trim();
    }

    public String getOutV() {
        return outV;
    }

    public void setOutV(String outV) {
        this.outV = outV == null ? null : outV.trim();
    }

    public String getMaxP() {
        return maxP;
    }

    public void setMaxP(String maxP) {
        this.maxP = maxP == null ? null : maxP.trim();
    }

    public String getRatP() {
        return ratP;
    }

    public void setRatP(String ratP) {
        this.ratP = ratP == null ? null : ratP.trim();
    }

    public String getHull() {
        return hull;
    }

    public void setHull(String hull) {
        this.hull = hull == null ? null : hull.trim();
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size == null ? null : size.trim();
    }

    public String getProLevel() {
        return proLevel;
    }

    public void setProLevel(String proLevel) {
        this.proLevel = proLevel == null ? null : proLevel.trim();
    }

    public String getLineLen() {
        return lineLen;
    }

    public void setLineLen(String lineLen) {
        this.lineLen = lineLen == null ? null : lineLen.trim();
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate == null ? null : rate.trim();
    }

    public String getMeaAcc() {
        return meaAcc;
    }

    public void setMeaAcc(String meaAcc) {
        this.meaAcc = meaAcc == null ? null : meaAcc.trim();
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight == null ? null : weight.trim();
    }

    public String getWindow() {
        return window;
    }

    public void setWindow(String window) {
        this.window = window == null ? null : window.trim();
    }

    public String getWorkTem() {
        return workTem;
    }

    public void setWorkTem(String workTem) {
        this.workTem = workTem == null ? null : workTem.trim();
    }

    public String getRelaHum() {
        return relaHum;
    }

    public void setRelaHum(String relaHum) {
        this.relaHum = relaHum == null ? null : relaHum.trim();
    }

    public String getAltitude() {
        return altitude;
    }

    public void setAltitude(String altitude) {
        this.altitude = altitude == null ? null : altitude.trim();
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public String getInsMethod() {
        return insMethod;
    }

    public void setInsMethod(String insMethod) {
        this.insMethod = insMethod == null ? null : insMethod.trim();
    }

    public String getWorkSta() {
        return workSta;
    }

    public void setWorkSta(String workSta) {
        this.workSta = workSta == null ? null : workSta.trim();
    }

    public String getIdentify() {
        return identify;
    }

    public void setIdentify(String identify) {
        this.identify = identify == null ? null : identify.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}
