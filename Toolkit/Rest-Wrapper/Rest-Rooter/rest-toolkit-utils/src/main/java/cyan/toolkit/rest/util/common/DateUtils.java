package cyan.toolkit.rest.util.common;


import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * <p>DateUtils</p>
 * @author Cyan (snow22314@outlook.com)
 * @version V.0.0.1
 * @group cyan.tool.kit
 * @date 9:15 2019/12/26
 */
@Slf4j
public class DateUtils {

    private static final ThreadLocal<Map<Integer, Boolean>> DATE_THREAD_LOCAL = new ThreadLocal<>();
    private static final ThreadLocal<Map<String, SimpleDateFormat>> DATE_FORMAT_THREAD_LOCAL = new ThreadLocal<>();
    private static final Pattern date_ptrn1 = Pattern.compile("^\\[\\$\\-.*?\\]");
    private static final Pattern date_ptrn2 = Pattern.compile("^\\[[a-zA-Z]+\\]");
    private static final Pattern date_ptrn3a = Pattern.compile("[yYmMdDhHsS]");
    private static final Pattern date_ptrn3b = Pattern.compile("^[\\[\\]yYmMdDhHsS\\-T/年月日,. :\"\\\\]+0*[ampAMP/]*$");
    private static final Pattern date_ptrn4 = Pattern.compile("^\\[([hH]+|[mM]+|[sS]+)\\]");
    private static final Pattern date_ptrn5 = Pattern.compile("^\\[DBNum(1|2|3)\\]");
    private static final Pattern date_ptrn6 = Pattern.compile("(年|月|日|时|分|秒)+");
    public static final String DATE_FORMAT_10 = "yyyy-MM-dd";
    public static final String DATE_FORMAT_14 = "yyyyMMddHHmmss";
    public static final String DATE_FORMAT_17 = "yyyyMMdd HH:mm:ss";
    public static final String DATE_FORMAT_19 = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_FORMAT_19_FORWARD_SLASH = "yyyy/MM/dd HH:mm:ss";
    private static final String MINUS = "-";

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
        return format(date, DATE_FORMAT_10);
    }

    /**
     * 格式化时间 如：yyyy-MM-dd HH:mm:ss
     * @param datetime 日期时间
     * @return String 时间字符串
     */
    public static String formatTime(Date datetime) {
        return format(datetime, DATE_FORMAT_19);
    }

    /**
     * 格式化日期时间
     * @param date 日期时间
     * @param dateFormat 格式化字符串
     * @return String 格式结果
     */
    public static String format(Date date, String dateFormat) {
        return getCacheDateFormat(dateFormat).format(date);
    }

    /**
     * 解析日期 如：yyyy-MM-dd
     * @param dateString 日期字符串
     * @return Date 日期
     */
    public static Date parseDate(String dateString){
        return parse(dateString, DATE_FORMAT_10);
    }

    /**
     * 解析时间 如：yyyy-MM-dd HH:mm:ss
     * @param timeString 时间字符串
     * @return Date 时间
     */
    public static Date parseDateTime(String timeString) {
        return parse(timeString, DATE_FORMAT_19);
    }

    /**
     * 解析日期时间
     * @param dateString 日期时间字符串
     * @param dateFormat 格式化字符串
     * @return Date 时间
     */
    public static Date parse(String dateString, String dateFormat) {
        if (StringUtils.isEmpty(dateFormat)) {
            dateFormat = switchDateFormat(dateString);
        }
        try {
            return getCacheDateFormat(dateFormat).parse(dateString);
        } catch (Exception exception) {
            exception.printStackTrace();
            log.error("解析错误！ dateString = {}，pattern = {}，error = {}",dateString,dateFormat,exception.getMessage());
            return null;
        }
    }

    private static String switchDateFormat(String dateString) {
        int length = dateString.length();
        switch(length) {
            case 10:
                return "yyyy-MM-dd";
            case 11:
            case 12:
            case 13:
            case 15:
            case 16:
            case 18:
            default:
                throw new IllegalArgumentException("can not find date format for：" + dateString);
            case 14:
                return "yyyyMMddHHmmss";
            case 17:
                return "yyyyMMdd HH:mm:ss";
            case 19:
                return dateString.contains("-") ? "yyyy-MM-dd HH:mm:ss" : "yyyy/MM/dd HH:mm:ss";
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

    private static DateFormat getCacheDateFormat(String dateFormat) {
        if (GeneralUtils.isEmpty(dateFormat)) {
            throw new IllegalArgumentException("pattern不能为空！");
        }
        Map<String,SimpleDateFormat> dateFormatMap = DATE_FORMAT_THREAD_LOCAL.get();
        SimpleDateFormat dateFormatCached;
        if (dateFormatMap == null) {
            dateFormatMap = new HashMap<>();
            DATE_FORMAT_THREAD_LOCAL.set(dateFormatMap);
        } else {
            dateFormatCached = (SimpleDateFormat)((Map)dateFormatMap).get(dateFormat);
            if (dateFormatCached != null) {
                return dateFormatCached;
            }
        }

        dateFormatCached = new SimpleDateFormat(dateFormat);
        dateFormatMap.put(dateFormat, dateFormatCached);
        return dateFormatCached;
    }

}