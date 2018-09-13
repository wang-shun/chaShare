package com.holley.charging.common.util;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import net.sf.json.JSONObject;

import org.apache.commons.lang3.math.NumberUtils;
import org.apache.log4j.Logger;

import com.holley.charging.model.def.ChargingConfig;
import com.holley.common.util.DateUtil;
import com.holley.common.util.StringUtil;

public class ShareUtil {

    private final static Logger logger    = Logger.getLogger(ShareUtil.class);
    public final static int     PERCISION = BigDecimal.ROUND_DOWN;            // 截取
    public final static int     PRE_DAY   = -1;

    // private final static ExecutorService CACHE_THREAD_POOL = Executors.newCachedThreadPool();

    /**
     * 用于生成订单编号（运营商ID+yyyyMMddHHmmss+4位随机数）
     * 
     * @return
     */
    public static String getTradeNo() {
        return ChargingConfig.getDomainOperatorId() + DateUtil.DateToLong14Str(new Date()) + StringUtil.randomNumber(4);
    }

    public static Date getStartTime(Date date, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, day);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public static Date getEndTime(Date date, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, day);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTime();
    }

    public static BigDecimal returnBigDecimal(Object value) {
        if (value == null) {
            return BigDecimal.ZERO;
        }
        if (value instanceof Double) {
            return BigDecimal.valueOf((Double) value);
        }
        if (value instanceof BigDecimal) {
            return (BigDecimal) value;
        }
        return BigDecimal.ZERO;
    }

    public static BigDecimal formateScale(int scale, BigDecimal value) {
        if (value == null) return null;
        return value.setScale(scale, PERCISION);
    }

    /**
     * 提供精确的加法运算。
     * 
     * @param b1 加数
     * @param b2 被加数
     * @return 两个参数的和
     */
    public static BigDecimal add(BigDecimal b1, BigDecimal b2) {
        return b1.add(b2);
    }

    public static int getDataInt(JSONObject data, String key) {
        if (data == null) {
            return 0;
        }
        return data.containsKey(key) ? NumberUtils.toInt(data.getString(key)) : 0;
    }

    public static String getDataStr(JSONObject data, String key) {
        if (data == null) {
            return "";
        }
        return data.containsKey(key) ? data.getString(key) : "";
    }

}
