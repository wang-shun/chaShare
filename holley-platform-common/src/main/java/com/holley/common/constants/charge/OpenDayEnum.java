package com.holley.common.constants.charge;

/**
 * 开放日 <br>
 */
public enum OpenDayEnum {
                         EVERYDAY(1, "每天"), WORKDAY(2, "工作日"), NONWORKDAYS(3, "非工作日");

    private final int    value;
    private final String text;

    OpenDayEnum(int value, String text) {
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
        OpenDayEnum task = getEnmuByValue(value);
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
    public static OpenDayEnum getEnmuByValue(int value) {
        for (OpenDayEnum record : OpenDayEnum.values()) {
            if (value == record.getValue()) {
                return record;
            }
        }
        return null;
    }
}
