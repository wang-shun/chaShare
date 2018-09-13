package com.holley.charging.model.def;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Description:推送启动充电结果
 *
 * @author shen.cheng@holley.cn
 */
public class NotificationStartChargeResultBase {

    @JSONField(name = "StartChargeSeq")
    private String startChargeSeq;    // 充电订单号
    @JSONField(name = "StartChargeSeqStat")
    private int    startChargeSeqStat; // 1.启动中2.充电中3.停止中4.已结束5.未知
    @JSONField(name = "ConnectorID")
    private String connectorID;       // 充电设备接口
    @JSONField(name = "StartTime")
    private String startTime;         // 充电启动时间
    @JSONField(name = "IdentCode")
    private String identCode;         // 启动收到的验证码用于手动停止

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

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public int getStartChargeSeqStat() {
        return startChargeSeqStat;
    }

    public void setStartChargeSeqStat(int startChargeSeqStat) {
        this.startChargeSeqStat = startChargeSeqStat;
    }

    public String getIdentCode() {
        return identCode;
    }

    public void setIdentCode(String identCode) {
        this.identCode = identCode;
    }

}
