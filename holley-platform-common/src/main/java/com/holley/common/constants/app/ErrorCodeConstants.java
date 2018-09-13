package com.holley.common.constants.app;

public class ErrorCodeConstants {

    // 全局设置
    public static int ERR_G_NEEDLOG                = 10000; // 10000: 代表需重新登录，此时需要登录后访问的页面跳转至登录页面重新生成新的userkey。
    public static int ERR_G_USRLOCK                = 10001; // 10001: 用户账户已锁定，不能登录。
    public static int ERR_G_NOUSR                  = 10002; // 10002: 无此用户，不能登录系统。
    public static int ERR_G_PARAERR                = 10004; // 10004: 用户输入参数非法

    public static int ERR_G_SYSERR                 = 10003; // 10003: 系统调用异常，请稍后重试
    public static int ERR_G_KEYTIMEOUT             = 10005; // 10005: 秘钥已过期,需重新申请

    // 用户相关
    // 注册
    public static int ERR_REG_HAVEUSER             = 1;     // 1:该账户已经注册
    public static int ERR_REG_VALIDATEWORING       = 2;     // 2:短信验证码错误，需重新申请
    public static int ERR_REG_USERPWNULL           = 3;     // 3:用户名或者密码空
    public static int ERR_REG_PWRULENO             = 4;     // 4:密码规则不符合规定

    // 登录
    public static int ERR_LOG_USERPWWORING         = 1;     // 1:用户名或密码错误
    public static int ERR_LOG_VALIDATEWORING       = 2;     // 2:验证码错误

    // 找回密码
    public static int ERR_FINDPW_VALIDATEWORING    = 1;     // 1:短信验证错误
    public static int ERR_FINDPW_PWWORING          = 2;     // 2:密码验证错误
    public static int ERR_FINDPW_USERPWNULL        = 3;     // 3:用户名或者密码空

    // 业务操作
    // 公共异常
    public static int ERR_G_PILEOFFLINE            = 20000; // 20000: 充电桩离线/故障
    public static int ERR_PILESTATUS_OTHERUSING    = 20001; // 20001: 其他用户正在充电
    public static int ERR_PILESTATUS_NOPILE        = 20002; // 20002: 无此充电桩
    public static int ERR_PILESTATUS_BUSYING       = 20003; // 20003: 充电桩忙碌中(桩屏幕正在被操作等原因)
    public static int ERR_UNPAIDFEE_APPO           = 20004; // 20004: 用户有未缴清的预约费用
    public static int ERR_UNPAIDFEE_CHARGE         = 20005; // 20005: 用户有未缴清的充电费用
    public static int ERR_QRY_NORECORD             = 20006; // 20006: 充电或预约记录不存在

    public static int ERR_PILESTATUS_USING         = 20007; // 20007: 自己正在充电
    public static int ERR_PILESTATUS_OTHERUSERAPPO = 20008; // 20008: 已经被其他用户预约
    public static int ERR_USER_HAVEAPPO_OTHERPILE  = 20009; // 20009: 已经预约其他充电桩，需先取消
    public static int ERR_SCAN_OTHERSCAN           = 20010; // 20010: 其他用户已经扫码待充电

    public static int ERR_MONEY_UPPERLIMIT_EXCESS  = 21000; // 21000:金额超出

    // 申请预约
    public static int ERR_MAKEAPPO_HAVEAPPO        = 1;     // 1: 当前用户已经预约
    public static int ERR_MAKEAPPO_OTHERUSERAPPO   = 2;     // 2: 已经被其他用户预约
    public static int ERR_MAKEAPPO_USING           = 3;     // 3: 充电桩正在使用中
    public static int ERR_MAKEAPPO_OTHERPILEAPPO   = 4;     // 4: 用户已经预约其他桩
    public static int ERR_MAKEAPPO_PILEERR         = 5;     // 5: 充电桩预约失败
    // 续约
    public static int ERR_MAKEAPPO_UNAPP           = 6;     // 6: 用户未预约
    public static int ERR_MAKEAPPO_OVERDUE         = 7;     // 7: 预约已经过期
    public static int ERR_MAKEAPPO_UNORDERABLE     = 8;     // 8: 此桩不可预约

