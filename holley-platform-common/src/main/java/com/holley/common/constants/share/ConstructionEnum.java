package com.holley.common.constants.share;

/**
 * 站点建设场所
 */
public enum ConstructionEnum {
    RESIDENTIAL_AREA(1, "居民区"), PUBLIC(2, "公共机构"), INSTITUTION(3, "事业单位"), OFFICE(4, "写字楼"), INDUSTRIAL_PARK(5, "工业园区"), TRAFFIC_HUB(6, "交通枢纽"), SPORTS(7, "大型文体设施"),
    GREEN_AREA(8, "城市绿地"), PARKING_LOGS(9, "大型建筑配建停车场"), PARKING_SPACE(10, "路边停车位"), SERVICE_AREA(11, "城际高速服务区"), OTHER(255, "其他");

    private final int    value;
    private final String text;

    ConstructionEnum(int value, String text) {
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
        ConstructionEnum task = getEnmuByValue(value);
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
    public static ConstructionEnum getEnmuByValue(int value) {
        for (ConstructionEnum record : ConstructionEnum.values()) {
            if (value == record.getValue()) {
                return record;
            }
        }
        return null;
    }
}
