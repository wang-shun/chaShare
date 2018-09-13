package com.holley.charging.model.def;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Description: 查询充电状态
 *
 * @author shen.cheng@holley.cn
 */
public class EquipChargeStatusBase {

    @JSONField(name = "StartChargeSeq")
    private String startChargeSeq;    // 充电订单号此订单号与启动充电结果推送的订单号一致
    @JSONField(name = "StartChargeSeqStat")
    private int    startChargeSeqStat; // 充电订单状态1.启动中2.充电中3.停止中4.已结束5.未知
    @JSONField(name = "ConnectorID")
    private String connectorID;       // 充电设备接口编码
    @JSONField(name = "ConnectorStatus")
    private int    connectorStatus;   // 充电接口状态1.空闲2.未充电3.充电中4.预约255.故障
    @JSONField(name = "CurrentA")
    private double currentA    = 0;   // A相电流
    @JSONField(name = "CurrentB")
    private double currentB    = 0;   // B相电流
    @JSONField(name = "CurrentC")
    private double currentC    = 0;   // C相电流
    @JSONField(name = "VoltageA")
    private double voltageA    = 0;   // A相电压
    @JSONField(name = "VoltageB")
    private double voltageB    = 0;   // B相电压
    @JSONField(name = "VoltageC")
    private double voltageC    = 0;   // C相电压
    @JSONField(name = "Soc")
    private double soc         = 0;   // 电池剩余电量
    @JSONField(name = "StartTime")
    private String startTime;         // 开始充电时间yyyy-MM-dd HH:mm:ss
    @JSONField(name = "EndTime")
    private String endTime;           // 本次采样时间yyyy-MM-dd HH:mm:ss
    @JSONField(name = "TotalPower")
    private double totalPower  = 0;   // 累计充电量
    @JSONField(name = "ElecMoney")
    private double elecMoney   = 0;   // 累计电费
    @JSONField(name = "SeviceMoney")
    private double seviceMoney = 0;   // 累计服务费
    @JSONField(name = "TotalMoney")
    private double totalMoney  = 0;   // 累计总金额

    // private int sumPeriod = 0; // 时段数N=0-32

    // private ChargeDetails chargeDetails;//充电明细信息

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

    public int getConnectorStatus() {
        return connectorStatus;
    }

    public void setConnectorStatus(int connectorStatus) {
        this.connectorStatus = connectorStatus;
    }

    public double getCurrentA() {
        return currentA;
    }

    public void setCurrentA(double currentA) {
        this.currentA = currentA;
    }

    public double getCurrentB() {
        return currentB;
    }

    public void setCurrentB(double currentB) {
        this.currentB = currentB;
    }

    public double getCurrentC() {
        return currentC;
    }

    public void setCurrentC(double currentC) {
        this.currentC = currentC;
    }

    public double getVoltageA() {
        return voltageA;
    }

    public void setVoltageA(double voltageA) {
        this.voltageA = voltageA;
    }

    public double getVoltageB() {
        return voltageB;
    }

    public void setVoltageB(double voltageB) {
        this.voltageB = voltageB;
    }

    public double getVoltageC() {
        return voltageC;
    }

    public void setVoltageC(double voltageC) {
        this.voltageC = voltageC;
    }

    public double getSoc() {
        return soc;
    }

    public void setSoc(double soc) {
        this.soc = soc;
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

    public double getTotalPower() {
        return totalPower;
    }

    public void setTotalPower(double totalPower) {
        this.totalPower = totalPower;
    }

    public double getElecMoney() {
        return elecMoney;
    }

    public void setElecMoney(double elecMoney) {
        this.elecMoney = elecMoney;
    }

    public double getSeviceMoney() {
        return seviceMoney;
    }

    public void setSeviceMoney(double seviceMoney) {
        this.seviceMoney = seviceMoney;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public int getStartChargeSeqStat() {
        return startChargeSeqStat;
    }

    public void setStartChargeSeqStat(int startChargeSeqStat) {
        this.startChargeSeqStat = startChargeSeqStat;
    }

}
