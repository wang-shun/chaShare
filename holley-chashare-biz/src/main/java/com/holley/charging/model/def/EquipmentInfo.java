package com.holley.charging.model.def;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Description: 充电设备信息
 *
 * @author shen.cheng@holley.cn
 */
public class EquipmentInfo {

    @JSONField(name = "EquipmentID")
    private String              equipmentID;          // 设备编码
    @JSONField(name = "ManufacturerID")
    private String              manufacturerID   = ""; // 设备生产商组织机构代码
    @JSONField(name = "ManufacturerName")
    private String              manufacturerName = ""; // 设备型号名称
    @JSONField(name = "EquipmentModel")
    private String              equipmentModel;       // 设备型号
    @JSONField(name = "ProductionDate")
    private String              productionDate;       // 设备生产日期
    @JSONField(name = "EquipmentType")
    private Integer             equipmentType;        // 设备类型1：直流设备2：交流设备3：交直流一体设备4：无线设备5：其他
    @JSONField(name = "EquipmentLng")
    private String              equipmentLng     = ""; // 设备经度
    @JSONField(name = "EquipmentLat")
    private String              equipmentLat     = ""; // 设备纬度
    @JSONField(name = "Power")
    private String              power;                // 充电设备总功率
    @JSONField(name = "EquipmentName")
    private String              equipmentName;        // 设备名称
    @JSONField(name = "ConnectorInfos")
    private List<ConnectorInfo> connectorInfos;       // 充电设备接口列表

    public String getEquipmentID() {
        return equipmentID;
    }

    public void setEquipmentID(String equipmentID) {
        this.equipmentID = equipmentID;
    }

    public String getManufacturerID() {
        return manufacturerID;
    }

    public void setManufacturerID(String manufacturerID) {
        this.manufacturerID = manufacturerID;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public String getEquipmentModel() {
        return equipmentModel;
    }

    public void setEquipmentModel(String equipmentModel) {
        this.equipmentModel = equipmentModel;
    }

    public String getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(String productionDate) {
        this.productionDate = productionDate;
    }

    public Integer getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(Integer equipmentType) {
        this.equipmentType = equipmentType;
    }

    public String getEquipmentLng() {
        return equipmentLng;
    }

    public void setEquipmentLng(String equipmentLng) {
        this.equipmentLng = equipmentLng;
    }

    public String getEquipmentLat() {
        return equipmentLat;
    }

    public void setEquipmentLat(String equipmentLat) {
        this.equipmentLat = equipmentLat;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public List<ConnectorInfo> getConnectorInfos() {
        return connectorInfos;
    }

    public void setConnectorInfos(List<ConnectorInfo> connectorInfos) {
        this.connectorInfos = connectorInfos;
    }

}
