package com.holley.charging.model.def;

import com.alibaba.fastjson.annotation.JSONField;
import com.holley.common.constants.share.ConnectorTypeEnum;

/**
 * Description: 充电设备接口信息
 *
 * @author shen.cheng@holley.cn
 */
public class ConnectorInfo {

    @JSONField(name = "ConnectorID")
    private String  connectorID;                                            // 充电接口编码
    @JSONField(name = "ConnectorName")
    private String  connectorName;                                          // 充电接口名称
    @JSONField(name = "ConnectorType")
    private Integer connectorType      = ConnectorTypeEnum.OTHER.getValue(); // 充电接口类型1：家用插座（模式2）2：交流接口插座（模式3，连接方式B
    // ）3：交流接口插头（带枪线，模式3，连接方式C）4：直流接口枪头（带枪线，模式4）5：无线充电座6：其他
    @JSONField(name = "VoltageUpperLimits")
    private String  voltageUpperLimits = "";                                // 额定电压上限
    @JSONField(name = "VoltageLowerLimits")
    private String  voltageLowerLimits = "";                                // 额定电压下限
    @JSONField(name = "Current")
    private String  current            = "";                                // 额定电流
    @JSONField(name = "Power")
    private String  power              = "";                                // 额定功率
    @JSONField(name = "ParkNo")
    private String  parkNo             = "";                                // 车位号
    @JSONField(name = "NationalStandard")
    private String  nationalStandard   = "2011";                            // 国家标准1:2011 2:2015

    public String getConnectorID() {
        return connectorID;
    }

    public void setConnectorID(String connectorID) {
        this.connectorID = connectorID;
    }

    public String getConnectorName() {
        return connectorName;
    }

    public void setConnectorName(String connectorName) {
        this.connectorName = connectorName;
    }

    public Integer getConnectorType() {
        return connectorType;
    }

    public void setConnectorType(Integer connectorType) {
        this.connectorType = connectorType;
    }

    public String getVoltageUpperLimits() {
        return voltageUpperLimits;
    }

    public void setVoltageUpperLimits(String voltageUpperLimits) {
        this.voltageUpperLimits = voltageUpperLimits;
    }

    public String getVoltageLowerLimits() {
        return voltageLowerLimits;
    }

    public void setVoltageLowerLimits(String voltageLowerLimits) {
        this.voltageLowerLimits = voltageLowerLimits;
    }

    public String getCurrent() {
        return current;
    }

    public void setCurrent(String current) {
        this.current = current;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getParkNo() {
        return parkNo;
    }

    public void setParkNo(String parkNo) {
        this.parkNo = parkNo;
    }

    public String getNationalStandard() {
        return nationalStandard;
    }

    public void setNationalStandard(String nationalStandard) {
        this.nationalStandard = nationalStandard;
    }

}
