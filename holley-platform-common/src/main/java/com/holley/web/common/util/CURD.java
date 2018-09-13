package com.holley.web.common.util;


/**
 * 需要增加修改删除功能的类可以实现此接口，统一固定url
 * 
 * @author zhouli
 */
public interface CURD {

    public String init() throws Exception;

    public String query() throws Exception;

    public String add() throws Exception;

    public String modify() throws Exception;

    public String del() throws Exception;

}
