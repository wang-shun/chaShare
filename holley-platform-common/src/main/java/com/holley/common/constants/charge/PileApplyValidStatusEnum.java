package com.holley.common.constants.charge;

import java.util.ArrayList;
import java.util.List;

/**
 * 是否值 <br>
 */
public enum PileApplyValidStatusEnum {
                                      UNPROCESSED(1, "未处理"), PROCESSED(2, "已处理");

    private final int    value;
    private final String text;

    PileApplyValidStatusEnum(int value, String text) {
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
        PileApplyValidStatusEnum task = getEnmuByValue(value);
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
    public static PileApplyValidStatusEnum getEnmuByValue(int value) {
        for (PileApplyValidStatusEnum record : PileApplyValidStatusEnum.values()) {
            if (value == record.getValue()) {
                return record;
            }
        }
        return null;
    }

    public static List<PileApplyValidStatusEnum> getVerifyResultList() {
        List<PileApplyValidStatusEnum> list = new ArrayList<PileApplyValidStatusEnum>();
        list.add(PileApplyValidStatusEnum.PROCESSED);
        return list;
    }
}
