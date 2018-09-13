package com.holley.common.constants;

import java.util.ArrayList;
import java.util.List;

import com.holley.common.dataobject.ComboxBean;

/**
 * 系统日志类型
 * 
 * @author zhouli <br>
 * 权限日志: 用户账号创建、删除、修改密码 <br>
 * 系统访问: 用户登录和退出<br>
 * 档案维护: 档案的修改日志<br>
 * 资源访问: 用户访问系统功能模块日志,在拦截器中实现<br>
 * 拒绝访问: 1 登录用户名密码错误 2 用户超时拒绝访问 <br>
 * 运行错误: 系统运行错误日志,可以拦截器统一处理<br>
 */
public enum LogTypeEnum {

    RUN_ACCTOUNT("权限日志", (short) 1), RUN_LOGIN("系统访问", (short) 2), RUN_RECORD("档案维护", (short) 3), RUN_QUEST("资源访问", (short) 4), ERROR_REFUSE("拒绝访问", (short) 5),
    ERROR_RUN("运行错误", (short) 6), APP_RUN_LOGIN("APP访问", (short) 7), APP_RUN_RECORD("APP档案维护", (short) 8), APP_ERROR_REFUSE("APP拒绝访问", (short) 9);

    private final Short  value;
    private final String name;

    LogTypeEnum(String name, Short value) {
        this.value = value;
        this.name = name;
    }

    public Short getValue() {
        return value;
    }

    public String getName() {
        return this.name;
    }

    /**
     * 通过传入的字符串匹配枚举，传入值
     * 
     * @param value
     * @return
     */
    public static LogTypeEnum getEnmuByValue(Short value) {
        for (LogTypeEnum type : LogTypeEnum.values()) {
            if (type.getValue().equals(value)) {
                return type;
            }
        }
        return null;
    }

    public static String getName(Short value) {
        LogTypeEnum type = getEnmuByValue(value);
        return type == null ? null : type.getName();
    }

    /**
     * 转换为list
     * 
     * @return
     */
    public static List<ComboxBean> toList() {
        List<ComboxBean> list = new ArrayList<ComboxBean>();
        for (LogTypeEnum type : LogTypeEnum.values()) {
            list.add(new ComboxBean(type.getName(), type.getValue().toString()));
        }
        return list;
    }

}
