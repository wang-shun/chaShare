package com.holley.platform.model.sys;

import java.io.Serializable;

public class SysDefArea implements Serializable {

    private static final long serialVersionUID = 2664771200932480906L;

    private Integer id;

    private String name;

    private String nid;

    private Integer pid;

    private Short sort;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid == null ? null : nid.trim();
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Short getSort() {
        return sort;
    }

    public void setSort(Short sort) {
        this.sort = sort;
    }
}
