package com.holley.common.constants.share;

/**
 * 设备类型
 */
public enum EquipmentTypeEnum {
    DC(1, "直流设备"), AC(2, "交流设备"), AC_DC(3, "交直流一体设备"), WIRELESS(4, "无线设备"), OTHER(5, "其他");

    private final int    value;
    private final String text;

    EquipmentTypeEnum(int value, String text) {
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
        EquipmentTypeEnum task = getEnmuByValue(value);
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
    public static EquipmentTypeEnum getEnmuByValue(int value) {
        for (EquipmentTypeEnum record : EquipmentTypeEnum.values()) {
            if (value == record.getValue()) {
                return record;
            }
        }
        return null;
    }
}
