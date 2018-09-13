package com.holley.common.constants.share;

/**
 * 站点类型
 */
public enum StationStatusEnum {
    UNKNOWN(0, "未知"), BUILDING(1, "建设中"), CLOSE(5, "关闭"), MAINTENANCE(6, "维护中"), SERVICE(50, "正常使用");

    private final int    value;
    private final String text;

    StationStatusEnum(int value, String text) {
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
        StationStatusEnum task = getEnmuByValue(value);
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
    public static StationStatusEnum getEnmuByValue(int value) {
        for (StationStatusEnum record : StationStatusEnum.values()) {
            if (value == record.getValue()) {
                return record;
            }
        }
        return null;
    }
}
