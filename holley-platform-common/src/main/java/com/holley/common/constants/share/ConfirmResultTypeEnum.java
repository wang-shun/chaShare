package com.holley.common.constants.share;

/**
 * 命令类型（前置通讯）
 */
public enum ConfirmResultTypeEnum {
    SUCCESS(0, "成功"), ARGUE(1, "争议交易");

    private final int    value;
    private final String text;

    ConfirmResultTypeEnum(int value, String text) {
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
        ConfirmResultTypeEnum task = getEnmuByValue(value);
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
    public static ConfirmResultTypeEnum getEnmuByValue(int value) {
        for (ConfirmResultTypeEnum record : ConfirmResultTypeEnum.values()) {
            if (value == record.getValue()) {
                return record;
            }
        }
        return null;
    }
}
