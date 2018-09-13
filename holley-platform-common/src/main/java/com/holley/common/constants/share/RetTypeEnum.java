package com.holley.common.constants.share;

/**
 * share接口返回结果类型 <br>
 */
public enum RetTypeEnum {
                         SYS_BUSY(-1, "系统繁忙"), SUCCESS(0, "请求成功"),SIG_ERROR(4001,"签名错误"),TOKEN_ERROR(4002,"Token错误"),KEY_PARAM_ERROR(4003,"必要参数非法"),PARAM_ERROR(4004,"请求参数非法"),SYS_ERROR(500,"系统错误");

    private final int    value;
    private final String text;

    RetTypeEnum(int value, String text) {
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
        RetTypeEnum task = getEnmuByValue(value);
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
    public static RetTypeEnum getEnmuByValue(int value) {
        for (RetTypeEnum record : RetTypeEnum.values()) {
            if (value == record.getValue()) {
                return record;
            }
        }
        return null;
    }
}
