package com.holley.charging.model.def;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Description:设备认证返回bean
 *
 * @author shen.cheng@holley.cn
 */
public class EquipAuthBase {

    @JSONField(name = "EquipAuthSeq")
    private String  equipAuthSeq; // 设备认证流水号，运营商ID+yyyyMMddHHmmss+4位随机数
    @JSONField(name = "ConnectorID")
    private String  connectorID; // 设备编码
    @JSONField(name = "SuccStat")
    private Integer succStat;    // 认证状态0.成功1.失败
    @JSONField(name = "FailReason")
    private Integer failReason;  // 失败原因 0.无1.此设备尚未插抢2.设备检查失败 3.自定义。。。

    public String getEquipAuthSeq() {
        return equipAuthSeq;
    }

    public void setEquipAuthSeq(String equipAuthSeq) {
        this.equipAuthSeq = equipAuthSeq;
    }

    public String getConnectorID() {
        return connectorID;
    }

    public void setConnectorID(String connectorID) {
        this.connectorID = connectorID;
    }

    public Integer getSuccStat() {
        return succStat;
    }

    public void setSuccStat(Integer succStat) {
        this.succStat = succStat;
    }

    public Integer getFailReason() {
        return failReason;
    }

    public void setFailReason(Integer failReason) {
        this.failReason = failReason;
    }

}
