package com.holley.common.dataobject;

import java.io.Serializable;
import java.util.Date;

import com.holley.common.constants.charge.UserTypeEnum;
import com.holley.common.util.DateUtil;

/**
 * 登录人的信息<br>
 * 登录时CommonConstants.SESSION_KEY保存到session<br>
 * 它也用来做登录验证<br>
 * loginout时候可以去掉此session<br>
 * 
 * @author zhouli
 */
public class WebUser implements Serializable {

    private static final long serialVersionUID = -1898191824623896114L;

    private Integer           userId;
    private String            userName;
    private UserTypeEnum      usertype;
    private String            loginUser;
    private Date              loginDate;                               // 登录时间
    private Long              longDate;
    private Integer           roleId;                                  // 角色
    private Short             roleType;                                // 角色类型
    private String            ip;
    private String            phone;                                   // 手机
    private Short             phoneStatus;                             // 手机认证状态
    private String            email;                                   // 手机
    private Short             eamilStatus;                             // 手机认证状态
    private Integer           infoId;                                  // 运营商或个人信息ID
    private Short             realStatus;                              // 实名认证状态
    private Date              registTime;
    private String            headImg;                                 // 头像

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public Date getRegistTime() {
        return registTime;
    }

    public String getRegistTimeDesc() {
        if (registTime != null) {
            return DateUtil.DateToShortStr(registTime);
        }
        return "";
    }

    public void setRegistTime(Date registTime) {
        this.registTime = registTime;
    }

    public Short getRealStatus() {
        return realStatus;
    }

    public void setRealStatus(Short realStatus) {
        this.realStatus = realStatus;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Short getPhoneStatus() {
        return phoneStatus;
    }

    public void setPhoneStatus(Short phoneStatus) {
        this.phoneStatus = phoneStatus;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Short getEamilStatus() {
        return eamilStatus;
    }

    public void setEamilStatus(Short eamilStatus) {
        this.eamilStatus = eamilStatus;
    }

    public Integer getInfoId() {
        return infoId;
    }

    public void setInfoId(Integer infoId) {
        this.infoId = infoId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public UserTypeEnum getUsertype() {
        return usertype;
    }

    public void setUsertype(UserTypeEnum usertype) {
        this.usertype = usertype;
    }

    public String getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(String loginUser) {
        this.loginUser = loginUser;
    }

    public Long getLongDate() {
        return longDate;
    }

    public void setLongDate(Long longDate) {
        this.longDate = longDate;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Short getRoleType() {
        return roleType;
    }

    public void setRoleType(Short roleType) {
        this.roleType = roleType;
    }

}
