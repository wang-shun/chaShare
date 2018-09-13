package com.holley.charging.model.def;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Description: 推送停止充电结果
 *
 * @author shen.cheng@holley.cn
 */
public class NotificationStopChargeResultBase {

    @JSONField(name = "StartChargeSeq")
    private String startChargeSeq;    // 充电订单号此订单号与启动充电结果推送的订单号一致
    @JSONField(name = "StartChargeSeqStat")
    private int    startChargeSeqStat; // 1.启动中2.充电中3.停止中4.已结束5.未知
    @JSONField(name = "ConnectorID")
    private String connectorID;
    @JSONField(name = "SuccStat")
    private int    succStat;          // 结果标识0.成功1.失败
    @JSONField(name = "FailReason")
    private int    failReason;        // 充电停止失败原因0.无1.次设备不存在2.次设备离线3.设备已停止充电

    public String getStartChargeSeq() {
        return startChargeSeq;
    }

    public void setStartChargeSeq(String startChargeSeq) {
        this.startChargeSeq = startChargeSeq;
    }

    public String getConnectorID() {
        return connectorID;
    }

    public void setConnectorID(String connectorID) {
        this.connectorID = connectorID;
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
