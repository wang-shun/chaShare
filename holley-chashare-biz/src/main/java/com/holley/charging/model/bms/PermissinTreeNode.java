package com.holley.charging.model.bms;

import java.util.List;

import com.holley.platform.model.sys.SysButtondef;

public class PermissinTreeNode {

    public String                  id;
    public String                  text;
    public List<PermissinTreeNode> children;
    public Boolean                 checked;
    public String                  iconCls;
    public int                     checkState; // 树节点选中状态，0：不选中，1：选中，2：半选
    public List<SysButtondef>      buttons;
    public boolean                 leaf;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<PermissinTreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<PermissinTreeNode> children) {
        this.children = children;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public int getCheckState() {
        return checkState;
    }

    public void setCheckState(int checkState) {
        this.checkState = checkState;
    }

    public List<SysButtondef> getButtons() {
        return buttons;
    }

    public void setButtons(List<SysButtondef> buttons) {
        this.buttons = buttons;
    }

    public boolean isLeaf() {
        return leaf;
    }

    public void setLeaf(boolean leaf) {
        this.leaf = leaf;
    }

}
