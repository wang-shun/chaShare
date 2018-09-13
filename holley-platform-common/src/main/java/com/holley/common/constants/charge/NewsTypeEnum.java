package com.holley.common.constants.charge;

/**
 * 新闻动态类型 <br>
 */
public enum NewsTypeEnum {
                          TRENDS(1, "充电动态"), NEWS(2, "新闻资讯");

    private final int    value;
    private final String text;

    NewsTypeEnum(int value, String text) {
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
        NewsTypeEnum task = getEnmuByValue(value);
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
    public static NewsTypeEnum getEnmuByValue(int value) {
        for (NewsTypeEnum record : NewsTypeEnum.values()) {
            if (value == record.getValue()) {
                return record;
            }
        }
        return null;
    }
}
