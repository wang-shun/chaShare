package com.holley.charging.model.bus;

import java.util.Date;

public class BusPileComment {

    private Integer id;

    private Integer userId;

    private Integer pileId;

    private Integer chargerecordId;

    private String  content;

    private String  path;

    private Integer pid;

    private Date    addTime;

    private Short   score;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPileId() {
        return pileId;
    }

    public void setPileId(Integer pileId) {
        this.pileId = pileId;
    }

    public Integer getChargerecordId() {
        return chargerecordId;
    }

    public void setChargerecordId(Integer chargerecordId) {
        this.chargerecordId = chargerecordId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Short getScore() {
        return score;
    }

    public void setScore(Short score) {
        this.score = score;
    }


}
