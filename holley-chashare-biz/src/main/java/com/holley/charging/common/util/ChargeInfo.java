package com.holley.charging.common.util;

import java.io.Serializable;
import java.util.Date;

import com.holley.common.constants.charge.ChargeStepEnum;

public class ChargeInfo implements Serializable {

    private static final long serialVersionUID = -646869358291186678L;
    private Integer           pileId;
    private String            tradeNo;                                // 充电订单号
    private String            connectorID;                            // 充电设备接口
    private int               upStatus;                               // 最新状态 参考：PileStatusEnum
    private Date              updateTime;                             // 最新时间
    private int               count;
    private ChargeStepEnum    step             = ChargeStepEnum.START;

    public Integer getPileId() {
        return pileId;
    }

    public void setPileId(Integer pileId) {
        this.pileId = pileId;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public String getConnectorID() {
        return connectorID;
    }

    public void setConnectorID(String connectorID) {
        this.connectorID = connectorID;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getUpStatus() {
        return upStatus;
    }

    public void setUpStatus(int upStatus) {
        this.upStatus = upStatus;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public ChargeStepEnum getStep() {
        return step;
    }

    public void setStep(ChargeStepEnum step) {
        this.step = step;
    }

}
