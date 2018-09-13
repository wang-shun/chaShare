package com.holley.common.constants.charge;

/**
 * 是否值 <br>
 */
public enum WhetherEnum {
                         YES(1, "是"), NO(2, "否");

    private final int    value;
    private final String text;

    WhetherEnum(int value, String text) {
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
        WhetherEnum task = getEnmuByValue(value);
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
    public static WhetherEnum getEnmuByValue(int value) {
        for (WhetherEnum record : WhetherEnum.values()) {
            if (value == record.getValue()) {
                return record;
            }
        }
        return null;
    }
}
