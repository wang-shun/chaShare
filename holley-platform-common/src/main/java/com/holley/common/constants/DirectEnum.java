package com.holley.common.constants;

import org.apache.commons.lang.StringUtils;

/**
 * UP = 1 //向上 <br>
 * DOWN = 2 //向下<br>
 * FORWARD = 3 //往前<br>
 * BACKWARD = 4 //后退<br>
 * LEFT = 5 //往前<br>
 * RIGHT = 6 //后退<br>
 * 
 * @author road
 */
public enum DirectEnum {
    UP("1"), DOWN("2"), FORWARD("3"), BACKWARD("4"), LEFT("5"), RIGHT("6");

    private final String value;

    DirectEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public int getIntValue() {
        return Integer.parseInt(value);
    }

    public short getShortValue() {
        return Short.parseShort(value);
    }

    /**
     * 通过传入的字符串匹配枚举，传入值
     * 
     * @param value
     * @return
     */
    public static DirectEnum getEnmuByValue(String value) {
        for (DirectEnum treeType : DirectEnum.values()) {
            if (StringUtils.equals(value, treeType.getValue())) {
                return treeType;
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
    public static DirectEnum getEnmuByName(String name) {
        if (StringUtils.isEmpty(name)) {
            return null;
        }
        for (DirectEnum treeType : DirectEnum.values()) {
            if (StringUtils.equals(name, treeType.toString())) {
                return treeType;
            }
        }
        return null;
    }
}
