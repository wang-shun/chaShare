package com.holley.common.constants.charge;

/**
 * 新闻动态状态 <br>
 */
public enum NewsStatusEnum {
                            OPEN(1, "开放"), CLOSED(2, "关闭");

    private final int    value;
    private final String text;

    NewsStatusEnum(int value, String text) {
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
        NewsStatusEnum task = getEnmuByValue(value);
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
    public static NewsStatusEnum getEnmuByValue(int value) {
        for (NewsStatusEnum record : NewsStatusEnum.values()) {
            if (value == record.getValue()) {
                return record;
            }
        }
        return null;
    }
}
