package com.holley.common.constants;

/**
 * 系统规则状态 <br>
 */
public enum RuleStatusEnum {
                            ENABLED(1, "启用"), DISABLED(2, "停用");

    private final int    value;
    private final String text;

    RuleStatusEnum(int value, String text) {
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
        RuleStatusEnum task = getEnmuByValue(value);
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
    public static RuleStatusEnum getEnmuByValue(int value) {
        for (RuleStatusEnum record : RuleStatusEnum.values()) {
            if (value == record.getValue()) {
                return record;
            }
        }
        return null;
    }
}
