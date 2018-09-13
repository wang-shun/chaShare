package com.holley.common.constants.charge;

/**
 * 是否值 <br>
 */
public enum SuggestionStatusEnum {
                                  UNPROCESSED(1, "未处理"), PROCESSED(2, "已处理");

    private final int    value;
    private final String text;

    SuggestionStatusEnum(int value, String text) {
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
        SuggestionStatusEnum task = getEnmuByValue(value);
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
    public static SuggestionStatusEnum getEnmuByValue(int value) {
        for (SuggestionStatusEnum record : SuggestionStatusEnum.values()) {
            if (value == record.getValue()) {
                return record;
            }
        }
        return null;
    }
}
