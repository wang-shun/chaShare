package com.holley.platform.util;

import java.util.ArrayList;
import java.util.List;

import com.holley.common.cache.charging.CacheKeyProvide;
import com.holley.common.cache.charging.ChargingCacheUtil;
import com.holley.common.constants.Globals;
import com.holley.common.util.SerializeCoderUtil;
import com.holley.platform.model.sys.SysAccountroleKey;
import com.holley.platform.model.sys.SysButtondef;
import com.holley.platform.model.sys.SysModuledef;
import com.holley.platform.model.sys.SysModuledefExample;
import com.holley.platform.model.sys.SysRule;
import com.holley.platform.service.RoleService;

public class RoleUtil {

    public static String      RULE_SYS_SECURIRY_DOWN_KEY = "SYS_SECURIRY_DOWN_KEY";
    public static String      IMG_URL                    = "IMG_URL";
    public static String      DATA_PATH                  = "DATA_PATH";
    public static String      EMAIL_INFO                 = "EMAIL_INFO";
    public static String      APPOINTMENT_FEE            = "APPOINTMENT_FEE";
    public static String      APP_URL                    = "APP_URL";
    public static String      WEB_URL                    = "WEB_URL";
    public static String      MAX_CHARGECARD_LIMIT       = "MAX_CHARGECARD_LIMIT"; // 用户开卡数量上限
    public static String      RATE                       = "RATE";
    public static String      SMS_APP_KEY                = "SMS_APP_KEY";
    public static String      CARD_ACTIVE_TIME           = "CARD_ACTIVE_TIME";     // 充电卡有效时间
    public static String      SMS_APP_SECRET             = "SMS_APP_SECRET";
    public static String      SMS_SEND_URL               = "SMS_SEND_URL";         // 短信接口地址
    public static String      SMS_TEMPLATE               = "SMS_TEMPLATE";         // 短信模板
    public static String      SMS_SIGN_TITLE             = "SMS_SIGN_TITLE";       // 验证码签名名称
    public static String      APK_UPDATE_URL             = "APK_UPDATE_URL";       // 51充电安卓APP更新地址
    public static String      IOS_UPDATE_URL             = "IOS_UPDATE_URL";       // 51充电APPSTORE下载地址
    public static String      DEFAULT_PWD                = "DEFAULT_PWD";          // 添加子账户默认密码
    public static String      MAX_GROUP_SUBUSER          = "MAX_GROUP_SUBUSER";    // 最大集团子账户数
    public static RoleService roleService;

    public static int insertAccountRole(SysAccountroleKey record) {
        return roleService.insertAccountRole(record);
    }

    public static SysAccountroleKey selectAccountRoleByUserid(Integer userid) {
        return roleService.selectAccountRoleByUserid(userid);
    }

    public static List<SysModuledef> selectModuledefByUserid(Integer userid, Integer roleid) {
        List<SysModuledef> moduleList = new ArrayList<SysModuledef>();
        // 获取缓存里的用户功能权限
        byte[] value = ChargingCacheUtil.getUserModule(userid.toString());
        if (value == null) {
            if (roleid == Globals.ADMIN_ROLE_ID) {
                SysModuledefExample emp = new SysModuledefExample();
                SysModuledefExample.Criteria cr = emp.createCriteria();
                cr.andSystemidEqualTo((short) Globals.PLATFORM_SYSTEM_ID);
                emp.setOrderByClause("SORTNO");
                moduleList = roleService.selectModuledefByExample(emp);
            } else {
                moduleList = roleService.selectModuledefByUserid(userid);
            }
            // 设置缓存里的用户功能权限
            ChargingCacheUtil.setUserModule(userid.toString(), SerializeCoderUtil.serializeList(moduleList));
        } else {
            moduleList = SerializeCoderUtil.deserializeList(value);
        }
        return moduleList;
    }

    public static List<SysButtondef> selectButtondefByUserid(Integer userid, Integer roleid) {
        List<SysButtondef> buttonList = null;
        // 获取缓存里的用户功能按钮权限
        byte[] value = ChargingCacheUtil.getUserModuleBtn(userid.toString());
        if (value == null) {
            if (roleid == Globals.ADMIN_ROLE_ID) {
                buttonList = roleService.selectButtondefBySystemid((short) Globals.PLATFORM_SYSTEM_ID);
            } else {
                buttonList = roleService.selectButtondefByUserid(userid);
            }
            // 设置缓存里的用户功能按钮权限
            ChargingCacheUtil.setUserModuleBtn(userid.toString(), SerializeCoderUtil.serializeList(buttonList));
        } else {
            buttonList = SerializeCoderUtil.deserializeList(value);
        }
        return buttonList;
    }

    /**
     * 得到规则，缓存30分钟
     * 
     * @param id
     * @return
     */
    public static String selectRuleByPrimaryKey(String id) {
        String key = CacheKeyProvide.getKey(CacheKeyProvide.KEY_RULE, id);
        String ruleStr = ChargingCacheUtil.getString(key);

        if (ruleStr == null) {
            SysRule rule = roleService.selectRuleByPrimaryKey(id);
            if (rule != null) {
                ruleStr = rule.getRuleCheck();
                ChargingCacheUtil.setString(key, ruleStr, ChargingCacheUtil.EXRP_30M);
            }
        }

        return ruleStr;
    }

    public static void removeRule(String id) {
        String key = CacheKeyProvide.getKey(CacheKeyProvide.KEY_RULE, id);
        ChargingCacheUtil.delKey(key);
    }

    public void setRoleService(RoleService roleService) {
        RoleUtil.roleService = roleService;
    }
}
