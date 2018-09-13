package com.holley.common.cache.charging;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import org.apache.commons.lang.SerializationUtils;

import com.holley.common.cache.RedisUtil;
import com.holley.common.cache.charging.CacheKeyProvide.KeyMsgCodeTypeEnum;
import com.holley.common.cache.charging.CacheKeyProvide.KeySessionTypeEnum;
import com.holley.common.constants.charge.PileAppStatusEnum;
import com.holley.common.constants.charge.PileStatusEnum;
import com.holley.common.constants.charge.UserTypeEnum;
import com.holley.common.dataobject.LoginCountBean;
import com.holley.common.dataobject.PileStatusBean;
import com.holley.common.dataobject.WebUser;
import com.holley.common.dataobject.charging.dcs.PileMonitor_CRAC;
import com.holley.common.dataobject.charging.dcs.PileMonitor_CRDC;
import com.holley.common.util.DateUtil;
import com.holley.common.util.JsonUtil;
import com.holley.common.util.StringUtil;

/**
 * 电动汽车业务缓存
 * 
 * @author zhouli
 */
public class ChargingCacheUtil extends RedisUtil {

    /**
     * 缓存存储图片验证码，3分钟内有效
     * 
     * @param jsessionId
     * @param code
     */
    public static void setImgValidateCode(String jsessionId, String code) {
        setString(CacheKeyProvide.getKey(CacheKeyProvide.KEY_IMG_VALIDATE, jsessionId), code, EXRP_3M);
    }

    public static String getImgValidateCode(String jsessionId) {
        return getString(CacheKeyProvide.getKey(CacheKeyProvide.KEY_IMG_VALIDATE, jsessionId));
    }

    /**
     * 缓存存储短信验证码，1分钟内有效
     * 
     * @param jsessionId
     * @param code
     */
    public static void setMessageValidateCode(String jsessionId, String code, KeyMsgCodeTypeEnum type) {
        if (KeyMsgCodeTypeEnum.REGISTER == type) {
            setString(CacheKeyProvide.getKey(CacheKeyProvide.KEY_MESSAGE_REGISTER_VALIDATE, jsessionId), code, EXRP_3M);
        } else if (KeyMsgCodeTypeEnum.RESETPWD == type) {
            setString(CacheKeyProvide.getKey(CacheKeyProvide.KEY_MESSAGE_RESETPWD_VALIDATE, jsessionId), code, EXRP_3M);
        } else if (KeyMsgCodeTypeEnum.CASH == type) {
            setString(CacheKeyProvide.getKey(CacheKeyProvide.KEY_MESSAGE_CASH_VALIDATE, jsessionId), code, EXRP_3M);
        }
    }

    public static String getMessageValidateCode(String jsessionId, KeyMsgCodeTypeEnum type) {
        if (KeyMsgCodeTypeEnum.REGISTER == type) {
            return getString(CacheKeyProvide.getKey(CacheKeyProvide.KEY_MESSAGE_REGISTER_VALIDATE, jsessionId));
        } else if (KeyMsgCodeTypeEnum.RESETPWD == type) {
            return getString(CacheKeyProvide.getKey(CacheKeyProvide.KEY_MESSAGE_RESETPWD_VALIDATE, jsessionId));
        } else if (KeyMsgCodeTypeEnum.CASH == type) {
            return getString(CacheKeyProvide.getKey(CacheKeyProvide.KEY_MESSAGE_CASH_VALIDATE, jsessionId));
        }
        return null;
    }

    /**
     * 存储用户登录的信息，验证登录次数
     * 
     * @param bean
     * @return
     */
    public static boolean setLoginCount(String account, KeySessionTypeEnum type, LoginCountBean bean) {
        if (account == null || bean == null) return false;
        byte[] value = SerializationUtils.serialize(bean);
        String key = null;
        if (KeySessionTypeEnum.APP == type) {
            key = CacheKeyProvide.getKey(CacheKeyProvide.KEY_APP_LOGIN_BEAN, account);
        } else if (KeySessionTypeEnum.WEB == type) {
            key = CacheKeyProvide.getKey(CacheKeyProvide.KEY_WEB_LOGIN_BEAN, account);
        } else if (KeySessionTypeEnum.BMS == type) {
            key = CacheKeyProvide.getKey(CacheKeyProvide.KEY_BMS_LOGIN_BEAN, account);
        } else {
            return false;
        }
        setByteEx(key.getBytes(), value, EXRP_30M);
        return true;
    }

