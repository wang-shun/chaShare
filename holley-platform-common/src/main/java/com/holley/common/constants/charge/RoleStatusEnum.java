package com.holley.common.constants.charge;

/**
 * 角色状态 <br>
 */
public enum RoleStatusEnum {
                            ACTIVATE(1, "激活"), DEACTIVATE(2, "禁用");

    private final int    value;
    private final String text;

    RoleStatusEnum(int value, String text) {
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
        RoleStatusEnum task = getEnmuByValue(value);
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
    public static RoleStatusEnum getEnmuByValue(int value) {
        for (RoleStatusEnum record : RoleStatusEnum.values()) {
            if (value == record.getValue()) {
                return record;
            }
        }
        return null;
    }
}
