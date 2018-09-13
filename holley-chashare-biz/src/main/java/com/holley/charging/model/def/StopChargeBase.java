package com.holley.charging.model.def;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Description: 请求停止充电
 *
 * @author shen.cheng@holley.cn
 */
public class StopChargeBase {

    @JSONField(name = "StartChargeSeq")
    private String startChargeSeq;    // 充电订单号此订单号与启动充电结果推送的订单号一致
    @JSONField(name = "StartChargeSeqStat")
    private int    startChargeSeqStat; // 充电订单状态1.启动中2.充电中3.停止中4.已结束5.未知
    @JSONField(name = "SuccStat")
    private int    succStat;          // 结果状态
    @JSONField(name = "FailReason")
    private int    failReason;        // 失败原因0：无1：此设备不存在2.此设备离线3.设备已停止充电4.自定义。。。

    public String getStartChargeSeq() {
        return startChargeSeq;
    }

    public void setStartChargeSeq(String startChargeSeq) {
        this.startChargeSeq = startChargeSeq;
    }

    public int getSuccStat() {
        return succStat;
    }

    public void setSuccStat(int succStat) {
        this.succStat = succStat;
    }

    public int getFailReason() {
        return failReason;
    }

    public void setFailReason(int failReason) {
        this.failReason = failReason;
    }

    public int getStartChargeSeqStat() {
        return startChargeSeqStat;
    }

    public void setStartChargeSeqStat(int startChargeSeqStat) {
        this.startChargeSeqStat = startChargeSeqStat;
    }

}
