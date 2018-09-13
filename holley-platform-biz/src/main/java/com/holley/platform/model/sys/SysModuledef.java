package com.holley.platform.model.sys;

import java.io.Serializable;

public class SysModuledef implements Serializable {

    private static final long serialVersionUID = -9133997439377022481L;

    private String            moduleid;

    private String            modulename;

    private Short             systemid;

    private String            url;

    private String            parentmoduleid;

    private Integer           sortno;

    private String            icon;

    private String            icon32;

    private String            note;

    public String getModuleid() {
        return moduleid;
    }

    public void setModuleid(String moduleid) {
        this.moduleid = moduleid == null ? null : moduleid.trim();
    }

    public String getModulename() {
        return modulename;
    }

    public void setModulename(String modulename) {
        this.modulename = modulename == null ? null : modulename.trim();
    }

    public Short getSystemid() {
        return systemid;
    }

    public void setSystemid(Short systemid) {
        this.systemid = systemid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getParentmoduleid() {
        return parentmoduleid;
    }

    public void setParentmoduleid(String parentmoduleid) {
        this.parentmoduleid = parentmoduleid == null ? null : parentmoduleid.trim();
    }

    public Integer getSortno() {
        return sortno;
    }

    public void setSortno(Integer sortno) {
        this.sortno = sortno;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public String getIcon32() {
        return icon32;
    }

    public void setIcon32(String icon32) {
        this.icon32 = icon32 == null ? null : icon32.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
}
