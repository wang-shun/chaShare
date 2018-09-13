package com.holley.common.constants;

import org.apache.commons.lang3.StringUtils;

public enum TaskStatusEnum {
    INIT(0, "初始化"), LOADING(1, "载入中"), WAITING(2, "等待中"), RUNNING(3, "运行"), FINISH(4, "完成"), FAIL(5, "失败");

    private final int    value;
    private final String text;

    TaskStatusEnum(int value, String text) {
        this.value = value;
        this.text = text;
    }

    public int getValue() {
        return value;
    }

    public short getShortValue() {
        return (short) value;
    }

    public String getText() {
        return text;
    }

    public static String getText(int value) {
        TaskStatusEnum task = getEnmuByValue(value);
        return task == null ? null : task.getText();
    }

    /**
     * 通过传入的字符串匹配枚举，传入值
     * 
     * @param value
     * @return
     */
    public static TaskStatusEnum getEnmuByValue(int value) {
        for (TaskStatusEnum ts : TaskStatusEnum.values()) {
            if (value == ts.getValue()) {
                return ts;
            }
        }
        return null;
    }

    /**
     * 通过传入的字符串匹配枚举,传入名字
     * 
     * @param name
     * @return
     */
    public static TaskStatusEnum getEnmuByName(String name) {
        if (StringUtils.isEmpty(name)) {
            return null;
        }
        for (TaskStatusEnum ts : TaskStatusEnum.values()) {
            if (StringUtils.equals(name, ts.toString())) {
                return ts;
            }
        }
        return null;
    }

}
