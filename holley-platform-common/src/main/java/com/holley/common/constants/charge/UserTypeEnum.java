package com.holley.common.constants.charge;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户类型 <br>
 */
public enum UserTypeEnum {
    PLATFORM(1, "平台"), ENTERPRISE(2, "企业"), PERSON(3, "个人"), GROUP(5, "集团"), COMPANY(9, "子公司");

    private final int    value;
    private final String text;

    UserTypeEnum(int value, String text) {
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
        UserTypeEnum task = getEnmuByValue(value);
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
    public static UserTypeEnum getEnmuByValue(int value) {
        for (UserTypeEnum record : UserTypeEnum.values()) {
            if (value == record.getValue()) {
                return record;
            }
        }
        return null;
    }

    public static List<UserTypeEnum> getMecTypeList() {
        List<UserTypeEnum> list = new ArrayList<UserTypeEnum>();
        list.add(UserTypeEnum.ENTERPRISE);
        list.add(UserTypeEnum.PERSON);
        return list;
    }
}
