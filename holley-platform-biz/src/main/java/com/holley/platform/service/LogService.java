package com.holley.platform.service;

import java.util.List;
import java.util.Map;

import com.holley.platform.model.sys.SysOperationLog;

public interface LogService {

    /**
     * 日志插入
     * 
     * @param record
     * @return
     */
    int insertOperationLog(SysOperationLog record);

    /**
     * 批量插入
     * 
     * @param list
     * @return
     */
    int insertOperationLogBatch(List<SysOperationLog> list);

    /**
     * 分页查询操作日志
     * 
     * @param params
     * @return
     */
    List<SysOperationLog> selectOperationLogByPage(Map<String, Object> params);

}
