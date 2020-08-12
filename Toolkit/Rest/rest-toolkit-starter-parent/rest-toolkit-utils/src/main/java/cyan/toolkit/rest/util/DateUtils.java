package cyan.toolkit.rest.util;


import lombok.extern.slf4j.Slf4j;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>DateUtils</p>
 * @author liuqingpo(snow22314@outlook.com)
 * @version V.1.0.1
 * @company 苏州中科蓝迪公司所有(c)2016-2021
 * @date created on 上午 11:57 2019-7-16
 */
@Slf4j
public class DateUtils {

    private static final String DATE_FORMAT = "yyyy-MM-dd";

    private static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    private static final ThreadLocal<Map<String, DateFormat>> DATE_FORMAT_THREAD_LOCAL = new ThreadLocal<>();

    /**
     * 格式化 日期 如：yyyy-MM-dd
     * @param date 日期时间
     * @return String 日期字符串
     */
    public static String formatDate(Long date) {
        return formatDate(new Date(date));
    }

    /**
     * 格式化时间 如：yyyy-MM-dd HH:mm:ss
     * @param datetime 日期时间
     * @return String 时间字符串
     */
    public static String formatTime(Long datetime) {
        return formatTime(new Date(datetime));
    }


    /**
     * 格式化 日期 如：yyyy-MM-dd
     * @param date 日期时间
     * @return String 日期字符串
     */
    public static String formatDate(Date date) {
        return format(date, DATE_FORMAT);
    }

    /**
     * 格式化时间 如：yyyy-MM-dd HH:mm:ss
     * @param datetime 日期时间
     * @return String 时间字符串
     */
    public static String formatTime(Date datetime) {
        return format(datetime, DATETIME_FORMAT);
    }

    /**
     * 格式化日期时间
     * @param date 日期时间
     * @param patten 格式化字符串
     * @return String 格式结果
     */
    public static String format(Date date, String patten) {
        return getDateFormat(patten).format(date);
    }

    /**
     * 解析日期 如：yyyy-MM-dd
     * @param dateString 日期字符串
     * @return Date 日期
     */
    public static Date parseDate(String dateString){
        return parse(dateString, DATE_FORMAT);
    }

    /**
     * 解析时间 如：yyyy-MM-dd HH:mm:ss
     * @param timeString 时间字符串
     * @return Date 时间
     */
    public static Date parseDateTime(String timeString) {
        return parse(timeString, DATETIME_FORMAT);
    }

    /**
     * 解析日期时间
     * @param dateString 日期时间字符串
     * @param pattern 格式化字符串
     * @return Date 时间
     */
    public static Date parse(String dateString, String pattern) {
        try {
            return getDateFormat(pattern).parse(dateString);
        } catch (Exception exception) {
            exception.printStackTrace();
            log.error("解析错误！ dateString = {}，pattern = {}，error = {}",exception, dateString,pattern,exception.getMessage());
            return null;
        }
    }

    public static Date today() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public static Date addYears(final Date date, final int amount) {
        return add(date, Calendar.YEAR, amount);
    }

    public static Date addMonths(final Date date, final int amount) {
        return add(date, Calendar.MONTH, amount);
    }

    public static Date addDays(final Date date, final int amount) {
        return add(date, Calendar.DAY_OF_MONTH, amount);
    }

    public static Date addHours(final Date date, final int amount) {
        return add(date, Calendar.HOUR_OF_DAY, amount);
    }

    public static Date addMinutes(final Date date, final int amount) {
        return add(date, Calendar.MINUTE, amount);
    }

    private static Date add(final Date date, final int calendarField, final int amount) {
        if (date == null) {
            return null;
        }
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(calendarField, amount);
        return calendar.getTime();
    }

    private static DateFormat getDateFormat(String pattern) {
        if (EmptyUtils.isEmpty(pattern)) {
            throw new IllegalArgumentException("pattern不能为空！");
        }
        Map<String, DateFormat> dateFormatMap = DATE_FORMAT_THREAD_LOCAL.get();
        if(dateFormatMap!=null && dateFormatMap.containsKey(pattern)){
            return dateFormatMap.get(pattern);
        }
        synchronized (DATE_FORMAT_THREAD_LOCAL) {
            if (dateFormatMap == null) {
                dateFormatMap = new HashMap<>();
            }
            dateFormatMap.put(pattern, new SimpleDateFormat(pattern));
            DATE_FORMAT_THREAD_LOCAL.set(dateFormatMap);
        }

        return dateFormatMap.get(pattern);
    }

}