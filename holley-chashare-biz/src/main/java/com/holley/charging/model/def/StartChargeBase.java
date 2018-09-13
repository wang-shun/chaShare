package com.holley.charging.model.def;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Description:请求启动充电
 *
 * @author shen.cheng@holley.cn
 */
public class StartChargeBase {

    @JSONField(name = "StartChargeSeq")
    private String startChargeSeq;    // 充电订单号运营商ID+yyyyMMddHHmmss+4位随机数
    @JSONField(name = "StartChargeSeqStat")
    private int    startChargeSeqStat; // 充电订单状态1.启动中2.充电中3.停止中4.已结束5.未知
    @JSONField(name = "ConnectorID")
    private String connectorID;       // 充电设备接口编码
    @JSONField(name = "SuccStat")
    private int    succStat;          // 结果状态 0.成功1.失败
    @JSONField(name = "FailReason")
    private int    failReason;        // 失败原因 0.无 1.此设备不存在 2.此设备离线

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
