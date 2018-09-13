package com.holley.charging.model.def;

import java.math.BigDecimal;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Description: 推送充电订单信息
 *
 * @author shen.cheng@holley.cn
 */
public class NotificationChargeOrderInfoBase {

    @JSONField(name = "StartChargeSeq")
    private String     startChargeSeq;  // 充电订单号此订单号与启动充电结果推送的订单号一致
    @JSONField(name = "ConnectorID")
    private String     connectorID;     // 充电接口编码
    @JSONField(name = "StartTime")
    private String     startTime;       // 开始充电时间yyyy-MM-dd HH:mm:ss
    @JSONField(name = "EndTime")
    private String     endTime;         // 停止充电时间yyyy-MM-dd HH:mm:ss
    @JSONField(name = "TotalPower")
    private BigDecimal totalPower;      // 度 累计充电量保留2位
    @JSONField(name = "TotalElecMoney")
    private BigDecimal totalElecMoney;  // 元 总电费保留2位
    @JSONField(name = "TotalSeviceMoney")
    private BigDecimal totalSeviceMoney; // 元 总服务费保留2位
    @JSONField(name = "TotalMoney")
    private BigDecimal totalMoney;      // 元 累计总金额保留2位
    @JSONField(name = "StopReason")
    private int        stopReason;      // 充电结束原因0.用户收到停止充电1.客户归属地运营商平台停止充电2.BMS停止充电3.充电机设备故障4.连接器断开

    // private int sumPeriod; // 时段数
    // private ChargeDetails chargeDetails;

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

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public BigDecimal getTotalPower() {
        return totalPower;
    }

    public void setTotalPower(BigDecimal totalPower) {
        this.totalPower = totalPower;
    }

    public BigDecimal getTotalElecMoney() {
        return totalElecMoney;
    }

    public void setTotalElecMoney(BigDecimal totalElecMoney) {
        this.totalElecMoney = totalElecMoney;
    }

    public BigDecimal getTotalSeviceMoney() {
        return totalSeviceMoney;
    }

    public void setTotalSeviceMoney(BigDecimal totalSeviceMoney) {
        this.totalSeviceMoney = totalSeviceMoney;
    }

    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
    }

    public int getStopReason() {
        return stopReason;
    }

    public void setStopReason(int stopReason) {
        this.stopReason = stopReason;
    }

}
