package com.holley.platform.model;

import java.io.Serializable;

import com.holley.platform.model.sys.SysNotice;

public class SMSModel implements Serializable {

    private static final long serialVersionUID = 6242147669237432790L;
    private String            content;
    private String            mobile;

    private SysNotice         notice;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public SysNotice getNotice() {
        return notice;
    }

    public void setNotice(SysNotice notice) {
        this.notice = notice;
    }

}
