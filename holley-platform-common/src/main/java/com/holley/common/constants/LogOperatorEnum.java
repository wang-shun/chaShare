package com.holley.common.constants;

import org.apache.commons.lang3.StringUtils;

/**
 * 日志操作方式
 * 
 * @author zhouli
 */
public enum LogOperatorEnum {

    ADD("add", "新增"), MODIFY("modify", "修改"), DELETE("del", "删除"), SEND("send", "下发"), ACCESS("access", "访问"), ERROR("error", "异常"), APPLY("apply", "申请"), VALID("valid", "验证");

    private final String value;
    private final String title;

    LogOperatorEnum(String value, String title) {
        this.value = value;
        this.title = title;
    }

    public String getValue() {
        return value;
    }

    public String getTitle() {
        return title;
    }

    public static String getTitle(String value) {
        LogOperatorEnum type = getEnmuByValue(value);
        return type == null ? null : type.getTitle();
    }

    /**
     * 通过传入的字符串匹配枚举，传入值
     * 
     * @param value
     * @return
     */
    public static LogOperatorEnum getEnmuByValue(String value) {
        for (LogOperatorEnum log : LogOperatorEnum.values()) {
            if (StringUtils.equals(value, log.getValue())) {
                return log;
            }
        }
        return null;
    }

    /**
     * 通过传入的字符串匹配枚举,传入名字
     * 
     * @param name
     * @return
     */
    public static LogOperatorEnum getEnmuByName(String name) {
        if (StringUtils.isEmpty(name)) {
            return null;
        }
        for (LogOperatorEnum log : LogOperatorEnum.values()) {
            if (StringUtils.equals(name, log.toString())) {
                return log;
            }
        }
        return null;
    }

}
