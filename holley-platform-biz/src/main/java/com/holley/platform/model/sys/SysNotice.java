package com.holley.platform.model.sys;

import java.io.Serializable;
import java.util.Date;

public class SysNotice implements Serializable {

    private static final long serialVersionUID = 2914418031276283740L;

    private Integer           id;

    private Short             type;

    private Integer           sentUser;

    private Integer           reciveUser;

    private Integer           messageid;

    private Short             status;

    private Short             isRead;

    private Date              sendTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public Integer getSentUser() {
        return sentUser;
    }

    public void setSentUser(Integer sentUser) {
        this.sentUser = sentUser;
    }

    public Integer getReciveUser() {
        return reciveUser;
    }

    public void setReciveUser(Integer reciveUser) {
        this.reciveUser = reciveUser;
    }

    public Integer getMessageid() {
        return messageid;
    }

    public void setMessageid(Integer messageid) {
        this.messageid = messageid;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Short getIsRead() {
        return isRead;
    }

    public void setIsRead(Short isRead) {
        this.isRead = isRead;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }
}
