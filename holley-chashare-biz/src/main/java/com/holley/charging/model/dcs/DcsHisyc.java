package com.holley.charging.model.dcs;

import java.util.Date;

public class DcsHisyc {
    private Integer id;

    private Integer chargeid;

    private Integer datatype;

    private Date datatime;

    private Double value;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getChargeid() {
        return chargeid;
    }

    public void setChargeid(Integer chargeid) {
        this.chargeid = chargeid;
    }

    public Integer getDatatype() {
        return datatype;
    }

    public void setDatatype(Integer datatype) {
        this.datatype = datatype;
    }

    public Date getDatatime() {
        return datatime;
    }

    public void setDatatime(Date datatime) {
        this.datatime = datatime;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}