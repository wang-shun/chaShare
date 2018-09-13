package com.holley.charging.model.def;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Description: 设备运营商信息
 *
 * @author shen.cheng@holley.cn
 */
public class OperatorInfo {

    @JSONField(name = "OperatorID")
    private String operatorID;        // 运营商组织机构代码
    @JSONField(name = "OperatorName")
    private String operatorName;      // 运营商名称
    @JSONField(name = "OperatorTel1")
    private String operatorTel1;      // 运营商电话1
    @JSONField(name = "OperatorTel2")
    private String operatorTel2;      // 运营商电话2
    @JSONField(name = "OperatorRegAddress")
    private String operatorRegAddress; // 运营商注册地址
    @JSONField(name = "OperatorNote")
    private String operatorNote;      // 备注

    public String getOperatorID() {
        return operatorID;
    }

    public void setOperatorID(String operatorID) {
        this.operatorID = operatorID;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getOperatorTel1() {
        return operatorTel1;
    }

    public void setOperatorTel1(String operatorTel1) {
        this.operatorTel1 = operatorTel1;
    }

    public String getOperatorTel2() {
        return operatorTel2;
    }

    public void setOperatorTel2(String operatorTel2) {
        this.operatorTel2 = operatorTel2;
    }

    public String getOperatorRegAddress() {
        return operatorRegAddress;
    }

    public void setOperatorRegAddress(String operatorRegAddress) {
        this.operatorRegAddress = operatorRegAddress;
    }

    public String getOperatorNote() {
        return operatorNote;
    }

    public void setOperatorNote(String operatorNote) {
        this.operatorNote = operatorNote;
    }

}
