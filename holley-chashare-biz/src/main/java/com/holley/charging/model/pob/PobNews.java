package com.holley.charging.model.pob;

import java.util.Date;

public class PobNews {

    private Integer id;

    private Short   type;
    private String  typedesc;

    private String  title;

    private String  summary;

    private String  picture;

    private String  publisher;

    private Date    publishdate;
    private String  publishdatestr;

    private Short   status;

    private Short   orderby;

    private Integer visitcount;

    private Short   istop;


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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher == null ? null : publisher.trim();
    }

    public Date getPublishdate() {
        return publishdate;
    }

    public void setPublishdate(Date publishdate) {
        this.publishdate = publishdate;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Short getOrderby() {
        return orderby;
    }

    public void setOrderby(Short orderby) {
        this.orderby = orderby;
    }

    public Integer getVisitcount() {
        return visitcount;
    }

    public void setVisitcount(Integer visitcount) {
        this.visitcount = visitcount;
    }

    public Short getIstop() {
        return istop;
    }

    public void setIstop(Short istop) {
        this.istop = istop;
    }


}
