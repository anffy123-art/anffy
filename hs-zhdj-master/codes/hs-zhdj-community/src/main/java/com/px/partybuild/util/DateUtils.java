package com.px.partybuild.util;

import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

@Component
public class DateUtils {

    private ZoneId zone;

    public DateUtils() {
        this.zone = ZoneId.systemDefault();
    }

    public Date DateTimeToDate(LocalDateTime localDateTime) {

        Instant instantDT = localDateTime.atZone(zone).toInstant();
        return Date.from(instantDT);
    }

    public LocalDateTime DateToDateTime(Date date) {

        Instant instantD = date.toInstant();
        return instantD.atZone(zone).toLocalDateTime();
    }

    public Date StrToDate(String strDate, String Pattern) {
        Date result = null;
        if (strDate == null || strDate.length() == 0) {
            return result;
        }
        try {
            return new SimpleDateFormat(Pattern).parse(strDate);
        } catch (ParseException e) {
            return result;
        }
    }

    public Date StrToDate(String strDate) {
        return StrToDate(strDate, "yyyy-MM-dd HH:mm:ss");
    }

    public ZoneId getZoneId() {
        return zone;
    }

    public LocalDate dateToLocalDate(Date date) {
        Instant instantD = date.toInstant();
        return instantD.atZone(zone).toLocalDate();
    }