    // 预约终止
    public static int ERR_ENDAPPO_OTHERNO          = 1;     // 1: 不能终止其他用户预约记录
    public static int ERR_ENDAPPO_NOAPPO           = 2;     // 2: 当前用户未预约
    public static int ERR_ENDAPPO_OVERDUE          = 3;     // 3: 预约已经过期
    public static int ERR_ENDAPPO_PILEERR          = 4;     // 4: 取消预约失败

    // 扫二维码申请

    // 开始充电
    public static int ERR_STCHA_NOGUN              = 2;     // 2: 未插充电枪
    public static int ERR_STCHA_TIMEOUT            = 4;     // 4: 规定时间未操作，扫码失效，请重新扫码
    public static int ERR_STCHA_NOREAL             = 5;     // 5: 未实名且钱包余额少于100元
    public static int ERR_STCHA_PILEERR            = 6;     // 6: 充电失败

    // 停止充电
    public static int ERR_ENDCHA_NOTSTARTPILE      = 1;     // 1: 充电桩未启动
    public static int ERR_ENDCHA_GETFEEORDER       = 2;     // 2: 获取缴费订单失败
    public static int ERR_ENDCHA_PILEERR           = 3;     // 3: 停止充电失败

    // 账户缴费
    public static int ERR_PAY_NOMONEY              = 1;     // 1:账户可用金额不足
    public static int ERR_PAY_FEENULL              = 2;     // 2:缴费金额为空或不大于0
    public static int ERR_PAY_PAID                 = 3;     // 3:记录已支付过
    public static int ERR_PAY_BLOCKED              = 4;     // 4:钱包已被冻结

    // 第三方缴费结果
    public static int ERR_PAYRESU_SYSTEMERR        = 1;     // 1： 系统调用失败
    public static int ERR_PAYRESU_NOWAY            = 2;     // 2： 不支持该支付方式
    public static int ERR_PAYRESU_NORECORD         = 3;     // 3： 缴费记录不存在
    public static int ERR_PAYRESU_FEENULL          = 4;     // 4： 缴费金额为空或不大于0
    public static int ERR_PAYRESU_PAID             = 5;     // 5:记录已支付过

    // 其他
    // 短信验证码
    public static int ERR_MSGVAL_HAVEUSER          = 1;     // 1.该账户已经注册。
    public static int ERR_MSGVAL_MOBILEERR         = 2;     // 2.手机号码为空或不符合要求。
    public static int ERR_MSGVAL_REPEAT            = 3;     // 3.不能再规定时间内重复发送短信。

    // 个人桩代管
    public static int ERR_PILE_APPLY_PHONEERR      = 1;     // 1:联系方式格式不正确

    // --------------修改用户资料
    // 修改头像
    public static int ERR_IMG_EMPTYERR             = 1;     // 1：上传图片为空
    public static int ERR_IMG_UPLOADERR            = 2;     // 2:上传图片失败
    // 实名认证
    public static int ERR_REAL_VERIFYING           = 3;     // 3：实名认证审核中
    public static int ERR_REAL_PASSED              = 4;     // 4：已审核通过
    // 修改用户昵称
    public static int ERR_USERNAME_REPEAT          = 1;     // 1:昵称已经存在

    // 提现申请
    public static int ERR_CASH_BLOCKED             = 1;     // 1:账户已被冻结
    public static int ERR_CASH_LACK                = 2;     // 2:可用余额不足
    public static int ERR_CASH_NOWAY               = 3;     // 3:提现方式不支持
    public static int ERR_CASH_VALIDATEWORING      = 4;     // 4:短信验证错误

}
