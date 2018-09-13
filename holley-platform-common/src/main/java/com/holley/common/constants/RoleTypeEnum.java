package com.holley.common.constants;

/**
 * 角色类型 <br>
 */
public enum RoleTypeEnum {
    PLATFORM(1, "系统平台"), ENTERPRISE(2, "企业运营"), PERSON(3, "个人运营"), ENTERPRISE_SUB(4, "企业子账号"), GROUP(5, "集团管理员"), GROUP_SUB(6, "集团子账号"), COMPANY(9, "子公司管理员账号"),
    COMPANY_SUB(10, "子公司操作员账号");

    private final int    value;
    private final String text;

    RoleTypeEnum(int value, String text) {
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
        RoleTypeEnum task = getEnmuByValue(value);
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
    public static RoleTypeEnum getEnmuByValue(int value) {
        for (RoleTypeEnum record : RoleTypeEnum.values()) {
            if (value == record.getValue()) {
                return record;
            }
        }
        return null;
    }
}
