package com.holley.common.cache.charging;

/**
 * 缓存主键定义规则
 * 
 * @author zhouli
 */
public class CacheKeyProvide {

    public static String KEY_WEB_SESSION                 = "keyWebSession_";             // 网站
    public static String KEY_APP_SESSION                 = "keyAppSession_";             // 手机
    public static String KEY_BMS_SESSION                 = "keyBmsSession_";             // 后台系统
    public static String KEY_IMG_VALIDATE                = "keyImgValidate_";
    public static String KEY_MESSAGE_REGISTER_VALIDATE   = "keyMesRegValidate_";
    public static String KEY_MESSAGE_RESETPWD_VALIDATE   = "keyMesResetPwdValidate_";
    public static String KEY_MESSAGE_CASH_VALIDATE       = "keyMesCashPwdValidate_";
    public static String KEY_APP_LOGIN_BEAN              = "keyAppLoginBean_";
    public static String KEY_WEB_LOGIN_BEAN              = "keyWebLoginBean_";
    public static String KEY_BMS_LOGIN_BEAN              = "keyBmsLoginBean_";
    public static String KEY_RULE                        = "keyRule_";                   // 缓存规则
    public static String KEY_PHONE_CODE                  = "keyPhoneCode_";
    public static String KEY_CHANGE_PHONE                = "keyChangePhone_";            // 修改手机操作
    public static String KEY_CHANGE_PHONE_NUM            = "keyChangePhoneNum_";         // 修改的手机号码
    public static String KEY_CHANGE_PHONE_CODE           = "keyChangePhoneCode_";        // 修改手机的手机验证码
    public static String KEY_EMAIL                       = "keyEmail_";
    public static String KEY_EMAIL_CODE                  = "keyEmailCode_";
    public static String KEY_CHANGE_PWD                  = "keyChangePwd_";
    public static String KEY_CHANGE_EMAIL                = "keyChangeEmail_";
    public static String KEY_CHANGE_PAYPWD               = "keyChangePayPwd_";
    public static String KEY_SECURITYKEY_SESSION         = "keySecurityKey_";
    public static String KEY_PILESTATUS_BEAN             = "keyPileStatusBean_";         // 充电桩状态
    public static String KEY_ONLINE_INFO_ID              = "keyOnlineInfoId_";           // 实时监控企业ID
    public static String KEY_USER_MODULE                 = "keyUserModule_";             // 功能权限
    public static String KEY_USER_MODULE_BUTTON          = "keyUserModuleButton_";       // 功能按钮权限
    public static String KEY_USER                        = "keyUser_";                   // 用户信息缓存

    public static String KEY_PILEMONITOR_CRAC            = "keyPileMonitorCRAC_";        // 创睿交流充电桩设备监视
    public static String KEY_PILEMONITOR_CRDC            = "keyPileMonitorCRDC_";        // 创睿直流充电桩设备监视

    public static String KEY_CHARGE_NO                   = "keyChargeNo_";               // 充电桩交易序列号
    public static String KEY_RECHARGE_NO                 = "keyRechargeNo_";             // 账户充值交易序列号

    public static String KEY_STATION_UPDATETIME          = "keyStationUpdateTime";       // 充电点更新时间
    public static String KEY_PILE_UPDATETIME             = "keyPileUpdateTime";          // 充电桩更新时间
    public static String KEY_SECTET_KEY_UPDATETIME       = "keySectetKeyUpdatetime";      // 密钥更新时间
    public static String KEY_PILE_DELETE                 = "keyPileDelete_";             // 删除充电桩
    public static String KEY_PILE_CHARGE_RULE_UPDATETIME = "keyPileChargeRuleUpdateTime"; // 充电桩费率更新时间
    public static String KEY_REPAIRPOINT_UPDATETIME      = "keyRepairPointUpdateTime";   // 服务点更新时间
    public static String KEY_PILEMODEL_UPDATETIME        = "keyPileModelUpdateTime";     // 电桩型号更新时间

    public static String KEY_APP_LINK_UPDATE             = "keyAppLinkUpdate";           // 数据字典缓存更新，供app使用
    public static String KEY_WEB_LINK_UPDATE             = "keyWebLinkUpdate";           // 数据字典缓存更新，供web使用

    public static String getKey(String suffex, String key) {
        return suffex + key;
    }

    /**
     * 短信注册类型
     * 
     * @author zhouli
     */
    public enum KeyMsgCodeTypeEnum {
        REGISTER(1, "注册"), RESETPWD(2, "重置密码"), CASH(3, "提现验证");

        private final int    value;
        private final String text;

        KeyMsgCodeTypeEnum(int value, String text) {
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
            KeyMsgCodeTypeEnum task = getEnmuByValue(value);
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
        public static KeyMsgCodeTypeEnum getEnmuByValue(int value) {
            for (KeyMsgCodeTypeEnum record : KeyMsgCodeTypeEnum.values()) {
                if (value == record.getValue()) {
                    return record;
                }
            }
            return null;
        }
    }

    /**
     * 短信注册类型
     * 
     * @author zhouli
     */
    public enum KeySessionTypeEnum {
        APP(1, "手机APP"), WEB(2, "网站"), BMS(3, "后台系统");

        private final int    value;
        private final String text;

        KeySessionTypeEnum(int value, String text) {
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
            KeySessionTypeEnum task = getEnmuByValue(value);
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
        public static KeySessionTypeEnum getEnmuByValue(int value) {
            for (KeySessionTypeEnum record : KeySessionTypeEnum.values()) {
                if (value == record.getValue()) {
                    return record;
                }
            }
            return null;
        }
    }

    // public static String getChangePayPwdKey(String id) {
    // return KEY_CHANGE_PAYPWD + id;
    // }
    //
    // public static String getChangeEmailKey(String id) {
    // return KEY_CHANGE_EMAIL + id;
    // }
    //
    // public static String getChangePwdKey(String id) {
    // return KEY_CHANGE_PWD + id;
    // }
    //
    // public static String getEmailKey(String id) {
    // return KEY_EMAIL + id;
    // }
    //
    // public static String getPhoneCodeKey(String id) {
    // return KEY_PHONE_CODE + id;
    // }
    //
    // public static String getEmailCodeKey(String id) {
    // return KEY_EMAIL_CODE + id;
    // }
    //
    // public static String getAppSessionKey(String id) {
    // return KEY_APP_SESSION + id;
    // }
    //
    // public static String getSessionKey(String id) {
    // return KEY_SESSION + id;
    // }
    //
    // public static String getImgValiKey(String id) {
    // return KEY_IMG_VALIDATE + id;
    // }
    //
    // public static String getMessageValiKey(String id, MessageCodeTypeEnum type) {
    // if (type == MessageCodeTypeEnum.REGISTER) {
    // return KEY_MESSAGE_REGISTER_VALIDATE + id;
    // } else if (type == MessageCodeTypeEnum.RESETPWD) {
    // return KEY_MESSAGE_RESETPWD_VALIDATE + id;
    // }
    // return null;
    // }
    //
    // public static String getLogBeanKey(String id) {
    // return KEY_LOGIN_BEAN + id;
    // }
    //
    // public static String getRuleKey(String id) {
    // return KEY_RULE + id;
    // }

}
