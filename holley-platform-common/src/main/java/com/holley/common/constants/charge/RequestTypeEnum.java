package com.holley.common.constants.charge;

/**
 * 请求类型 <br>
 */
public enum RequestTypeEnum {
    ADDSTATIONPILE(1, "新增点和桩"), ADDPILE(2, "新增单个桩"), EDITSTATION(3, "修改单个点"), EDITPILE(4, "修改单个桩");

    private final int    value;
    private final String text;

    RequestTypeEnum(int value, String text) {
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
        RequestTypeEnum task = getEnmuByValue(value);
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
    public static RequestTypeEnum getEnmuByValue(int value) {
        for (RequestTypeEnum record : RequestTypeEnum.values()) {
            if (value == record.getValue()) {
                return record;
            }
        }
        return null;
    }
}
