package com.ichaoge.pet.utils;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.joda.time.DateTime;
import org.joda.time.LocalTime;
import org.joda.time.Period;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 实现描述：日期处理工具
 *
 * @author simon
 * @version v1.0.0
 * @see
 * @since 2015年5月27日 上午12:15:01
 */
public final class DateUtils {

    private final static Logger logger = LoggerFactory.getLogger(DateUtils.class);

    public static Date min() {
        return new Date(0L);
    }

    public static String format(Date time) {
        return format(time, "yyyy-MM-dd HH:mm:ss");
    }

    public static String formatNoSec(Date time) {
        return format(time, "yyyy-MM-dd HH:mm");
    }

    public static String format(Date time, String pattern) {
        return new DateTime(time).toString(pattern);
    }

    public static Date parse(String time) {
        return DateTime.parse(time.replace(' ', 'T')).toDate();
    }

    public static Date parseTime(String time) {
        return new DateTime(0L).withMillisOfDay(LocalTime.parse(time).getMillisOfDay()).toDate();
    }

    public static Date secondsLater(int seconds) {
        return new DateTime().plusSeconds(seconds).toDate();
    }

    public static Date secondsAgo(int seconds) {
        return new DateTime().minusSeconds(seconds).toDate();
    }

    public static int secondsLater(Date future) {
        return (int) ((future.getTime() - System.currentTimeMillis()) / 1000L);
    }

    public static boolean isBeforeHoursAgo(Date time, int hours) {
        return new DateTime(time).plusHours(hours).isBeforeNow();
    }

    public static boolean isBeforeMinutesAgo(Date time, int minutes) {
        return new DateTime(time).plusMinutes(minutes).isBeforeNow();
    }

    public static int diffMinutes(Date from, Date to) {
        Period period = new Period(new DateTime(from), new DateTime(to));
        return period.toStandardMinutes().getMinutes();
    }

    public final static String DATE_CHINESE_PATTERN = "yyyy年MM月dd日";

    public final static String DATE_MONTH_DAY_CHINESE_PATTERN = "MM月dd日";

    /**
     * 标准的中文小时分钟格式
     */
    public final static String HOUR_MINUTE_CHINESE_PATTERN = "HH点mm分";

    /**
     * 标准日期格式
     */
    public final static String DATE_PATTERN = "yyyy-MM-dd";

    /**
     * 年份
     */
    public final static String YYYY = "yyyy";

    public final static String DATE_YYYY_MM = "yyyy-MM";

    public final static String DATE_YYYYMM = "yyyyMM";

    public final static String DATE_SHORT_PATTERN = "yyyyMMdd";

    public final static String DATE_SLASH_PATTERN = "yyyy/MM/dd";

    /**
     * 标准日期时分秒毫秒格式
     */
    public final static String DATETIME_MILL_SECOND = "yyyy-MM-dd HH:mm:ss.SSS";

    /**
     * 标准时间格式
     */
    public final static String DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    /**
     * 标准时间格式，不含秒
     */
    public final static String DATETIME_PATTERN_SHORT = "yyyy-MM-dd HH:mm";

    /**
     * 特殊的格式 针对创建订单，拼凑的最晚支付时间
     */
    public final static String DATETIME_PATTERN_CREAT_ORDER = "yyyy-MM-ddHH:mm";

    public final static String DATETIME_SHORT_PATTERN = "yyyyMMddHHmmss";

    /**
     * 标准年小时分钟格式
     */
    public final static String HOUR_MINUTE = "HH:mm";

    /**
     * 标准年小时分钟秒格式
     */
    public final static String HOUR_MINUTE_SECOND = "HH:mm:ss";

    /**
     * Number of milliseconds in a standard second.
     */
    public static final long MILLIS_PER_SECOND = 1000;

    /**
     * Number of milliseconds in a standard minute.
     */
    public static final long MILLIS_PER_MINUTE = 60 * MILLIS_PER_SECOND;

    /**
     * Number of milliseconds in a standard hour.
     */
    public static final long MILLIS_PER_HOUR = 60 * MILLIS_PER_MINUTE;

    /**
     * Number of milliseconds in a standard day.
     */
    public static final long MILLIS_PER_DAY = 24 * MILLIS_PER_HOUR;

    /**
     * Number of day in a year
     */
    public static final int DAYS_PER_YEAR = 365;

    /**
     * 标准年月格式
     */
    public final static String MONTH_PATTERN = "yyyy-MM";

