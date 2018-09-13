package com.holley.charging.model.def;

import com.alibaba.fastjson.annotation.JSONField;
import com.holley.common.constants.share.LockStatusTypeEnum;
import com.holley.common.constants.share.ParkStatusTypeEnum;

/**
 * Description: 充电接口状态
 *
 * @author shen.cheng@holley.cn
 */
public class ConnectorStatusInfo {

    @JSONField(name = "ConnectorID")
    private String  connectorID;                                       // 充电接口编码
    @JSONField(name = "Status")
    private Integer status;                                            // 充电设备接口状态
                                                                        // 0：离网1：空闲2：占用（未充电）3：占用（充电中）4：占用（预约锁定）255：故障
    @JSONField(name = "ParkStatus")
    private Integer parkStatus = ParkStatusTypeEnum.UNKNOWN.getValue(); // 车位状态0：未知 10：空闲 50：占用
    @JSONField(name = "LockStatus")
    private Integer lockStatus = LockStatusTypeEnum.UNKNOWN.getValue(); // 地锁状态 0：未知 10：已解锁 50：已上锁

    public String getConnectorID() {
        return connectorID;
    }

    public void setConnectorID(String connectorID) {
        this.connectorID = connectorID;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getParkStatus() {
        return parkStatus;
    }

    public void setParkStatus(Integer parkStatus) {
        this.parkStatus = parkStatus;
    }

    public Integer getLockStatus() {
        return lockStatus;
    }

    public void setLockStatus(Integer lockStatus) {
        this.lockStatus = lockStatus;
    }

}
