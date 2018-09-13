package com.holley.common.constants;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Globals {

    public static final String         KEY_SESSION_USER          = "userKey_";
    public static final String         KEY_SESSION_MSG           = "userKeyMsg_";
    public static Map<String, String>  SESSION_USERID_MAP        = new HashMap<String, String>();
    public static final String         COOKIE_SESSION_USERID     = "sessionUserid";

    public static final String         COOKIE_USERID             = "webUserid";
    public static final String         COOKIE_BMS_USERID         = "bmsUserid";                                               // 后台系统登录帐号保存在session的key值
    public static final String         COOKIE_DESKEY             = "holleychargingsystem";
    public static int                  LOGIN_FAIL_TOTAL          = 5;                                                         // 总共登录失败次数
    public static int                  VALID_FAIL_TOTAL          = 5;                                                         // 金额验证次数
    public static Map<String, Object>  LOGIN_COUNT_MAP           = new HashMap<String, Object>();                             // 记录用户短时间内登录失败的次数
    public static Map<Integer, Object> VALID_COUNT_MAP           = new HashMap<Integer, Object>();                            // 记录用户金额验证次数
    public static int                  LOGIN_INTERVAL            = 30;                                                        // 短时间登录失败超多次后再次允许登录的时间间隔
    public static final String         WEB_USER                  = "webUser";                                                 // 当前用户部分信息
    public static final String         USER_MODULE               = "userModule";                                              // 功能权限
    public static final String         USER_MODULE_BUTTON        = "userModuleButton";                                        // 功能按钮权限
    public static final String         TOP_MENU                  = "topMenu";                                                 // 一级菜单
    public static final String         SUB_MENU                  = "subMenu";                                                 // 二级菜单
    public static final String         CURRENTUSER               = "currentUser";                                             // 当前用户信息全
    public static final String         PAGE                      = "page";
    public static final int            PAGE_LIMIT                = 20;                                                        // 分页条数
    public static final long           TIMEOUT                   = 300;                                                       // 300秒
    public static final String         IMG_URL                   = "imgUrl";                                                  // 图片存放地址前缀
    public static final String         IMG_DATA_FILE             = "data";                                                    // 数据存放源文件
    public static final String         DOC_PILE_TEMP_FILE        = "pileTempDoc";
    public static final String         DOC_PILE_FILE             = "pileDoc";
    public static final String         DEFAULT_HEAD_URL          = "data/userHead/default.jpg";                               // 默认图片路径
    public static final String         DEFAULT_PASSWORD          = "123456";                                                  // 添加子账户默认密码
    public static final String         KEY_PILE_TEMP_DOC         = "pileTempDoc_";                                            // 暂存充电桩资料前缀
    public static final String         TYPE_DOC                  = ".doc";
    public static final String         TYPE_PDF                  = ".pdf";
    public static final String         IMG_STORE_PATH            = "/Users/Variant/Pictures";                                 // 图片存储路径
    public static final String         CURRENTMODULE             = "currentModule";                                           // 当前选中模块
    public static int                  MAX_LEN_RECV              = 102400;
    public static Map                  EMAIL_RESULT_MAP          = Collections.synchronizedMap(new HashMap<String, Object>()); // 邮箱
    public static Map                  MESSAGE_RESULT_MAP        = Collections.synchronizedMap(new HashMap<String, Object>()); // 站内信
    public static Map                  SMS_RESULT_MAP            = Collections.synchronizedMap(new HashMap<String, Object>()); // 短信
    public static final String         DEFAULT_MESSAGE           = "success";                                                 // 默认提示信息

    // -----------操作类型----------
    public static final int            REQUEST_TYPE_ADD          = 1;                                                         // 新增
    public static final int            REQUEST_TYPE_EDIT         = 2;                                                         // 修改
    public static final int            ADMIN_USER_ID             = 1;                                                         // 平台管理员用户ID
    public static final int            ADMIN_ROLE_ID             = 1;                                                         // 系统最高管理员
    public static final int            PLATFORM_SYSTEM_ID        = 1;                                                         // 平台系统
    public static final int            ENTERPRISE_SYSTEM_ID      = 2;                                                         // 运营商系统
    public static final int            PERSON_SYSTEM_ID          = 3;                                                         // 个人系统

    public static final String         ROWSPLIT                  = "@";                                                       // 分隔符
    public static final String         COLUMNSPLIT               = "#";                                                       // 分隔符

    public static final int            CHARGE_RULE_SINGLE        = 1;                                                         // 单一价格编码
    // ----超时时间(秒)
    public static final int            TIMEOUT_30                = 30;
    public static final int            TIMEOUT_20                = 20;
    public static final int            TIMEOUT_15                = 15;
    // ----超时时间(分)
    public static final int            TIMEOUT_MIN_5             = 5;                                                         // 5分钟

    public static final int            STATION_SHOW_LIMIT        = 100;                                                       // 手机app搜索充电点显示总条数

    public static final String         EXPORT_TYPE               = "exportType";
    public static final String         EXPORT_TEXT               = "text";                                                    // 导出全部为文本
    public static final String         EXPORT_DEFAULT            = "default";                                                 // 默认导出
    public static boolean              ISVALIDATEEXCELCOLOR      = false;                                                     // 是否启用导出excel当字段为空时显示红色
    public static String               COMMONREPORTBASEDIR       = "data/tempfile";                                           // 通用报表根目录
    public static String               TEMP_EXCEL_PATH           = "D://temp";                                                // excel临时文件夹

    public static double               RECHARGE_UPPERLIMIT       = 100000.00;                                                 // 充值上限
    public static double               CHARGE_USABLEMONEY_LIMIT  = 50.00;                                                     // 未实名用户可用金额限制，不能少于50元
    public static final int            DEFAULT_MAX_GROUP_SUBUSER = 10;                                                        // 默认最大集团子账户添加数量
    public static final int            MAX_CHAEGECARD_LIMIT      = 3;                                                         // 用户充电卡数量上限
    public static int                  MAX_EXPORT                = 3000;

    public static final Integer        TOKEN_AVAILABLE_TIME      = 60 * 60 * 24 * 7;                                          // token有效时间7天
    public static int                  COUNT_TIME                = 0;                                                         // 1秒内计数
    public static long                 TIME_STTEMP               = 0;                                                         // 时间戳缓存
    public static ThreadLocal<String>  threadLocal               = new ThreadLocal<String>();
    public static final String         KEY_TOKEN                 = "keyToken_";                                               // 本站token

    public static final String         KEY_PUSH_TOKEN            = "keyPushToken_";                                           // 推送token
}
