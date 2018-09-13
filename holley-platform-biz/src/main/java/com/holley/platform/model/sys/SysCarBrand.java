package com.holley.platform.model.sys;

public class SysCarBrand {
    private Integer id;

    private String name;

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