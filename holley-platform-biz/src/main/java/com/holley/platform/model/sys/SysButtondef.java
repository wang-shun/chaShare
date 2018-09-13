package com.holley.platform.model.sys;

import java.io.Serializable;

public class SysButtondef implements Serializable {

    private static final long serialVersionUID = -6424378246612351554L;

    private Integer           buttonid;

    private String            buttonname;

    private String            moduleid;

    private String            url;

    private String            icon;

    private String            note;

    public Integer getButtonid() {
        return buttonid;
    }

    public void setButtonid(Integer buttonid) {
        this.buttonid = buttonid;
    }

    public String getButtonname() {
        return buttonname;
    }

    public void setButtonname(String buttonname) {
        this.buttonname = buttonname == null ? null : buttonname.trim();
    }

    public String getModuleid() {
        return moduleid;
    }

    public void setModuleid(String moduleid) {
        this.moduleid = moduleid == null ? null : moduleid.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
}
