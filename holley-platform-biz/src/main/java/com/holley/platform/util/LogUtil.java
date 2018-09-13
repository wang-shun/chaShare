package com.holley.platform.util;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.BeanUtilsBean2;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;

import com.holley.common.constants.LogOperatorEnum;
import com.holley.common.constants.LogTypeEnum;
import com.holley.common.util.StringUtil;
import com.holley.platform.model.sys.SysOperationLog;
import com.holley.platform.service.LogService;

/**
 * 操作日志
 * 
 * @author zdd
 */
public class LogUtil {

    private static LogService logService;

    /**
     * 记录登录日志
     */
    public static void recordLoginlog(Integer userid, String ip, String content, boolean isapp) {
        if (isapp) {// app登录
            recordOperationLog(userid, LogTypeEnum.APP_RUN_LOGIN, LogOperatorEnum.ACCESS, ip, null, content);
        } else {// 系统登录
            recordOperationLog(userid, LogTypeEnum.RUN_LOGIN, LogOperatorEnum.ACCESS, ip, null, content);
        }
    }

    /**
     * 记录档案的修改日志
     */
    public static void recordDocumentlog(Integer userid, LogOperatorEnum operator, String ip, String module, String content, boolean isapp) {
        if (isapp) {// app修改档案
            recordOperationLog(userid, LogTypeEnum.APP_RUN_RECORD, operator, ip, module, content);
        } else {// 系统修改档案
            recordOperationLog(userid, LogTypeEnum.RUN_RECORD, operator, ip, module, content);
        }
    }

    /**
     * 记录拒绝的访问日志，用于登录前/后
     * 
     * @param operator 操作说明
     * @param content 内容
     */
    public static void recordRefuselog(Integer userid, String ip, String content, boolean isapp) {
        if (userid == null) return;
        if (isapp) {
            recordOperationLog(userid, LogTypeEnum.APP_ERROR_REFUSE, LogOperatorEnum.ACCESS, ip, null, content);
        } else {
            recordOperationLog(userid, LogTypeEnum.ERROR_REFUSE, LogOperatorEnum.ACCESS, ip, null, content);
        }
    }

    // /**
    // * 记录权限日志
    // */
    // public static void recordRolelog(Integer userid, LogOperatorEnum operator, String ip, String module, String
    // content) {
    // recordOperationLog(userid, LogTypeEnum.RUN_ACCTOUNT, operator, ip, module, content);
    // }
    //
    // /**
    // * 记录资源访问日志
    // *
    // * @param operator 操作说明
    // * @param content 内容
    // */
    // public static void recordAccesslog(Integer userid, String ip, String content) {
    // recordOperationLog(userid, LogTypeEnum.RUN_QUEST, LogOperatorEnum.ACCESS, ip, null, content);
    // }
    //
    // /**
    // * 记录拒绝的访问日志,用于登录后
    // *
    // * @param operator 操作说明
    // * @param content 内容
    // */
    // public static void recordErrorlog(Integer userid, String ip, String content) {
    // if (StringUtil.isNotEmpty(content)) {
    // if (content.length() >= 1024) {
    // content = content.substring(0, 1022);
    // }
    // recordOperationLog(userid, LogTypeEnum.ERROR_RUN, LogOperatorEnum.ERROR, ip, null, content);
    // }
    // }

    public static int insertOperationLog(SysOperationLog record) {
        return logService.insertOperationLog(record);
    }

    public static int insertOperationLogBatch(List<SysOperationLog> list) {
        return logService.insertOperationLogBatch(list);
    }

    /**
     * 获取属性名数组
     */
    public static String[] getFiledName(Object o) {
        Field[] fields = o.getClass().getDeclaredFields();
        String[] fieldNames = new String[fields.length];
        for (int i = 0; i < fields.length; i++) {
            System.out.println(fields[i].getType());
            fieldNames[i] = fields[i].getName();
        }
        return fieldNames;
    }

    /**
     * 写入日志的内容
     * 
     * @return
     */
    public static String createLogContext(Object dto) throws Exception {
        String[] fieldNameArray = getFiledName(dto);
        StringBuilder sb = new StringBuilder("{");
        if (dto != null) {
            BeanUtilsBean.setInstance(new BeanUtilsBean2());
            DateConverter converter = new DateConverter();
            converter.setPattern("yyyy-MM-dd HH:mm:ss");
            ConvertUtils.register(converter, Date.class);
            for (int i = 0; i < fieldNameArray.length; i++) {
                String value = BeanUtils.getProperty(dto, fieldNameArray[i]);
                if (value == null) continue;
                sb.append(fieldNameArray[i] + ":" + value + ",");
            }
        }
        sb.append("}");
        return sb.toString();
    }

    public static String createLogContext(Object dto, String[] fieldNameArray) throws Exception {
        StringBuilder sb = new StringBuilder("{");
        if (dto != null) {
            BeanUtilsBean.setInstance(new BeanUtilsBean2());
            DateConverter converter = new DateConverter();
            converter.setPattern("yyyy-MM-dd HH:mm:ss");
            ConvertUtils.register(converter, Date.class);
            for (int i = 0; i < fieldNameArray.length; i++) {
                String value = BeanUtils.getProperty(dto, fieldNameArray[i]);
                if (value == null) continue;
                sb.append(fieldNameArray[i] + ":" + value + ",");
            }
        }
        sb.append("}");
        return sb.toString();
    }

    public static int recordOperationLog(Integer userid, LogTypeEnum logtype, LogOperatorEnum operatetype, String ip, String moduleid, String content) {
        SysOperationLog record = getOperationLog(userid, logtype, operatetype, ip, moduleid, content);
        return insertOperationLog(record);
    }

    public static SysOperationLog getOperationLog(Integer userid, LogTypeEnum logtype, LogOperatorEnum operatetype, String ip, String moduledesc, String content) {
        StringBuilder sb = new StringBuilder();
        sb.append(operatetype.getTitle()).append("; ");
        if (StringUtil.isNotEmpty(moduledesc)) {
            sb.append(moduledesc).append("; ");
        }
        sb.append(content);

        SysOperationLog record = new SysOperationLog();
        record.setUserId(userid);
        record.setType(logtype.getValue());
        record.setDescribed(sb.toString());
        record.setIp(ip);
        record.setAddTime(new Date());
        return record;
    }

    public void setLogService(LogService logService) {
        LogUtil.logService = logService;
    }

}
