package com.holley.charging.model.dcs;

import java.util.Date;

import com.holley.common.util.DateUtil;

public class DcsAlarmEvents {

    private Integer id;

    private Integer pileId;

    private String  eventId;

    private String  described;

    private Short   level;

    private Date    eventTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPileId() {
        return pileId;
    }

    public void setPileId(Integer pileId) {
        this.pileId = pileId;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId == null ? null : eventId.trim();
    }

    public String getDescribed() {
        return described;
    }

    public void setDescribed(String described) {
        this.described = described == null ? null : described.trim();
    }

    public Short getLevel() {
        return level;
    }

    public void setLevel(Short level) {
        this.level = level;
    }

    public Date getEventTime() {
        return eventTime;
    }

    public void setEventTime(Date eventTime) {
        this.eventTime = eventTime;
    }

    public String getLevelDesc() {
        String result = "未知";
        if (level != null) {
            switch (level) {
                case 1:
                    result = "Error";
                    break;
                case 2:
                    result = "Waring";
                    break;
                default:
                    break;
            }
        }
        return result;
    }

    public String getEventTimeDesc() {
        String result = "";
        if (eventTime != null) {
            result = DateUtil.DateToLongStr(eventTime);
        } else {
            result = "";
        }
        return result;
    }

}
