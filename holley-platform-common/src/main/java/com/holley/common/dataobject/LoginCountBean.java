package com.holley.common.dataobject;

import java.io.Serializable;
import java.util.Date;

public class LoginCountBean implements Serializable {

    private static final long serialVersionUID = 6098497446916700331L;

    private String  account;
    private int     count;                 // 登录失败次数
    private Date    logintime;
    private int     reTryCount;            // 登录剩余重试次数
    private boolean isRefuseLogin = false; // 是否拒绝登录，超过6次后等半小时登录
    private String  loginFailMsg;

    public String getLoginFailMsg() {
        return loginFailMsg;
    }

    public void setLoginFailMsg(String loginFailMsg) {
        this.loginFailMsg = loginFailMsg;
    }

    public boolean isRefuseLogin() {
        return isRefuseLogin;
    }

    public void setRefuseLogin(boolean isRefuseLogin) {
        this.isRefuseLogin = isRefuseLogin;
    }

    public int getReTryCount() {
        return reTryCount;
    }

    public void setReTryCount(int reTryCount) {
        this.reTryCount = reTryCount;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Date getLogintime() {
        return logintime;
    }

    public void setLogintime(Date logintime) {
        this.logintime = logintime;
    }
}
