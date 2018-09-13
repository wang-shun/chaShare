package com.holley.common.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * <p>
 * Title: 周计算类，星期一为一周的开始，星期日为一周的结束
 * </p>
 * <p>
 * Description: 在两年的交接地带还有疑问。
 * </p>
 * <p>
 * 比如2006-12-29到2009-01-04，属于2008年的最后一周，
 * </p>
 * <p>
 * 2009-01-05位2009年第一周的开始。
 * </p>
 * <p>
 * db2种的week_iso也是这样计算的
 * </p>
 * <p>
 * Copyright: Copyright (c) 2006
 * </p>
 * <p>
 * DateTime: 2006-4-11 23:36:39
 * </p>
 * 
 * @author gumpgz
 * @version 1.0
 */
public class WeekUtil {

    /**
     * 取得当前日期是多少周
     * 
     * @param date
     * @return
     */
    public static int getWeekOfYear(Date date) {
        Calendar c = new GregorianCalendar();
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.setMinimalDaysInFirstWeek(7);
        c.setTime(date);

        return c.get(Calendar.WEEK_OF_YEAR);
    }

    /**
     * 得到某一年周的总数
     * 
     * @param year
     * @return
     */
    public static int getMaxWeekNumOfYear(int year) {
        Calendar c = new GregorianCalendar();
        c.set(year, Calendar.DECEMBER, 31, 23, 59, 59);

        return getWeekOfYear(c.getTime());
    }

    /**
     * 得到某年某周的第一天
     * 
     * @param year
     * @param week
     * @return
     */
    public static Date getFirstDayOfWeek(int year, int week) {
        Calendar c = new GregorianCalendar();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, Calendar.JANUARY);
        c.set(Calendar.DATE, 1);

        Calendar cal = (GregorianCalendar) c.clone();
        cal.add(Calendar.DATE, week * 7);

        return getFirstDayOfWeek(cal.getTime());
    }

    /**
     * 得到某年某周的最后一天
     * 
     * @param year
     * @param week
     * @return
     */
    public static Date getLastDayOfWeek(int year, int week) {
        Calendar c = new GregorianCalendar();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, Calendar.JANUARY);
        c.set(Calendar.DATE, 1);

        Calendar cal = (GregorianCalendar) c.clone();
        cal.add(Calendar.DATE, week * 7);

        return getLastDayOfWeek(cal.getTime());
    }

    /**
     * 取得当前日期所在周的第一天
     * 
     * @param date
     * @return
     */
    public static Date getFirstDayOfWeek(Date date) {
        Calendar c = new GregorianCalendar();
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.setTime(date);
        c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek()); // Monday
        return c.getTime();
    }

    /**
     * 取得当前日期所在周的最后一天
     * 
     * @param date
     * @return
     */
    public static Date getLastDayOfWeek(Date date) {
        Calendar c = new GregorianCalendar();
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.setTime(date);
        c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek() + 6); // Sunday
        return c.getTime();
    }

    public static void main(String[] args) {
        int year = 2006;
        int week = 1;

        // 以2006-01-02位例
        Calendar c = new GregorianCalendar();
        c.set(2006, Calendar.JANUARY, 2);
        Date d = c.getTime();

        System.out.println("current date = " + d);
        System.out.println("getWeekOfYear = " + getWeekOfYear(d));
        System.out.println("getMaxWeekNumOfYear = " + getMaxWeekNumOfYear(year));
        System.out.println("getFirstDayOfWeek = " + getFirstDayOfWeek(year, week));
        System.out.println("getLastDayOfWeek = " + getLastDayOfWeek(year, week));
        System.out.println("getFirstDayOfWeek = " + getFirstDayOfWeek(d));
        System.out.println("getLastDayOfWeek = " + getLastDayOfWeek(d));
    }
}
