package com.holley.web.common.util;

import java.util.regex.Pattern;

/**
 * 校验器：利用正则表达式校验邮箱、手机号等
 * 
 * @author
 */
public class Validator {

    /**
     * 正则表达式：验证用户名
     */
    public static final String REGEX_USERNAME  = "^[a-zA-Z]\\w{5,17}$";

    /**
     * 正则表达式：验证密码
     */
    public static final String REGEX_PASSWORD  = "^[a-zA-Z0-9]{6,16}$";

    /**
     * 正则表达式：验证手机号
     */
    // public static final String REGEX_MOBILE = "^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";
    public static final String REGEX_MOBILE    = "^((1))\\d{10}$";

    /**
     * 正则表达式：固定电话号码
     */
    public static final String REGEX_TELEPHONE = "(?:(\\(\\+?86\\))(0[0-9]{2,3}\\-?)?([2-9][0-9]{6,7})+(\\-[0-9]{1,4})?)|(?:(86-?)?(0[0-9]{2,3}\\-?)?([2-9][0-9]{6,7})+(\\-[0-9]{1,4})?)";

    /**
     * 正则表达式：验证邮箱
     */
    public static final String REGEX_EMAIL     = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";

    /**
     * 正则表达式：验证汉字
     */
    public static final String REGEX_CHINESE   = "^[\u4e00-\u9fa5]{1,}$";

    /**
     * 正则表达式：验证身份证
     */
    public static final String REGEX_ID_CARD   = "(^\\d{18}$)|(^\\d{15}$)";

    /**
     * 正则表达式：验证URL
     */
    public static final String REGEX_URL       = "http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=]*)?";

    /**
     * 正则表达式：验证IP地址
     */
    public static final String REGEX_IP_ADDR   = "([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}";

    /**
     * 正则表达式：金额
     */
    public static final String REGEX_MONEY     = "^(([1-9]{1}\\d*)|([0]{1}))(\\.(\\d){0,2})?$";

    /**
     * 校验用户名
     * 
     * @param username
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isUsername(String username) {
        if (username == null) return false;
        return Pattern.matches(REGEX_USERNAME, username);
    }

    /**
     * 校验密码
     * 
     * @param password
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isPassword(String password) {
        if (password == null) return false;
        return Pattern.matches(REGEX_PASSWORD, password);
    }

    /**
     * 校验手机号
     * 
     * @param mobile
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isMobile(String mobile) {
        if (mobile == null) return false;
        return Pattern.matches(REGEX_MOBILE, mobile);
    }

    /**
     * 区号+座机号码+分机号码
     * 
     * @param fixedPhone
     * @return
     */
    public static boolean isTelephone(String telehone) {
        if (telehone == null) return false;
        return Pattern.matches(REGEX_TELEPHONE, telehone);
    }

    /**
     * 校验邮箱
     * 
     * @param email
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isEmail(String email) {
        if (email == null) return false;
        return Pattern.matches(REGEX_EMAIL, email);
    }

    /**
     * 校验汉字
     * 
     * @param chinese
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isChinese(String chinese) {
        if (chinese == null) return false;
        return Pattern.matches(REGEX_CHINESE, chinese);
    }

    /**
     * 校验身份证
     * 
     * @param idCard
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isIDCard(String idCard) {
        if (idCard == null) return false;
        return Pattern.matches(REGEX_ID_CARD, idCard);
    }

    /**
     * 校验URL
     * 
     * @param url
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isUrl(String url) {
        if (url == null) return false;
        return Pattern.matches(REGEX_URL, url);
    }

    /**
     * 校验IP地址
     * 
     * @param ipAddr
     * @return
     */
    public static boolean isIPAddr(String ipAddr) {
        if (ipAddr == null) return false;
        return Pattern.matches(REGEX_IP_ADDR, ipAddr);
    }

    public static boolean isMoney(String money) {
        if (money == null) return false;
        return Pattern.matches(REGEX_MONEY, money);
    }

    public static void main(String[] args) {
        // System.out.println(Validator.isPassword("123456789123456"));
        // System.out.println(Validator.isMobile("18a12345678"));
        // System.out.println(Validator.isTelephone("89300329"));
        System.out.println(Validator.isMoney("09.01"));
    }
}
