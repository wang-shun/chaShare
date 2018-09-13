package com.holley.common.constants.charge;

/**
 * 停车场类型 <br>
 */
public enum ParkTypeEnum {
                          OUTDOOR(1, "露天"), INDOOR(2, "室内");

    private final int    value;
    private final String text;

    ParkTypeEnum(int value, String text) {
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
        ParkTypeEnum task = getEnmuByValue(value);
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
    public static ParkTypeEnum getEnmuByValue(int value) {
        for (ParkTypeEnum record : ParkTypeEnum.values()) {
            if (value == record.getValue()) {
                return record;
            }
        }
        return null;
    }
}
