package com.holley.charging.model.bus;

import java.util.Date;

import com.holley.common.util.DateUtil;
import com.holley.common.util.StringUtil;
import com.holley.platform.util.CacheSysHolder;

public class BusBussinessInfo {

    private Integer id;

    private String  busName;

    private String  licence;

    private String  accRealName;

    private String  bankName;

    private String  bankAccount;

    private String  limitYear;

    private String  scale;

    private String  busDomain;

    private String  domain;

    private String  country;

    private Integer province;

    private Integer city;

    private String  address;

    private String  tel;

    private String  licenceImg;

    private String  corporateImg;

    private String  transatorImg;

    private Date    addTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBusName() {
        return busName;
    }

    public void setBusName(String busName) {
        this.busName = busName == null ? null : busName.trim();
    }

    public String getLicence() {
        return licence;
    }

    public void setLicence(String licence) {
        this.licence = licence == null ? null : licence.trim();
    }

    public String getAccRealName() {
        return accRealName;
    }

    public void setAccRealName(String accRealName) {
        this.accRealName = accRealName == null ? null : accRealName.trim();
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount == null ? null : bankAccount.trim();
    }

    public String getLimitYear() {
        return limitYear;
    }

    public void setLimitYear(String limitYear) {
        this.limitYear = limitYear == null ? null : limitYear.trim();
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale == null ? null : scale.trim();
    }

    public String getBusDomain() {
        return busDomain;
    }

    public void setBusDomain(String busDomain) {
        this.busDomain = busDomain == null ? null : busDomain.trim();
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain == null ? null : domain.trim();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getLicenceImg() {
        return licenceImg;
    }

    public void setLicenceImg(String licenceImg) {
        this.licenceImg = licenceImg == null ? null : licenceImg.trim();
    }

    public String getCorporateImg() {
        return corporateImg;
    }

    public void setCorporateImg(String corporateImg) {
        this.corporateImg = corporateImg == null ? null : corporateImg.trim();
    }

    public String getTransatorImg() {
        return transatorImg;
    }

    public void setTransatorImg(String transatorImg) {
        this.transatorImg = transatorImg == null ? null : transatorImg.trim();
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getBankAccountDesc() {
        String result = "";
        if (bankAccount != null) {
            result = StringUtil.showStar(bankAccount);
        }
        return result;
    }

    public String getProvinceDesc() {
        String desc = CacheSysHolder.getProvinceName(province);
        return desc == null ? "" : desc;
    }

    public String getCityDesc() {
        String desc = CacheSysHolder.getCityName(province, city);
        return desc == null ? "" : desc;
    }

    public String getAddTimeStr() {
        return addTime == null ? "" : DateUtil.DateToLongStr(addTime);
    }
}
