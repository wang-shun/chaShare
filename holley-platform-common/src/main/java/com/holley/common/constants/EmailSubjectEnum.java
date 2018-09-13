package com.holley.common.constants;

/**
 * 角色类型 <br>
 */
public enum EmailSubjectEnum {
                              CERTIFICATION(1, "邮箱认证"), NOTICE(2, "邮箱通知");

    private final int    value;
    private final String text;

    EmailSubjectEnum(int value, String text) {
        this.value = value;
        this.text = text;
    }

    public int getValue() {
        return value;
    }

    public String getText() {
        return text;
    }

    public static String getText(int value) {
        EmailSubjectEnum task = getEnmuByValue(value);
        return task == null ? null : task.getText();
    }

    public Short getShortValue() {
        Integer obj = value;
        return obj.shortValue();
    }

    /**
     * 通过传入的值匹配枚举
     * 
     * @param value
     * @return
     */
    public static EmailSubjectEnum getEnmuByValue(int value) {
        for (EmailSubjectEnum record : EmailSubjectEnum.values()) {
            if (value == record.getValue()) {
                return record;
            }
        }
        return null;
    }
}