    /**
     * 获取传入日期加n天
     *
     * @param date 传入日期
     * @param n    天数
     */
    public Date getDateOfAddDay(final Date date, int n) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, n);//增加n天
        return cal.getTime();
    }

    /**
     * 获取传入日期加n月
     *
     * @param date 传入日期
     * @param n    月数
     */
    public Date getDateOfAddMonth(final Date date, int n) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, n);
        return cal.getTime();
    }

    /**
     * 获取传入日期所在月的第一天
     */
    public Date getFirstDayDateOfMonth(final Date date) {
        final Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        final int last = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.DAY_OF_MONTH, last);
        return cal.getTime();
    }

    /**
     * 获取传入日期所在月的最后一天(23:59:59)
     */
    public Date getLastDayOfMonth(final Date date) {
        final Calendar cal = Calendar.getInstance();
        cal.setTime(StrToDate(dateToStrFormat(date, "yyyy-MM-dd") + " 00:00:00"));
        final int last = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.DAY_OF_MONTH, last);
        //在当前月最后一天加1
        cal.add(Calendar.DATE, 1);
        //在当前月的下一月基础上减去1秒
        cal.add(Calendar.SECOND, -1);
        return cal.getTime();
    }

    /**
     * 获取指定日期下个月的第一天
     */
    public Date getFirstDayOfNextMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.MONTH, 1);
        return calendar.getTime();
    }

    /****
     * 传入具体日期 ，返回具体日期增加一个月。
     * @param date 日期(2017-04-13)
     * @return 2017-05-13
     * @throws ParseException
     */
    public Date getNextMonth(Date date) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, 1);
        return calendar.getTime();
    }

    /**
     * 通过Java8 LocalDate计算日期相差天数
     *
     * @param beginDate
     * @param endDate
     * @return
     */
    public long getDayDistance(Date beginDate, Date endDate) {
        LocalDate begin = dateToLocalDate(beginDate);
        LocalDate end = dateToLocalDate(endDate);

        return end.toEpochDay() - begin.toEpochDay();
    }

    /**
     * 获取两个日期相差的月数
     *
     * @param beginDate
     * @param endDate
     * @return
     */
    public int getMonthDiff(Date beginDate, Date endDate) {
        LocalDate begin = dateToLocalDate(beginDate);
        LocalDate end = dateToLocalDate(endDate);
        Period period = Period.between(begin, end);

        int years = period.getYears();
        int months = period.getMonths();

        return (years * 12 + months);
    }

    /**
     * 获取现在时间
     *
     * @return返回字符串格式 yyyy-MM-dd HH:mm:ss
     */
    public String getStringDate() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        return dateString;
    }

    /**
     * 获取现在时间
     *
     * @return 返回短时间字符串格式yyyy-MM-dd
     */
    public String getStringDateShort() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(currentTime);
        return dateString;
    }

    /**
     * 获取时间 小时:分;秒 HH:mm:ss
     *
     * @return
     */
    public String getTimeShort() {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        Date currentTime = new Date();
        String dateString = formatter.format(currentTime);
        return dateString;
    }

    /**
     * 将长时间格式时间转换为字符串 yyyy-MM-dd HH:mm:ss
     *
     * @param dateDate
     * @return
     */
    public String dateToStrLong(java.util.Date dateDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(dateDate);
        return dateString;
    }

    /**
     * 将短时间格式时间转换为字符串 yyyy-MM-dd
     *
     * @param dateDate
     * @param
     * @return
     */
    public String dateToStr(java.util.Date dateDate) {
        if (dateDate == null)
            return "";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(dateDate);
        return dateString;
    }

    /**
     * 获取两个日期相差的小时数
     *
     * @param beginDate
     * @param endDate
     * @return
     */
    public long getHourDiff(Date beginDate, Date endDate) {
        long diff = endDate.getTime() - beginDate.getTime();
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long hour = diff % nd / nh;

        return hour;
    }

    /**
     * 获取两个日期相差的分钟数
     *
     * @param beginDate
     * @param endDate
     * @return
     */
    public long getMinuteDiff(Date beginDate, Date endDate) {
        long diff = endDate.getTime() - beginDate.getTime();
        long min = diff / (1000 * 60);

        return min;
    }

    /**
     * 获取两个日期相差的秒数
     *
     * @param beginDate
     * @param endDate
     * @return
     */
    public long getSecondDiff(Date beginDate, Date endDate) {
        long diff = endDate.getTime() - beginDate.getTime();
        long min = diff / 1000;

        return min;
    }

    /**
     * 将短时间格式时间转换为字符串 yyyy-MM-dd
     *
     * @param dateDate
     * @param
     * @return
     */
    public String dateToStrFormat(java.util.Date dateDate, String format) {
        if (dateDate == null)
            return "";
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        String dateString = formatter.format(dateDate);
        return dateString;
    }


    /**
     * 获得传入时间零分零秒
     *
     * @return
     */
    public Date initDateByDay(Date dateDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateDate);
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    /**
     * @return java.lang.String
     * @Description //TODO yyyy-mm-dd转为yyyymmdd
     * @date 2024-08
     * @Param [value]
     **/
    public String strFormat_short(String value) {
        String date = "";
        try {
            if (value != "" && value != null) {
                if (value.contains("Z")) {
                    value = value.replace("Z", " UTC");
                    date = dateToStrFormat(StrToDate(value, "yyyy-MM-dd'T'HH:mm:ss.SSS Z"), "yyyyMMdd");
                } else if (value.contains("GMT")) {
                    try {
                        value = value.replace("GMT", "").replaceAll("\\(.*\\)", "");
                        SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd yyyy hh:mm:ss", Locale.ENGLISH);
                        date = new SimpleDateFormat("yyyyMMdd").format(format.parse(value));
                    } catch (Exception ex) {
                        return value;
                    }
                } else if (value.contains("CST")) {
                    SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
                    date = new SimpleDateFormat("yyyyMMdd").format(format.parse(value));
                } else {
                    date = dateToStrFormat(StrToDate(value, "yyyy-MM-dd"), "yyyyMMdd");
                }
            }
        } catch (Exception e) {
        }
        return date;
    }

    /**
     * @return java.lang.String
     * @Description //TODO yyyyMMdd转为yyyy-MM-dd
     * @date 2024-08
     * @Param [value]
     **/
    public String strFormat_long(String value) {
        String date = "";
        try {
            if (value != "" && value != null) {
                date = dateToStrFormat(StrToDate(value, "yyyyMMdd"), "yyyy-MM-dd");
            }
        } catch (Exception e) {
        }
        return date;
    }

    public String strFormat(String value) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = format.parse(value);
            return format.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return value;
    }

    public Date strToDateExt(String value) {
        try {
            value = value.trim();
            if (value.contains("-"))
                return StrToDate(value, "yyyy-MM-dd");
            if (value.contains("/"))
                return StrToDate(value, "yyyy/MM/dd");
            if (value.length() == 8)
                return StrToDate(value, "yyyyMMdd");
            if (value.length() == 6)
                return StrToDate(value + "01", "yyyyMMdd");

            return numberToDate(value);
        } catch (Exception e) {
            return null;
        }
    }

    private Date numberToDate(String value) {
        try {
            value = value.trim();
            Date date = StrToDate("1900-01-01", "yyyy-MM-dd");
            int day = Integer.parseInt(value);
            return getDateOfAddDay(date, (day - 2));
        } catch (Exception e) {
            return null;
        }
    }


    public int calculateAgeCorrect(Date d) {
        if (d == null)
            return 0;

        Calendar birthDate = Calendar.getInstance();
        Calendar now = Calendar.getInstance();
        birthDate.setTime(d);
        now.setTime(new Date());

        int age = now.get(Calendar.YEAR) - birthDate.get(Calendar.YEAR);
        if (now.get(Calendar.MONTH) < birthDate.get(Calendar.MONTH) || (now.get(Calendar.MONTH) == birthDate.get(Calendar.MONTH) && now.get(Calendar.DATE) < birthDate.get(Calendar.DATE)))
            age--;

        return age;
    }
}