    public static LoginCountBean getLoginCount(String account, KeySessionTypeEnum type) {
        if (account == null) return null;
        String key = null;
        if (KeySessionTypeEnum.APP == type) {
            key = CacheKeyProvide.getKey(CacheKeyProvide.KEY_APP_LOGIN_BEAN, account);
        } else if (KeySessionTypeEnum.WEB == type) {
            key = CacheKeyProvide.getKey(CacheKeyProvide.KEY_WEB_LOGIN_BEAN, account);
        } else if (KeySessionTypeEnum.BMS == type) {
            key = CacheKeyProvide.getKey(CacheKeyProvide.KEY_BMS_LOGIN_BEAN, account);
        } else {
            return null;
        }
        byte[] value = getByte(key.getBytes());
        if (value != null) {
            return (LoginCountBean) SerializationUtils.deserialize(value);
        }
        return null;
    }

    public static boolean removeLoginCount(String account, KeySessionTypeEnum type) {
        if (account == null) return false;
        String key = null;
        if (KeySessionTypeEnum.APP == type) {
            key = CacheKeyProvide.getKey(CacheKeyProvide.KEY_APP_LOGIN_BEAN, account);
        } else if (KeySessionTypeEnum.WEB == type) {
            key = CacheKeyProvide.getKey(CacheKeyProvide.KEY_WEB_LOGIN_BEAN, account);
        } else if (KeySessionTypeEnum.BMS == type) {
            key = CacheKeyProvide.getKey(CacheKeyProvide.KEY_BMS_LOGIN_BEAN, account);
        } else {
            return false;
        }
        return delKey(key.getBytes());
    }

    /**
     * * 存储用户登录信息,30分钟失效
     * 
     * @param user
     * @param type 网站或者app
     * @return
     * @throws Exception
     */
    public static boolean setSession(WebUser user, KeySessionTypeEnum type, String webUserKey) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("userId", user.getUserId().toString());
        map.put("userName", user.getUserName());
        logger.info(user.getUsertype().getShortValue().toString());
        map.put("usertype", user.getUsertype().getShortValue().toString());
        map.put("loginDate", DateUtil.DateToLongStr(user.getLoginDate()));
        /* map.put("ip", user.getIp()); */
        // map.put("roleId", user.getRoleId().toString());
        map.put("email", user.getEmail());
        if (user.getEamilStatus() != null) {
            map.put("emailStatus", user.getEamilStatus().toString());
        }
        map.put("phone", user.getPhone());
        map.put("phoneStatus", user.getPhoneStatus().toString());
        if (user.getInfoId() != null) {
            map.put("infoId", user.getInfoId().toString());
        }
        if (user.getRealStatus() != null) {
            map.put("realStatus", user.getRealStatus().toString());
        }
        map.put("registTime", DateUtil.DateToLongStr(user.getRegistTime()));
        if (user.getHeadImg() != null) {
            map.put("headImg", user.getHeadImg());
        }
        if (user.getRoleId() != null) {
            map.put("roleId", user.getRoleId().toString());
        }
        if (user.getRoleType() != null) {
            map.put("roleType", user.getRoleType().toString());
        }

