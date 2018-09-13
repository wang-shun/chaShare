package com.holley.platform.model;

import java.io.Serializable;

import com.holley.platform.model.sys.SysNotice;

public class EmailModel implements Serializable {

    private static final long serialVersionUID = 7230376633301988968L;
    private String            subject;                                // 主题
    private String            content;
    private String            email;

    private SysNotice         notice;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public SysNotice getNotice() {
        return notice;
    }

    public void setNotice(SysNotice notice) {
        this.notice = notice;
    }

}
