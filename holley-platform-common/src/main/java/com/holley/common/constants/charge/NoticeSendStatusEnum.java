package com.holley.common.constants.charge;

/**
 * 信息发送状态 <br>
 */
public enum NoticeSendStatusEnum {
                                  UNSENT(1, "未发送"), SUCCESS(2, "成功"), FAILURE(3, "失败");

    private final int    value;
    private final String text;

    NoticeSendStatusEnum(int value, String text) {
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
        NoticeSendStatusEnum task = getEnmuByValue(value);
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
    public static NoticeSendStatusEnum getEnmuByValue(int value) {
        for (NoticeSendStatusEnum record : NoticeSendStatusEnum.values()) {
            if (value == record.getValue()) {
                return record;
            }
        }
        return null;
    }
}
