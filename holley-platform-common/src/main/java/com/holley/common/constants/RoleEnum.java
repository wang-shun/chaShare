package com.holley.common.constants;

/**
 * 系统自定义的角色<br>
 */
public enum RoleEnum {
    PLATFORM(1, "系统平台"), ENTERPRISE(2, "企业运营"), PERSON(3, "个人运营"), ENTERPRISE_SUB(4, "企业子账号"), GROUP(5, "集团管理员"), GROUP_SUB(6, "集团子账号"), COMPANY(9, "子公司");

    private final int    value;
    private final String text;

    RoleEnum(int value, String text) {
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
        RoleEnum task = getEnmuByValue(value);
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
    public static RoleEnum getEnmuByValue(int value) {
        for (RoleEnum record : RoleEnum.values()) {
            if (value == record.getValue()) {
                return record;
            }
        }
        return null;
    }
}
