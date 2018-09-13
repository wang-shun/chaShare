package com.holley.common.constants.share;

/**
 * 获取token结果状态
 */
public enum SuccStatTypeEnum {
    SUCCESS(0, "成功"), FAIL(1, "失败");

    private final int    value;
    private final String text;

    SuccStatTypeEnum(int value, String text) {
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
        SuccStatTypeEnum task = getEnmuByValue(value);
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
    public static SuccStatTypeEnum getEnmuByValue(int value) {
        for (SuccStatTypeEnum record : SuccStatTypeEnum.values()) {
            if (value == record.getValue()) {
                return record;
            }
        }
        return null;
    }
}
