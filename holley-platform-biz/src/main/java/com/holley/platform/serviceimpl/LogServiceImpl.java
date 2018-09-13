package com.holley.platform.serviceimpl;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.holley.platform.dao.sys.SysOperationLogMapper;
import com.holley.platform.model.sys.SysOperationLog;
import com.holley.platform.service.LogService;

public class LogServiceImpl implements LogService {

    private static Log            log = LogFactory.getLog(LogServiceImpl.class);
    private SysOperationLogMapper sysOperationLogMapper;

    public int insertOperationLog(SysOperationLog record) {
        int row = 0;
        try {
            if (record.getDescribed().length() > 1000) record.setDescribed(record.getDescribed().substring(0, 1000) + "...");
            row = sysOperationLogMapper.insert(record);
        } catch (Exception e) {
            log.error("OperationLog save error:", e);
        }
        return row;
    }

    @Override
    public int insertOperationLogBatch(List<SysOperationLog> list) {
        if (list == null || list.size() == 0) {
            return 0;
        }
        for (SysOperationLog record : list) {
            if (record.getDescribed().length() > 1000) record.setDescribed(record.getDescribed().substring(0, 1000) + "...");
        }
        return sysOperationLogMapper.insertOperationLogBatch(list);
    }

    @Override
    public List<SysOperationLog> selectOperationLogByPage(Map<String, Object> params) {
        return sysOperationLogMapper.selectOperationLogByPage(params);
    }

    public void setSysOperationLogMapper(SysOperationLogMapper sysOperationLogMapper) {
        this.sysOperationLogMapper = sysOperationLogMapper;
    }

}
