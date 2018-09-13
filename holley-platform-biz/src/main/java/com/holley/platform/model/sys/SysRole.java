package com.holley.platform.model.sys;

import java.util.Date;

import com.holley.common.constants.RoleTypeEnum;
import com.holley.common.constants.charge.RoleStatusEnum;
import com.holley.common.util.DateUtil;

public class SysRole {

    private Integer id;

    private String  rolename;

    private Short   type;

    private Short   status;

    private String  remark;

    private Integer creator;

    private Date    addTime;

    private String  typedesc;
    private String  statusdesc;
    private String  creatorname;
    private String  addTimeStr;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename == null ? null : rolename.trim();
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getCreatorname() {
        return creatorname;
    }

    public void setCreatorname(String creatorname) {
        this.creatorname = creatorname;
    }

    public String getTypedesc() {
        if (type == null) return "";
        String desc = RoleTypeEnum.getText(type.intValue());
        return desc == null ? "" : desc;
    }

    public String getStatusdesc() {
        if (status == null) return "";
        String desc = RoleStatusEnum.getText(status.intValue());
        return desc == null ? "" : desc;
    }

    public String getAddTimeStr() {
        if (addTime == null) return "";
        return DateUtil.DateToLongStr(addTime);
    }

}
