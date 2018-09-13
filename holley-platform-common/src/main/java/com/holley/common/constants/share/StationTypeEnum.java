package com.holley.common.constants.share;

/**
 * 站点类型
 */
public enum StationTypeEnum {
    PUBLIC(1, "公共"), PERSON(50, "个人"), BUS_STATION(100, "公交"), SANITATION(101, "环卫"), LOGISTICS(102, "物流"), TAXI(103, "出租车"), OTHER(255, "其他");

    private final int    value;
    private final String text;

    StationTypeEnum(int value, String text) {
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
        StationTypeEnum task = getEnmuByValue(value);
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
    public static StationTypeEnum getEnmuByValue(int value) {
        for (StationTypeEnum record : StationTypeEnum.values()) {
            if (value == record.getValue()) {
                return record;
            }
        }
        return null;
    }
}
