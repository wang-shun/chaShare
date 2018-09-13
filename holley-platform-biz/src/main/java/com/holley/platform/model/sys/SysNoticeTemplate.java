package com.holley.platform.model.sys;

public class SysNoticeTemplate {
    private Integer id;

    private Short msgType;

    private String name;

    private String template;

    private Short status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Short getMsgType() {
        return msgType;
    }

    public void setMsgType(Short msgType) {
        this.msgType = msgType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template == null ? null : template.trim();
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }
}