        // String key = CacheKeyProvide.getSessionKey(user.getUserId().toString());
        String key = null;
        if (KeySessionTypeEnum.APP == type) {
            key = CacheKeyProvide.getKey(CacheKeyProvide.KEY_APP_SESSION, user.getUserId().toString());
        } else if (KeySessionTypeEnum.WEB == type) {
            // key = CacheKeyProvide.getKey(CacheKeyProvide.KEY_WEB_SESSION, user.getUserId().toString());
            key = webUserKey;
        } else if (KeySessionTypeEnum.BMS == type) {
            key = CacheKeyProvide.getKey(CacheKeyProvide.KEY_BMS_SESSION, user.getUserId().toString());
        } else {
            return false;
        }
        setHash(key, map);
        expire(key, EXRP_30M);
        return true;
    }

    /**
     * 获得用户信息
     * 
     * @param userid
     * @param type 网站或者app
     * @return
     */
    public static WebUser getSession(String userid, KeySessionTypeEnum type, String webUserKey) {
        if (userid == null) {
            return null;
        }

        String key = null;
        if (KeySessionTypeEnum.APP == type) {
            key = CacheKeyProvide.getKey(CacheKeyProvide.KEY_APP_SESSION, userid);
        } else if (KeySessionTypeEnum.WEB == type) {
            if (webUserKey == null) return null;
            // key = CacheKeyProvide.getKey(CacheKeyProvide.KEY_WEB_SESSION, userid);
            key = webUserKey;
        } else if (KeySessionTypeEnum.BMS == type) {
            key = CacheKeyProvide.getKey(CacheKeyProvide.KEY_BMS_SESSION, userid);
        } else {
            return null;
        }

        Map<String, String> map = getHashAll(key);
        if (map == null || map.size() == 0) {
            return null;
        }

        WebUser user = new WebUser();
        user.setUserId(Integer.valueOf(userid));
        user.setUserName(map.get("userName"));
        UserTypeEnum usertype = UserTypeEnum.getEnmuByValue(map.get("usertype") == null ? null : Integer.valueOf(map.get("usertype")));
        user.setUsertype(usertype == null ? null : usertype);
        user.setLoginDate(DateUtil.LongStrToDate(map.get("loginDate")));
        user.setEmail(map.get("email"));
        user.setEamilStatus(map.get("emailStatus") == null ? null : Short.valueOf(map.get("emailStatus")));
        user.setPhone(map.get("phone"));
        user.setPhoneStatus(map.get("phoneStatus") == null ? null : Short.valueOf(map.get("phoneStatus")));
        user.setInfoId(map.get("infoId") == null ? null : Integer.valueOf(map.get("infoId")));
        user.setRealStatus(map.get("realStatus") == null ? null : Short.valueOf(map.get("realStatus")));
        user.setRegistTime(DateUtil.LongStrToDate(map.get("registTime")));
        user.setHeadImg(map.get("headImg"));
        user.setRoleType(map.get("roleType") == null ? null : Short.valueOf(map.get("roleType")));
        user.setRoleId(map.get("roleId") == null ? null : Integer.valueOf(map.get("roleId")));
        return user;
    }

    public static void removieSession(String userid, KeySessionTypeEnum type, String webUserKey) {
        String key = null;
        if (KeySessionTypeEnum.APP == type) {
            key = CacheKeyProvide.getKey(CacheKeyProvide.KEY_APP_SESSION, userid);
        } else if (KeySessionTypeEnum.WEB == type) {
            // key = CacheKeyProvide.getKey(CacheKeyProvide.KEY_WEB_SESSION, userid);
            key = webUserKey;
        } else if (KeySessionTypeEnum.BMS == type) {
            key = CacheKeyProvide.getKey(CacheKeyProvide.KEY_BMS_SESSION, userid);
        } else {
            return;
        }
        delKey(key);
    }

    /**
     * 设置充电桩状态对象缓存
     * 
     * @param bean
     * @return
     */

    public static boolean setPileStatusBean(PileStatusBean bean) {
        if (bean != null) {
            byte[] value = SerializationUtils.serialize(bean);
            setByte(CacheKeyProvide.getKey(CacheKeyProvide.KEY_PILESTATUS_BEAN, bean.getId().toString()).getBytes(), value);
            // setByteEx(CacheKeyProvide.getKey(CacheKeyProvide.KEY_PILESTATUS_BEAN,
            // bean.getId().toString()).getBytes(), value, EXRP_30M);
            setPileStatus(bean.getId(), bean.getStatus().getValue());
            return true;
        }
        return false;
    }

    /**
     * 获取充电桩状态对象缓存
     * 
     * @param pileid
     * @return
     */
    public static PileStatusBean getPileStatusBean(Integer pileid) {
        if (pileid != null) {
            byte[] value = getByte(CacheKeyProvide.getKey(CacheKeyProvide.KEY_PILESTATUS_BEAN, pileid.toString()).getBytes());
            if (value != null) {
                PileStatusBean statusBean = (PileStatusBean) SerializationUtils.deserialize(value);
                if (statusBean != null && statusBean.getAppstatus() != null && PileAppStatusEnum.ORDER_SUCCESS.equals(statusBean.getAppstatus())) {// 如果是预约中，则判断是否过期
                    if (statusBean.getAppendtime() != null && new Date().compareTo(statusBean.getAppendtime()) >= 0) {
                        statusBean.setAppstatus(PileAppStatusEnum.UNORDERED);
                        statusBean.setApprecordid(0);
                        statusBean.setAppendtime(null);
                        setPileStatusBean(statusBean);
                    }
                }
                return statusBean;
            }
        }
        return null;
    }

    /**
     * 设置创睿交流充电桩设备监视缓存对象 KEY_PILEMONITOR_CRAC
     * 
     * @param bean
     * @return
     */

    public static boolean setPileMonitorCRAC(PileMonitor_CRAC bean) {
        if (bean != null) {
            byte[] value = SerializationUtils.serialize(bean);
            setByteEx(CacheKeyProvide.getKey(CacheKeyProvide.KEY_PILEMONITOR_CRAC, bean.getId().toString()).getBytes(), value, EXRP_30M);
            return true;
        }
        return false;
    }

    /**
     * 获取创睿交流充电桩设备监视缓存对象
     * 
     * @param pileid
     * @return
     */
    public static PileMonitor_CRAC getPileMonitorCRAC(Integer pileid) {
        if (pileid != null) {
            byte[] value = getByte(CacheKeyProvide.getKey(CacheKeyProvide.KEY_PILEMONITOR_CRAC, pileid.toString()).getBytes());
            if (value != null) {
                return (PileMonitor_CRAC) SerializationUtils.deserialize(value);
            }
        }
        return null;
    }

    /**
     * 设置创睿直流充电桩设备监视缓存对象 KEY_PILEMONITOR_CRAC
     * 
     * @param bean
     * @return
     */

    public static boolean setPileMonitorCRDC(PileMonitor_CRDC bean) {
        if (bean != null) {
            byte[] value = SerializationUtils.serialize(bean);
            setByteEx(CacheKeyProvide.getKey(CacheKeyProvide.KEY_PILEMONITOR_CRDC, bean.getId().toString()).getBytes(), value, EXRP_30M);
            return true;
        }
        return false;
    }

    /**
     * 获取创睿直流充电桩设备监视缓存对象
     * 
     * @param pileid
     * @return
     */
    public static PileMonitor_CRDC getPileMonitorCRDC(Integer pileid) {
        if (pileid != null) {
            byte[] value = getByte(CacheKeyProvide.getKey(CacheKeyProvide.KEY_PILEMONITOR_CRDC, pileid.toString()).getBytes());
            if (value != null) {
                return (PileMonitor_CRDC) SerializationUtils.deserialize(value);
            }
        }
        return null;
    }

    /**
     * 设置充电桩状态缓存
     * 
     * @param pileId
     * @return
     */
    public static boolean setPileStatus(Integer pileId, Integer status) {
        if (pileId == null || status == null) {
            return false;
        }
        return setString(pileId.toString(), String.valueOf(status));
    }

    /**
     * 获取充电桩状态缓存
     * 
     * @param pileId
     * @return
     */
    public static PileStatusEnum getPileStatus(Integer pileId) {
        if (pileId == null) {
            return null;
        }
        String st = getString(pileId.toString());
        if (st != null) {
            return PileStatusEnum.getEnmuByValue(Integer.valueOf(st));
        }
        return null;
    }

    /**
     * 存储用户充电点充电桩加密key,7天失效
     *
     * @param securitykey
     * @param uuid
     * @return boolean
     */
    public static boolean setSecurityKeySession(String securitykey, String uuid) {
        String key = CacheKeyProvide.getKey(CacheKeyProvide.KEY_SECURITYKEY_SESSION, uuid);
        setString(key, securitykey);
        expire(key, EXRP_DAY * 7);
        return true;
    }

    /**
     * 获取用户充电点充电桩加密key
     * 
     * @param uuid
     * @return String
     */

    public static String getSecurityKeySession(String uuid) {
        if (uuid == null) {
            return null;
        }
        String key = CacheKeyProvide.getKey(CacheKeyProvide.KEY_SECURITYKEY_SESSION, uuid);
        return getString(key);
    }

    /**
     * 设置用户功能权限,有效期1天
     * 
     * @param userid
     * @param value
     * @return
     */
    public static boolean setUserModule(String userid, byte[] value) {
        String key = CacheKeyProvide.getKey(CacheKeyProvide.KEY_USER_MODULE, userid);
        setByteEx(key.getBytes(), value, EXRP_DAY);
        return true;
    }

    /**
     * 获取用户功能权限
     * 
     * @param userid
     * @return
     */
    public static byte[] getUserModule(String userid) {
        String key = CacheKeyProvide.getKey(CacheKeyProvide.KEY_USER_MODULE, userid);
        return getByte(key.getBytes());
    }

    /**
     * 删除用户功能权限
     * 
     * @param userid
     * @return
     */
    public static boolean removeUserModule(String userid) {
        String key = CacheKeyProvide.getKey(CacheKeyProvide.KEY_USER_MODULE, userid);
        return delKey(key.getBytes());
    }

    /**
     * 设置用户功能按钮权限,有效期1天
     * 
     * @param userid
     * @param value
     * @return
     */
    public static boolean setUserModuleBtn(String userid, byte[] value) {
        String key = CacheKeyProvide.getKey(CacheKeyProvide.KEY_USER_MODULE_BUTTON, userid);
        setByteEx(key.getBytes(), value, EXRP_DAY);
        return true;
    }

    /**
     * 获取用户功能按钮权限
     * 
     * @param userid
     * @return
     */
    public static byte[] getUserModuleBtn(String userid) {
        String key = CacheKeyProvide.getKey(CacheKeyProvide.KEY_USER_MODULE_BUTTON, userid);
        return getByte(key.getBytes());
    }

    /**
     * 删除用户功能按钮权限
     * 
     * @param userid
     * @return
     */
    public static boolean removeUserModuleBtn(String userid) {
        String key = CacheKeyProvide.getKey(CacheKeyProvide.KEY_USER_MODULE_BUTTON, userid);
        return delKey(key.getBytes());
    }

    /**
     * 获取某个充电桩的六位交易序列号
     * 
     * @param pileId
     * @return
     */
    public static synchronized int getChargeNo(String pileId) {
        String key = CacheKeyProvide.getKey(CacheKeyProvide.KEY_CHARGE_NO, pileId);
        String no = getString(key);
        int value = 1;
        if (StringUtil.isNotEmpty(no)) {
            value = Integer.valueOf(no);
            if (value == 999999) {
                value = 1;
            } else {
                value++;
            }
        }
        setString(key, String.valueOf(value));
        return value;
    }

    /**
     * 获取某个充电桩的六位交易序列号
     * 
     * @return
     */
    public static synchronized String getRechargeNo() {
        String key = CacheKeyProvide.getKey(CacheKeyProvide.KEY_RECHARGE_NO, "");
        String no = getString(key);
        int value = 1;
        if (StringUtil.isNotEmpty(no)) {
            value = Integer.valueOf(no);
            if (value == 999999) {
                value = 1;
            } else {
                value++;
            }
        }
        setString(key, String.valueOf(value));
        return DateUtil.DateToLong14Str(new Date()) + StringUtil.zeroPadString(value + "", 6);
    }

    /**
     * 设置用户信息,有效期1天
     * 
     * @param userid
     * @param value
     * @return
     */
    public static boolean setUser(String userid, byte[] value) {
        String key = CacheKeyProvide.getKey(CacheKeyProvide.KEY_USER, userid);
        setByteEx(key.getBytes(), value, EXRP_DAY);
        return true;
    }

    /**
     * 获取用户功能按钮权限
     * 
     * @param userid
     * @return
     */
    public static byte[] getUser(String userid) {
        String key = CacheKeyProvide.getKey(CacheKeyProvide.KEY_USER, userid);
        return getByte(key.getBytes());
    }

    /**
     * 删除用户信息
     * 
     * @param userid
     * @return
     */
    public static boolean removeUser(String userid) {
        String key = CacheKeyProvide.getKey(CacheKeyProvide.KEY_USER, userid);
        return delKey(key.getBytes());
    }

    /**
     * 获取档案更新时间
     * 
     * @param key
     * @return
     */
    public static Date getUpdateTime(String key) {
        String value = getString(key);
        return value == null ? null : DateUtil.LongStrToDate(value);
    }

    /***
     * 添加删除设备
     * 
     * @param stationId
     * @param pileId
     */
    public static void setDelPile(String stationId) {
        String value = getString(CacheKeyProvide.KEY_PILE_DELETE);
        List<String> list = null;
        if (StringUtil.isEmpty(value)) {
            list = new ArrayList<String>();
            list.add(stationId);
        } else {
            list = JSONArray.fromObject(value);
            if (!list.contains(stationId)) {
                list.add(stationId);
            }

        }
        if (list != null && list.size() > 0) {
            setString(CacheKeyProvide.KEY_PILE_DELETE, JsonUtil.list2json(list));
        }

    }

    public static List<String> getDelPile() {
        String value = getString(CacheKeyProvide.KEY_PILE_DELETE);
        List<String> list = null;
        if (!StringUtil.isEmpty(value)) {
            list = JSONArray.fromObject(value);
        }
        return list;
    }

    public static boolean removeDelPile() {
        return delKey(CacheKeyProvide.KEY_PILE_DELETE);
    }

    /**
     * 设置档案更新时间
     * 
     * @param key
     * @param value
     * @return
     */
    public static boolean setUpdateTime(String key, Date value) {
        if (value == null) return false;
        setString(key, DateUtil.DateToLongStr(value));
        return true;
    }

    /**
     * 设置数据字典更新标识
     * 
     * @param type
     * @return
     */
    public static boolean setLinkUpdate() {
        setString(CacheKeyProvide.KEY_APP_LINK_UPDATE, String.valueOf(true));
        setString(CacheKeyProvide.KEY_WEB_LINK_UPDATE, String.valueOf(true));
        return true;
    }

    /**
     * 获取数据字典更新标识
     * 
     * @param type
     * @return
     */
    public static boolean getLinkUpdate(KeySessionTypeEnum type) {
        if (type == null) return false;
        String result = null;
        if (KeySessionTypeEnum.APP == type) {
            result = getString(CacheKeyProvide.KEY_APP_LINK_UPDATE);
        } else if (KeySessionTypeEnum.WEB == type) {
            result = getString(CacheKeyProvide.KEY_WEB_LINK_UPDATE);
        }
        return result == null ? false : true;
    }

    /**
     * 删除数据字典更新标识
     * 
     * @param type
     * @return
     */
    public static boolean removeLinkUpdate(KeySessionTypeEnum type) {
        if (type == null) return false;
        if (KeySessionTypeEnum.APP == type) {
            delKey(CacheKeyProvide.KEY_APP_LINK_UPDATE);
        } else if (KeySessionTypeEnum.WEB == type) {
            delKey(CacheKeyProvide.KEY_WEB_LINK_UPDATE);
        }
        return true;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        String json = JsonUtil.list2json(list);
        List<String> l = JSONArray.fromObject(json);
        System.out.println(l.get(0));
    }
}
