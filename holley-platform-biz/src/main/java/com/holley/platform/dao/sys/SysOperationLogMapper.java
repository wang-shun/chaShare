package com.holley.platform.dao.sys;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.holley.platform.model.sys.SysOperationLog;
import com.holley.platform.model.sys.SysOperationLogExample;

public interface SysOperationLogMapper {

    int countByExample(SysOperationLogExample example);

    int deleteByExample(SysOperationLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysOperationLog record);

    int insertSelective(SysOperationLog record);

    List<SysOperationLog> selectByExample(SysOperationLogExample example);

    SysOperationLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysOperationLog record, @Param("example") SysOperationLogExample example);

    int updateByExample(@Param("record") SysOperationLog record, @Param("example") SysOperationLogExample example);

    int updateByPrimaryKeySelective(SysOperationLog record);

    int updateByPrimaryKey(SysOperationLog record);

    /**
     * 批量插入
     * 
     * @param list
     * @return
     */
    int insertOperationLogBatch(List<SysOperationLog> list);

    List<SysOperationLog> selectOperationLogByPage(Map<String, Object> params);
}
