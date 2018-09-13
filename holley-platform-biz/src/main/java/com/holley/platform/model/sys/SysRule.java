package com.holley.platform.model.sys;

import java.util.Date;

import com.holley.common.constants.RuleStatusEnum;
import com.holley.common.util.DateUtil;

public class SysRule {

    private String id;

    private String name;

    private Short  status;

    private String ruleCheck;

    private String remark;

    private Date   addTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public String getRuleCheck() {
        return ruleCheck;
    }

    public void setRuleCheck(String ruleCheck) {
        this.ruleCheck = ruleCheck == null ? null : ruleCheck.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getStatusDesc() {
        if (status == null) return "";
        String result = RuleStatusEnum.getText(status.intValue());
        return result == null ? "" : result;
    }

    public String getAddTimeStr() {
        if (addTime == null) return "";
        return DateUtil.DateToLongStr(addTime);
    }
}
