package com.holley.common.constants.charge;

/**
 * 显示状态 <br>
 */
public enum ShowStausEnum {
                            SHOW(1, "显示"), HIDE(2, "隐藏");

    private final int    value;
    private final String text;

    ShowStausEnum(int value, String text) {
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
        ShowStausEnum task = getEnmuByValue(value);
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
    public static ShowStausEnum getEnmuByValue(int value) {
        for (ShowStausEnum record : ShowStausEnum.values()) {
            if (value == record.getValue()) {
                return record;
            }
        }
        return null;
    }

}
