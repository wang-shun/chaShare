package com.holley.common.dataobject;

import java.util.List;

public class Page {

    private int totalProperty; // 总记录数

    private List<?> root; // 分页结果

    private int startRow; // 起始行

    private int endRow; // 结束行

    private List<?> additionalList; // 额外的数据

    private Object obj; // 额外的数据

    public Page() {
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public List<?> getAdditionalList() {
        return additionalList;
    }

    public void setAdditionalList(List<?> additionalList) {
        this.additionalList = additionalList;
    }

    public Page(int start, int limit) {
        this.startRow = start;
        this.endRow = start + limit;
    }

    public String getTempTableName() {
        return tempTableName;
    }

    public void setTempTableName(String tempTableName) {
        this.tempTableName = tempTableName;
    }

    private String tempTableName; // 临时表名

    public int getTotalProperty() {
        return totalProperty;
    }

    public void setTotalProperty(int totalProperty) {
        this.totalProperty = totalProperty;
    }

    public List<?> getRoot() {
        return root;
    }

    public void setRoot(List<?> root) {
        this.root = root;
    }

    public int getStartRow() {
        return startRow;
    }

    public void setStartRow(int startRow) {
        this.startRow = startRow;
    }

    public int getEndRow() {
        return endRow;
    }

    public void setEndRow(int endRow) {
        this.endRow = endRow;
    }
}
