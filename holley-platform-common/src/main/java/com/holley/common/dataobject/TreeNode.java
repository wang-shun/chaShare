package com.holley.common.dataobject;

import java.util.List;

public class TreeNode {

    public String         id;
    public String         text;
    public String         type;
    public boolean        leaf;
    public String         url;
    public List<TreeNode> children;
    public Boolean        checked;
    public String         iconCls;
    public String         cls;
    public String         qtip;
    public int            total;
    public String         remarks;
    public boolean        expanded = false;
    public int            checkState;      // 树节点选中状态，0：不选中，1：选中，2：半选
    public String         data;

    public TreeNode() {
    }

    public TreeNode(String id, String text, String type) {
        this.id = id;
        this.text = text;
        this.type = type;
    }

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isLeaf() {
        return leaf;
    }

    public void setLeaf(boolean leaf) {
        this.leaf = leaf;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    public String getQtip() {
        return qtip;
    }

    public void setQtip(String qtip) {
        this.qtip = qtip;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    public String getCls() {
        return cls;
    }

    public void setCls(String cls) {
        this.cls = cls;
    }

    public int getCheckState() {
        return checkState;
    }

    public void setCheckState(int checkState) {
        this.checkState = checkState;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

}
