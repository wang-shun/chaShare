package com.holley.charging.common.model;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.holley.common.dataobject.Page;

/**
 * 供查询用的一些基础属性
 * 
 * @author zhouli
 */
public class BaseExample {

    // 方案：2日，3月
    private Short               schemeId;

    private Page                page;
    // 临时表的名字
    private String              tempTableName;

    // 单个表名
    private String              tableName;
    // 第二个表名
    private String              tableName2;
    // 多个表名
    private List<String>        tableNameList;

    // 查询日期
    private Date                datatime;
    private Date                datatime2;

    // ---------------------

    private Map<String, Object> map;

    // --------------------- get set

    public String getTableName2() {
        return tableName2;
    }

    public void setTableName2(String tableName2) {
        this.tableName2 = tableName2;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<String> getTableNameList() {
        return tableNameList;
    }

    public void setTableNameList(List<String> tableNameList) {
        this.tableNameList = tableNameList;
    }

    public String getTempTableName() {
        return tempTableName;
    }

    public void setTempTableName(String tempTableName) {
        this.tempTableName = tempTableName;
    }

    public Date getDatatime() {
        return datatime;
    }

    public void setDatatime(Date datatime) {
        this.datatime = datatime;
    }

    public Date getDatatime2() {
        return datatime2;
    }

    public void setDatatime2(Date datatime2) {
        this.datatime2 = datatime2;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public Short getSchemeId() {
        return schemeId;
    }

    public void setSchemeId(Short schemeId) {
        this.schemeId = schemeId;
    }

}
