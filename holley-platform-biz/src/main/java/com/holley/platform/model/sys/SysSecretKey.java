package com.holley.platform.model.sys;

import java.util.Date;

public class SysSecretKey {
    private String operatorid;

    private String operatorsecret;

    private String datasecret;

    private String datasecretiv;

    private String sigsecret;

    private Date time;

    public String getOperatorid() {
        return operatorid;
    }

    public void setOperatorid(String operatorid) {
        this.operatorid = operatorid == null ? null : operatorid.trim();
    }

    public String getOperatorsecret() {
        return operatorsecret;
    }

    public void setOperatorsecret(String operatorsecret) {
        this.operatorsecret = operatorsecret == null ? null : operatorsecret.trim();
    }

    public String getDatasecret() {
        return datasecret;
    }

    public void setDatasecret(String datasecret) {
        this.datasecret = datasecret == null ? null : datasecret.trim();
    }

    public String getDatasecretiv() {
        return datasecretiv;
    }

    public void setDatasecretiv(String datasecretiv) {
        this.datasecretiv = datasecretiv == null ? null : datasecretiv.trim();
    }

    public String getSigsecret() {
        return sigsecret;
    }

    public void setSigsecret(String sigsecret) {
        this.sigsecret = sigsecret == null ? null : sigsecret.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}