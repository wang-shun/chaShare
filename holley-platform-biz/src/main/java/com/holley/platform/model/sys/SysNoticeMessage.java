package com.holley.platform.model.sys;

import java.util.Date;

import com.holley.common.util.DateUtil;

public class SysNoticeMessage {

    private Integer id;

    private String  title;

    private String  content;

    private Date    addTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getAddTimeDesc() {
        String result = "";
        if (addTime != null) {
            result = DateUtil.DateToLongStr(addTime);
        }
        return result;
    }
}
