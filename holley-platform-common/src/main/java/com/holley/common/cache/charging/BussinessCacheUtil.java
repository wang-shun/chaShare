package com.holley.common.cache.charging;

import com.holley.common.cache.RedisUtil;

/**
 * 运营平台缓存业务
 * 
 * @author shencheng
 */
public class BussinessCacheUtil extends RedisUtil {

    /**
     * 新手机号码验证30分钟有效
     * 
     * @param userId
     * @param phone
     */
    public static void setChangePhoneNum(String userId, String phone) {
        setString(CacheKeyProvide.getKey(CacheKeyProvide.KEY_CHANGE_PHONE_NUM, userId), phone, EXRP_3M);
    }

    public static String getChangePhoneNum(String userId) {
        return getString(CacheKeyProvide.getKey(CacheKeyProvide.KEY_CHANGE_PHONE_NUM, userId));
    }

    /**
     * 设置更改的手机发送的验证码有效时间1分钟有效
     * 
     * @param userId
     * @param code
     */
    public static void setChangePhoneCode(String userId, String code) {
        setString(CacheKeyProvide.getKey(CacheKeyProvide.KEY_CHANGE_PHONE_CODE, userId), code, EXRP_3M);
    }

    public static String getChangePhoneCode(String userId) {
        return getString(CacheKeyProvide.getKey(CacheKeyProvide.KEY_CHANGE_PHONE_CODE, userId));
    }

    /**
     * 修改手机操作3分钟有效
     * 
     * @param userId
     * @param value
     */
    public static void setChangePhone(String userId, String value) {
        setString(CacheKeyProvide.getKey(CacheKeyProvide.KEY_CHANGE_PHONE, userId), value, EXRP_3M);
    }

    public static String getChangePhone(String userId) {
        return getString(CacheKeyProvide.getKey(CacheKeyProvide.KEY_CHANGE_PHONE, userId));
    }

    /**
     * 根据运营商ID设置实时设备信息
     * 
     * @param userId
     * @param value
     */
    public static void setOlineDeviceList(String infoId, byte[] value) {
        setByte(CacheKeyProvide.getKey(CacheKeyProvide.KEY_ONLINE_INFO_ID, infoId).getBytes(), value);
    }

    public static byte[] getOlineDeviceList(String infoId) {
        return getByte(CacheKeyProvide.getKey(CacheKeyProvide.KEY_ONLINE_INFO_ID, infoId).getBytes());
    }

    /**
     * 设置修改邮箱操作3分钟有效
     * 
     * @param userId
     * @param value
     */
    public static void setChangeEmail(String userId, String value) {
        setString(CacheKeyProvide.getKey(CacheKeyProvide.KEY_CHANGE_EMAIL, userId), value, EXRP_3M);
    }

    public static String getChangeEmail(String userId) {
        return getString(CacheKeyProvide.getKey(CacheKeyProvide.KEY_CHANGE_EMAIL, userId));
    }

    /**
     * 设置修改交易密码操作3分钟有效
     * 
     * @param userId
     * @param value
     */
    public static void setChangePayPwd(String userId, String value) {
        setString(CacheKeyProvide.getKey(CacheKeyProvide.KEY_CHANGE_PAYPWD, userId), value, EXRP_3M);
    }

    public static String getChangePayPwd(String userId) {
        return getString(CacheKeyProvide.getKey(CacheKeyProvide.KEY_CHANGE_PAYPWD, userId));
    }

    /**
     * 设置修改密码操作3分钟有效
     * 
     * @param userId
     * @param value
     */
    public static void setChangePwd(String userId, String value) {
        setString(CacheKeyProvide.getKey(CacheKeyProvide.KEY_CHANGE_PWD, userId), value, EXRP_3M);
    }

    public static String getChangePwd(String userId) {
        return getString(CacheKeyProvide.getKey(CacheKeyProvide.KEY_CHANGE_PWD, userId));
    }

    /**
     * 设置短信验证码3分钟有效
     * 
     * @param userId
     * @param code
     */
    public static void setPhoneCode(String userId, String code) {
        setString(CacheKeyProvide.getKey(CacheKeyProvide.KEY_PHONE_CODE, userId), code, EXRP_3M);
    }

    public static String getPhoneCode(String userId) {
        return getString(CacheKeyProvide.getKey(CacheKeyProvide.KEY_PHONE_CODE, userId));
    }

    /**
     * 设置邮箱验证码3分钟有效
     * 
     * @param userId
     * @param code
     */
    public static void setEamilCode(String userId, String code) {
        setString(CacheKeyProvide.getKey(CacheKeyProvide.KEY_EMAIL_CODE, userId), code, EXRP_3M);
    }

    public static String getEamilCode(String userId) {
        return getString(CacheKeyProvide.getKey(CacheKeyProvide.KEY_EMAIL_CODE, userId));
    }

    /**
     * 设置邮箱30分钟有效
     * 
     * @param userId
     * @param email
     */
    public static void setEamil(String userId, String email) {
        setString(CacheKeyProvide.getKey(CacheKeyProvide.KEY_EMAIL, userId), email, EXRP_30M);
    }

    public static String getEamil(String userId) {
        return getString(CacheKeyProvide.getKey(CacheKeyProvide.KEY_EMAIL, userId));
    }

    public static void removieEamilCode(String userId) {
        delKey(CacheKeyProvide.getKey(CacheKeyProvide.KEY_EMAIL_CODE, userId));
    }

    public static void removiePhoneCode(String userId) {
        delKey(CacheKeyProvide.getKey(CacheKeyProvide.KEY_PHONE_CODE, userId));
    }

    public static void removieEamil(String userId) {
        delKey(CacheKeyProvide.getKey(CacheKeyProvide.KEY_EMAIL, userId));
    }

    public static void removieChangePwd(String userId) {
        delKey(CacheKeyProvide.getKey(CacheKeyProvide.KEY_CHANGE_PWD, userId));
    }

    public static void removieChangePayPwd(String userId) {
        delKey(CacheKeyProvide.getKey(CacheKeyProvide.KEY_CHANGE_PAYPWD, userId));
    }

    public static void removieChangeEmail(String userId) {
        delKey(CacheKeyProvide.getKey(CacheKeyProvide.KEY_CHANGE_EMAIL, userId));
    }

    public static void removieChangePhoneCode(String userId) {
        delKey(CacheKeyProvide.getKey(CacheKeyProvide.KEY_CHANGE_PHONE_CODE, userId));
    }

    public static void removieChangePhone(String userId) {
        delKey(CacheKeyProvide.getKey(CacheKeyProvide.KEY_CHANGE_PHONE, userId));
    }

    public static void removieChangePhoneNum(String userId) {
        delKey(CacheKeyProvide.getKey(CacheKeyProvide.KEY_CHANGE_PHONE_NUM, userId));
    }

    public static void removieOlineDeviceList(String infoId) {
        delKey(CacheKeyProvide.getKey(CacheKeyProvide.KEY_ONLINE_INFO_ID, infoId));
    }
}
