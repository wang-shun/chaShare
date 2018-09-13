package com.holley.common.constants.charge;

/**
 * 信息模版状态 <br>
 */
public enum NoticeTemplateStatusEnum {
                                      ENABLED(1, "启用"), DISABLED(2, "停用");

    private final int    value;
    private final String text;

    NoticeTemplateStatusEnum(int value, String text) {
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
        NoticeTemplateStatusEnum task = getEnmuByValue(value);
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
    public static NoticeTemplateStatusEnum getEnmuByValue(int value) {
        for (NoticeTemplateStatusEnum record : NoticeTemplateStatusEnum.values()) {
            if (value == record.getValue()) {
                return record;
            }
        }
        return null;
    }
}
