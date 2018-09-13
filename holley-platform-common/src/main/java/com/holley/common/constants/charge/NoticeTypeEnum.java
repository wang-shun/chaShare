package com.holley.common.constants.charge;

import java.util.ArrayList;
import java.util.List;

/**
 * 信息类型 <br>
 */
public enum NoticeTypeEnum {
                            MESSAGE(1, "站内信"), MAIL(2, "邮件"), SMS(3, "短信");

    private final int    value;
    private final String text;

    NoticeTypeEnum(int value, String text) {
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
        NoticeTypeEnum task = getEnmuByValue(value);
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
    public static NoticeTypeEnum getEnmuByValue(int value) {
        for (NoticeTypeEnum record : NoticeTypeEnum.values()) {
            if (value == record.getValue()) {
                return record;
            }
        }
        return null;
    }

    public static List<NoticeTypeEnum> getMessageAndSms() {
        List<NoticeTypeEnum> list = new ArrayList<NoticeTypeEnum>();
        list.add(NoticeTypeEnum.MESSAGE);
        list.add(NoticeTypeEnum.SMS);
        return list;
    }
}
