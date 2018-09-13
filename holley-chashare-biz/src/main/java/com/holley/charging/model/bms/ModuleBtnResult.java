package com.holley.charging.model.bms;

import java.util.List;

import com.holley.common.dataobject.TreeNode;
import com.holley.platform.model.sys.SysButtondef;

public class ModuleBtnResult {

    private String             moduleid;
    private String             moduledisc;
    private Boolean            checked;

    private List<TreeNode>     treeNodeList;
    private List<SysButtondef> buttonList;

    public String getModuleid() {
        return moduleid;
    }

    public void setModuleid(String moduleid) {
        this.moduleid = moduleid;
    }

    public String getModuledisc() {
        return moduledisc;
    }

    public void setModuledisc(String moduledisc) {
        this.moduledisc = moduledisc;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    public List<TreeNode> getTreeNodeList() {
        return treeNodeList;
    }

    public void setTreeNodeList(List<TreeNode> treeNodeList) {
        this.treeNodeList = treeNodeList;
    }

    public List<SysButtondef> getButtonList() {
        return buttonList;
    }

    public void setButtonList(List<SysButtondef> buttonList) {
        this.buttonList = buttonList;
    }
}
