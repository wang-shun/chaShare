package com.holley.common.constants.charge;

/**
 * 认证状态 <br>
 */
public enum CertificateStatusEnum {
                                   FAILED(1, "未通过"), PASSED(2, "通过");

    private final int    value;
    private final String text;

    CertificateStatusEnum(int value, String text) {
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
        CertificateStatusEnum task = getEnmuByValue(value);
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
    public static CertificateStatusEnum getEnmuByValue(int value) {
        for (CertificateStatusEnum record : CertificateStatusEnum.values()) {
            if (value == record.getValue()) {
                return record;
            }
        }
        return null;
    }
}
