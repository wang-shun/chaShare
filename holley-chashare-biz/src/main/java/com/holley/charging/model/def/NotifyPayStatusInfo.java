package com.holley.charging.model.def;

import java.io.Serializable;

public class NotifyPayStatusInfo implements Serializable {

    private static final long serialVersionUID = -8614701884867592332L;
    private String            params;
    private String            seq;                                     // 订单号
    private int               delay;                                   // 延迟时间
    private int               pushCount;                               // 推送次数
    private long              updateTime;                              // 更新时间戳

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public int getPushCount() {
        return pushCount;
    }

    public void setPushCount(int pushCount) {
        this.pushCount = pushCount;
    }

}
