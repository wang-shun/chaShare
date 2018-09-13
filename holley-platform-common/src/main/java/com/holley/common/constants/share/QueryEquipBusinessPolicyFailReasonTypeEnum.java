package com.holley.common.constants.share;

/**
 * Description: 请求设备业务策略信息结果
 *
 * @author shen.cheng@holley.cn
 */
public enum QueryEquipBusinessPolicyFailReasonTypeEnum {
    NIL(0, "无"), UNKNOWN_POLICY(1, "此充电设备业务策略不存在");

    private final int    value;
    private final String text;

    QueryEquipBusinessPolicyFailReasonTypeEnum(int value, String text) {
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
        QueryEquipBusinessPolicyFailReasonTypeEnum task = getEnmuByValue(value);
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
    public static QueryEquipBusinessPolicyFailReasonTypeEnum getEnmuByValue(int value) {
        for (QueryEquipBusinessPolicyFailReasonTypeEnum record : QueryEquipBusinessPolicyFailReasonTypeEnum.values()) {
            if (value == record.getValue()) {
                return record;
            }
        }
        return null;
    }
}