    private final static String[] WEEK_NAMES = { "星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期天" };

    /**
     * 在指定日期增加指定月数
     *
     * @param date 指定日期
     * @param months 指定月数
     * @return
     */
    public static Date addMonth(Date date, int months) {
        if (months == 0) {
            return date;
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, months);
        return c.getTime();
    }

    /**
     * 在指定日期增加指定天数
     *
     * @param date 指定日期
     * @param days 指定天数
     * @return
     */
    public static Date addDay(Date date, int days) {
        if (days == 0) {
            return date;
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DAY_OF_YEAR, days);
        return c.getTime();
    }

    /**
     * 在指定日期增加指定天数
     *
     * @param date 指定日期
     * @param days 指定天数
     * @return
     */
    public static Date addDay(String date, int days) {
        return addDay(convertDate(date), days);
    }

    public static Date addMinute(Date date, int minute) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MINUTE, minute);
        return c.getTime();
    }

    public static Date addHour(Date date, int hour) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.HOUR, hour);
        return c.getTime();
    }

    /**
     * 当前日期之后
     *
     * @param date
     * @return
     */
    public static boolean afterToday(Object date) {
        Date currentDate = new Date();
        return compareDate(date, currentDate) == 1;
    }

    /**
     * 当前时间之后
     *
     * @param date
     * @return
     */
    public static boolean afterTodayDate(Date date) {
        Date currentDate = new Date();
        return currentDate.compareTo(date) == -1;
    }

    /**
     * 当前日期之前
     *
     * @param date
     * @return
     */
    public static boolean beforeToday(Object date) {
        Date currentDate = new Date();
        return compareDate(date, currentDate) == -1;
    }

    /**
     * 当前时间之前
     *
     * @param date
     * @return
     */
    public static boolean beforeTodayDate(Date date) {
        Date currentDate = new Date();
        return currentDate.compareTo(date) == 1;
    }

    /**
     * 比较两个日期date1大于date2 返回1 等于返回0 小于返回-1
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int compareDate(Object date1, Object date2) {
        if (date1 == null || date2 == null) {
            String msg = "illegal arguments,date1 and date2 must be not null.";
            throw new IllegalArgumentException(msg);
        }
        Date d1 = (Date) (date1 instanceof String ? convertDate((String) date1) : date1);
        Date d2 = (Date) (date2 instanceof String ? convertDate((String) date2) : date2);
        return round(d1, Calendar.DATE).compareTo(round(d2, Calendar.DATE));
    }

    public static long compareDateTime(Object date1, Object date2) {
        if (date1 == null || date2 == null) {
            String msg = "illegal arguments,date1 and date2 must be not null.";
            throw new IllegalArgumentException(msg);
        }
        Date d1 = (Date) (date1 instanceof String ? convertDate((String) date1) : date1);
        Date d2 = (Date) (date2 instanceof String ? convertDate((String) date2) : date2);
        return d1.getTime() - d2.getTime();
    }

    public static Date convertDate(Date date, String pattern) {
        if (StringUtils.isBlank(pattern)) {
            String msg = "the date or pattern is empty.";
            throw new IllegalArgumentException(msg);
        }
        String dateForPattern = formatDate(date, pattern);
        return convertDate(dateForPattern, pattern);
    }

    /**
     * 将long型整数转化为时间。
     *
     * @param date 时间对应的long值
     * @return 时间对象
     */
    public static Date convertDate(Long date) {
        return new Date(date);
    }

    /**
     * 将日期或者时间戳转化为日期对象
     *
     * @param date yyyy-MM-dd or yyyy-MM-dd HH:mm:ss or yyyy-MM-dd HH:mm:ss.SSS
     * @return
     */
    public static Date convertDate(String date) {
        if (StringUtils.isBlank(date)) {
            return null;
        }
        if (StringUtils.isNumeric(date)) {
            long timestamp = Long.parseLong(date);
            if (timestamp > 0 && timestamp < Long.MAX_VALUE) {
                return new Date(timestamp);
            } else {
                return null;
            }
        }
        if (date.indexOf(":") > 0) {
            return convertDate(date, DATETIME_PATTERN);
        } else if (date.indexOf(".") > 0) {
            return convertDate(date, DATETIME_MILL_SECOND);
        } else {
            return convertDate(date, DATE_PATTERN);
        }
    }

    /**
     * 将日期或者时间字符串转化为日期对象
     *
     * @param date 日期字符串
     * @param pattern 格式字符串</br> yyyy-MM-DD, yyyy/MM/DD, yyyyMMdd</br> yyyy-MM-dd-HH:mm:ss, yyyy-MM-dd HH:mm:ss
     *            格式字符串可选字符："GyMdkHmsSEDFwWahKzZ"
     * @return Date
     */
    public static Date convertDate(String date, String pattern) {
        try {
            if (StringUtils.isEmpty(pattern) || StringUtils.isEmpty(date)) {
                String msg = "the date or pattern is empty.";
                throw new IllegalArgumentException(msg);
            }
            SimpleDateFormat df = new SimpleDateFormat(pattern.trim());
            return df.parse(date.trim());
        } catch (Exception e) {
            logger.error("Method===convertDate error!", e);
            return null;
        }
    }

    /**
     * 将时间字符串转化为时间对象Time
     *
     * @param time 时间字符串
     * @param pattern 格式字符串 yyyy-MM-dd HH:mm:ss or yyyy-MM-dd HH:mm:ss.SSS
     * @return
     */
    public static Time convertTime(String time, String pattern) {
        if ("24:00:00".equals(time)) {
            time = "23:59:59";
        }
        Date d = convertDate(time, pattern);
        return new Time(d.getTime());
    }

    /**
     * 获得日期相差天数
     *
     * @param date1 日期
     * @param date2 日期
     * @return
     */
    public static int diffDate(Date date1, Date date2) {
        return (int) ((date1.getTime() - date2.getTime()) / MILLIS_PER_DAY);
    }

    /**
     * 获取两个日期相差的分钟数
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int diffMinute(Date date1, Date date2) {
        return (int) ((date1.getTime() - date2.getTime()) / MILLIS_PER_MINUTE);
    }

    public static long diffSeconds(Date date1, Date date2) {
        return ((date1.getTime() - date2.getTime()) / MILLIS_PER_SECOND);
    }

    /**
     * 格式为时间字符串
     *
     * @param date 日期
     * @return yyyy-MM-dd Date
     */
    public static String formatDate(Date date) {
        try {
            return formatDate(date, DATE_PATTERN);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 按指定格式字符串格式时间
     *
     * @param date 日期或者时间
     * @param pattern 格式化字符串 yyyy-MM-dd， yyyy-MM-dd HH:mm:ss, yyyy年MM月dd日 etc.</br>
     * @return
     */
    public static String formatDate(Date date, String pattern) {
        if (null == date || StringUtils.isBlank(pattern)) {
            return null;
        }
        SimpleDateFormat format = new SimpleDateFormat(pattern.trim());
        return format.format(date);
    }

    /**
     * 格式为时间戳字符串
     *
     * @param date 时间
     * @return yyyy-MM-dd HH:mm:ss Date
     */
    public static String formatDateTime(Date date) {
        try {
            return formatDate(date, DATETIME_PATTERN);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 将制定时间格式为字符串'yyyyMMddHHmmss'.
     *
     * @return
     */
    public static String formatDateToYMDHMS(Date date) {
        return formatDate(date, DATETIME_SHORT_PATTERN);
    }

    public static String formatMonth(Date date) {
        return formatDate(date, MONTH_PATTERN);
    }

    /**
     * 将当前时间格式为字符串'yyyyMMddHHmmss'.
     *
     * @return
     */
    public static String formatNowToYMDHMS() {
        return formatDateToYMDHMS(new Date());
    }

    public static Timestamp getCurrentTimestamp() {
        return new Timestamp(new Date().getTime());
    }

    public static Date getDateFromShortString(String str) {
        SimpleDateFormat simpleDF = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return simpleDF.parse(str);
        } catch (ParseException e) {
            logger.warn("parse date error", e);
        }
        return null;
    }

    /**
     * 获得本周第一天
     *
     * @param date
     * @return
     */
    public static Date getFirstDayOfThisWeek(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return cal.getTime();
    }

    /**
     * 获得小时
     *
     * @param date
     * @return
     */
    public static int getHourOfDay(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.HOUR_OF_DAY);
    }

    public static Date getLastMonth() {
        Calendar c = Calendar.getInstance();
        int month = c.get(Calendar.MONTH);
        c.set(Calendar.MONTH, month - 1);
        return c.getTime();
    }

    /**
     * 获得分钟数
     *
     * @param date
     * @return
     */
    public static int getMinute(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.MINUTE);
    }

    /**
     * 获取后续第n天日期
     *
     * @param date
     * @param n 第n天
     * @return
     */
    public static Date getNextNDay(Date date, int n) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, n);
        return cal.getTime();
    }

    /**
     * 获得星期数
     *
     * @param date 日期
     * @return
     */
    public static int getWeekNumber(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int number = c.get(Calendar.DAY_OF_WEEK) - 1;
        if (number == 0) {
            number = 7;
        }
        return number;
    }

    /**
     * 获得星期名称
     *
     * @param date
     * @return
     */
    public static String getWeekNumberString(Date date) {
        int dayNum = getWeekNumber(date);
        return WEEK_NAMES[dayNum - 1];
    }

    /**
     * 是否同一天
     *
     * @param date1
     * @param date2
     * @return
     */
    public static boolean isSameDay(Object date1, Object date2) {
        return compareDate(date1, date2) == 0;
    }

    /**
     * 检查时间或者字符串是否合法
     *
     * @param date 时间
     * @param pattern 格式串
     * @return
     */
    public static boolean isValidDate(String date, String pattern) {
        try {
            convertDate(pattern, date);
            return true;
        } catch (Exception e) {
            logger.error("Method===isValidDate error!", e);
            return false;
        }
    }

    /**
     * 获得当前时间
     *
     * @return Timestamp
     */
    public static Date now() {
        return new Date();
    }

    /**
     * 获得当前时间戳
     *
     * @return Timestamp
     */
    public static Timestamp nowTimestamp() {
        return new Timestamp(new Date().getTime());
    }

    /**
     * 获得当前时间字符串,格式为：yyyy-MM-dd HH:mm:ss
     *
     * @return
     */
    public static String nowDateTime() {
        return formatDate(new Date(), DATETIME_PATTERN);
    }

    /**
     * 按指定roundType格式化日期。
     *
     * @param date 日期
     * @param roundType
     * @return Date
     */
    public static Date round(Date date, int roundType) {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(date.getTime());
        switch (roundType) {
        case Calendar.MONTH:
            c.set(Calendar.DAY_OF_MONTH, 1);
        case Calendar.DATE:
            c.set(Calendar.HOUR_OF_DAY, 0);
        case Calendar.HOUR:
            c.set(Calendar.MINUTE, 0);
        case Calendar.MINUTE:
            c.set(Calendar.SECOND, 0);
        case Calendar.SECOND:
            c.set(Calendar.MILLISECOND, 0);
            return c.getTime();
        default:
            throw new IllegalArgumentException("invalid round roundType.");
        }
    }

    /**
     * 获得当前日期对象
     *
     * @return
     */
    public static Date today() {
        return convertDate(formatDate(new Date()), DATE_PATTERN);
    }

    /**
     * 获得当前日期字符串,格式为：yyyy-MM-dd
     *
     * @return
     */
    public static String todayDate() {
        return formatDate(new Date());
    }

    /**
     *
     * 将日期或者时间字符串转化为Timestamp对象
     *
     * @param date 日期字符串
     * @param pattern 格式字符串</br> yyyy-MM-DD, yyyy/MM/DD, yyyyMMdd</br> yyyy-MM-dd-HH:mm:ss, yyyy-MM-dd HH:mm:ss
     * @return Timestamp
     * @author reeboo
     */
    public static Timestamp toTimestamp(String date, String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern.trim());
        try {
            return new Timestamp(format.parse(date).getTime());
        } catch (ParseException e) {
        }
        return null;
    }

    public static Date getFirstDateOfCurrentMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    public static Date setDateTime(Date date, Date time) {
        return new DateTime(date).withMillisOfDay(new DateTime(time).getMillisOfDay()).toDate();
    }

    public static Date getFirstDateFromDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 判断当前时间是否在某个区间内
     * 
     * @param startDate
     * @param endDate
     * @return
     */
    public static boolean todayInClose(Date startDate, Date endDate) {
        Date currentDate = convertDate(new Date(), DATE_PATTERN);
        return currentDate.getTime() >= startDate.getTime() && currentDate.getTime() <= endDate.getTime();
    }

    /**
     * 判断某个时间是否在对应的时间段内
     * 
     * @param startDate
     * @param endDate
     * @param time
     * @return
     */
    public final static boolean timeInClose(Date startDate, Date endDate, Date time) {
        return time.getTime() >= startDate.getTime() && time.getTime() <= endDate.getTime();
    }

    // 时间转换成毫秒,空返回-1
    public static Long getTime(Date date) {
        if (null == date) {
            return null;
        }
        return date.getTime();
    }

    /**
     * 判断两个时间区间是否有交集
     * 
     * @param closeOneStartDate
     * @param closeOneEndDate
     * @param closeTwoStartDate
     * @param closeTwoEndDate
     * @return
     */
    public static boolean timeIntersection(Date closeOneStartDate, Date closeOneEndDate, Date closeTwoStartDate,
                                           Date closeTwoEndDate) {
        long start = Math.max(closeOneStartDate.getTime(), closeTwoStartDate.getTime());
        long end = Math.min(closeOneEndDate.getTime(), closeTwoEndDate.getTime());
        return start <= end;
    }

    /**
     * 计算两个日期之间的自然日
     * @param smdate
     * @param bdate
     * @return
     * @throws ParseException
     */
    public static int daysBetween(Date smdate, Date bdate){
        int days = 0;
        try{
            final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            smdate = sdf.parse(sdf.format(smdate));
            bdate = sdf.parse(sdf.format(bdate));
            final Calendar cal = Calendar.getInstance();
            cal.setTime(smdate);
            final long time1 = cal.getTimeInMillis();
            cal.setTime(bdate);
            final long time2 = cal.getTimeInMillis();
            final long between_days = (time2 - time1) / (1000 * 3600 * 24);
            days = Integer.parseInt(String.valueOf(between_days));
        } catch (Exception e){
            logger.error("日期格式错误", e);
        }

        return days;
    }

    /**
     * 根据多点传过来的履约时间格式来得到履约开始时间及结束日期
     * 06-24 14:30-19:30
     *
     * @return
     * @throws ParseException
     */
    public static Map<String, Date> shipMentTime(String shipmentTime){
        Map<String, Date> dateMap =  new HashMap<String, Date>();
        try{
            String startTime = "";
            String endTime = "";
            if(shipmentTime.length() < 18){
                // 06-24 14:30-19:30
                String year = DateUtils.format(new Date(), DateUtils.YYYY);
                String date = year + "-" + shipmentTime.substring(0, 5);

                String[] shipTimeArr = shipmentTime.substring(6).split("-");
                startTime = date + " "  + shipTimeArr[0].trim();
                endTime = date  + " "  +  shipTimeArr[1].trim();
            } else {
                // 2018-04-11 15:30-18:30
                String[] shipTimeArr = shipmentTime.split(" ");
                String date = shipTimeArr[0];
                String time = shipTimeArr[1];
                String[] timeArr = time.split("-");

                startTime = date + " "  + timeArr[0].trim();
                endTime = date  + " "  +  timeArr[1].trim();
            }

            logger.info("履约开始时间:{} 履约结束时间 {}", startTime, endTime);

            Date d_startTime = DateUtils.convertDate(startTime, DateUtils.DATETIME_PATTERN_SHORT);
            Date d_endTime = DateUtils.convertDate(endTime, DateUtils.DATETIME_PATTERN_SHORT);
            dateMap.put("startTime", d_startTime);
            dateMap.put("endTime", d_endTime);
            
        } catch (Exception e){
            logger.error("日期格式错误", e);
        }
        return dateMap;
    }


    /**
     * 判断当前时间时间点范围
     *
     * @param time
     * @return
     * @throws ParseException
     */
    public static boolean checkBetweenTimes(String time){
        try{
            String[] timeSpan = time.split("-");
            String startTime = timeSpan[0];
            String endTime = timeSpan[1];

            String curHHmm = format(new Date(), HOUR_MINUTE);
            return curHHmm.compareTo(startTime) > 0 && curHHmm.compareTo(endTime) < 0;
        } catch (Exception e){
            logger.error("日期格式错误", e);
        }
        return false;
    }

    /**
     * 取得当天零点零分零秒
     *
     * @return Date
     */
    public static Date getZeroTimeOfDay(){
        return convertDate(DateFormatUtils.format(new Date(), "yyyy-MM-dd 00:00:00"));
    }

    /**
     * 取得当天23点59分59秒
     *
     * @return Date
     */
    public static Date getMaxTimeOfDay(){
        return  convertDate(DateFormatUtils.format(new Date(), "yyyy-MM-dd 23:59:59"));
    }

    /**
     *
     * @param args
     */
    public static void  main(String[] args){
         String shipTime = "06-24 14:30-19:30";
        shipMentTime(shipTime);
        shipTime = "2018-04-11 15:30-18:30";
        shipMentTime(shipTime);
    }
}
