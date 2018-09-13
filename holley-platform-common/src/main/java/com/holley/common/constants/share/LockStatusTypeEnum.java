package com.holley.common.constants.share;

/**
 * 地锁状态
 */
public enum LockStatusTypeEnum {
    UNKNOWN(0, "未知"), OPEN(1, "解锁"), CLOSE(2, "上锁");

    private final int    value;
    private final String text;

    LockStatusTypeEnum(int value, String text) {
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
        LockStatusTypeEnum task = getEnmuByValue(value);
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
    public static LockStatusTypeEnum getEnmuByValue(int value) {
        for (LockStatusTypeEnum record : LockStatusTypeEnum.values()) {
            if (value == record.getValue()) {
                return record;
            }
        }
        return null;
    }
}
