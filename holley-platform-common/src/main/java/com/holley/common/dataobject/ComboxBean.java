package com.holley.common.dataobject;

/**
 * 下来框用到的数据bean
 * 
 * @author Administrator
 */
public class ComboxBean {

    private String key;      // 显示的数据
    private String value;    // 实际的数据
    private String pointDisc; //
    private String value2;

    public ComboxBean() {

    }

    public ComboxBean(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public ComboxBean(String key, String value, String value2) {
        this.key = key;
        this.value = value;
        this.value2 = value2;
    }

    public String getPointDisc() {
        return pointDisc;
    }

    public void setPointDisc(String pointDisc) {
        this.pointDisc = pointDisc;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue2() {
        return value2;
    }

    public void setValue2(String value2) {
        this.value2 = value2;
    }

    public String toString() {// 重写toString 。不然显示的是类名+地址
        return key;
    }
}
