package com.holley.charging.model.def;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

public class EquipBusinessPolicyInfo {

    @JSONField(name = "ConnectorID")
    private String           connectorID;
    @JSONField(name = "EquipBizSeq")
    private String           equipBizSeq;
    @JSONField(name = "SuccStat")
    private Integer          succStat;   // 认证状态0.成功1.失败
    @JSONField(name = "FailReason")
    private Integer          failReason; // 失败原因 0.无1.此设备业务策略不存在
    @JSONField(name = "SumPeriod")
    private Integer          sumPeriod;  // 时段数N：0-32
    @JSONField(name = "PolicyInfos")
    private List<PolicyInfo> policyInfos;

    public String getConnectorID() {
        return connectorID;
    }

    public void setConnectorID(String connectorID) {
        this.connectorID = connectorID;
    }

    public String getEquipBizSeq() {
        return equipBizSeq;
    }

    public void setEquipBizSeq(String equipBizSeq) {
        this.equipBizSeq = equipBizSeq;
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

    public Integer getSumPeriod() {
        return sumPeriod;
    }

    public void setSumPeriod(Integer sumPeriod) {
        this.sumPeriod = sumPeriod;
    }

    public List<PolicyInfo> getPolicyInfos() {
        return policyInfos;
    }

    public void setPolicyInfos(List<PolicyInfo> policyInfos) {
        this.policyInfos = policyInfos;
    }

}
