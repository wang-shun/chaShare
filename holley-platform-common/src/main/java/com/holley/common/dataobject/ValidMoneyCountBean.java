package com.holley.common.dataobject;

import java.io.Serializable;
import java.util.Date;

public class ValidMoneyCountBean implements Serializable {

    private static final long serialVersionUID = -3664724600039358424L;

    private int               infoId;
    private int               failCount;                               // 验证失败次数
    private Date              validTime;
    private int               reTryCount;                              // 登录剩余重试次数
    private boolean           isRefuseValid    = false;                // 是否拒绝验证，超过6次后...
    private String            validFailMsg;

    public int getInfoId() {
        return infoId;
    }

    public void setInfoId(int infoId) {
        this.infoId = infoId;
    }

    public int getFailCount() {
        return failCount;
    }

    public void setFailCount(int failCount) {
        this.failCount = failCount;
    }

    public Date getValidTime() {
        return validTime;
    }

    public void setValidTime(Date validTime) {
        this.validTime = validTime;
    }

    public int getReTryCount() {
        return reTryCount;
    }

    public void setReTryCount(int reTryCount) {
        this.reTryCount = reTryCount;
    }

    public boolean isRefuseValid() {
        return isRefuseValid;
    }

    public void setRefuseValid(boolean isRefuseValid) {
        this.isRefuseValid = isRefuseValid;
    }

    public String getValidFailMsg() {
        return validFailMsg;
    }

    public void setValidFailMsg(String validFailMsg) {
        this.validFailMsg = validFailMsg;
    }

}
