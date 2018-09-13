package com.holley.charging.model.bus;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.holley.common.constants.charge.CertificateStatusEnum;
import com.holley.common.constants.charge.UserTypeEnum;
import com.holley.common.constants.charge.WhetherEnum;
import com.holley.common.util.DateUtil;

public class BusUser implements Serializable {

    private static final long serialVersionUID = -1890687423233472175L;

    private Integer           id;

    private String            username;

    private String            password;

    private String            payPassword;

    private String            headImg;

    private Short             isLock;

    private Short             realStatus;

    private String            email;

    private Short             emailStatus;

    private String            phone;

    private Short             phoneStatus;

    private Short             userType;

    private Integer           infoId;

    private Integer           groupId;

    private Date              registTime;

    private String            registIp;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getPayPassword() {
        return payPassword;
    }

    public void setPayPassword(String payPassword) {
        this.payPassword = payPassword == null ? null : payPassword.trim();
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg == null ? null : headImg.trim();
    }

    public Short getIsLock() {
        return isLock;
    }

    public void setIsLock(Short isLock) {
        this.isLock = isLock;
    }

    public Short getRealStatus() {
        return realStatus;
    }

    public void setRealStatus(Short realStatus) {
        this.realStatus = realStatus;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Short getEmailStatus() {
        return emailStatus;
    }

    public void setEmailStatus(Short emailStatus) {
        this.emailStatus = emailStatus;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Short getPhoneStatus() {
        return phoneStatus;
    }

    public void setPhoneStatus(Short phoneStatus) {
        this.phoneStatus = phoneStatus;
    }

    public Short getUserType() {
        return userType;
    }

    public void setUserType(Short userType) {
        this.userType = userType;
    }

    public Integer getInfoId() {
        return infoId;
    }

    public void setInfoId(Integer infoId) {
        this.infoId = infoId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Date getRegistTime() {
        return registTime;
    }

    public void setRegistTime(Date registTime) {
        this.registTime = registTime;
    }

    public String getRegistIp() {
        return registIp;
    }

    public void setRegistIp(String registIp) {
        this.registIp = registIp == null ? null : registIp.trim();
    }

}
