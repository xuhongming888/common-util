package com.xzh.www.utils;

import org.joda.time.format.DateTimeFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.xzh.www.constants.TimeConstatns.FORMAT_YYYY_MM_DD_HH_MM_SS;

/**
 * @Description: 时间格式转换工具
 * @Author: xuzh1
 * @Date: 2018-09-28 13:34
 **/
public class TimeUtils {


    private TimeUtils(){}

    //获取系统当前时间，精确到s
    public static long getCurrentTime(){
        return System.currentTimeMillis()/1000;
    }

    //将时间格式字符串转换成日期： "2018-09-28 14:00:45"  -->  "Fri Sep 28 14:00:45 CST 2018"
    public static Date parseDate(String str) {
        return DateTimeFormat.forPattern(FORMAT_YYYY_MM_DD_HH_MM_SS).parseDateTime(str).toDate();
    }

    /**
     * 取规定时间段的分钟集合 1分钟一个点
     * @param startDate 开始时间  (格式：2016-09-03 10:58:51)
     * @param endDate 结束时间   (格式：2016-09-03 10:58:51)
     * @param delayTime 延时（分钟）
     * @return 时间戳集合
     */
    public static Set<Long> getOneMinuteTimeStampSet(Date startDate, Date endDate, int delayTime){
        Set<Long> timeSet = new TreeSet<>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(endDate);
        calendar.set(Calendar.SECOND, 0);
        calendar.add(Calendar.MINUTE, delayTime);  //结束时间+延迟时间(分钟)
        Date endTime = calendar.getTime();    //获取日历对象的日期

        calendar.setTime(startDate);
        calendar.set(Calendar.SECOND, 0);
        timeSet.add(calendar.getTime().getTime() / 1000);
        while (calendar.getTime().before(endTime)) {
            calendar.add(Calendar.MINUTE, 1);
            timeSet.add(calendar.getTime().getTime() / 1000);
        }
        return timeSet;
    }

    /**
    * @Description:
    * @Author: xuzh
    * @Date: 2018/9/28
    *
    * @Param timeStamp: 时间戳格式(10位)
    * @Param formatString: 目标时间格式(如： "yy-mm-dd hh-mm-ss")
    */
    public static String timeStampToTimeString(long timeStamp, String timeFormat){
        Date date = new Date(timeStamp * 1000L);
        SimpleDateFormat sdf = new SimpleDateFormat(timeFormat);

        return sdf.format(date);
    }

    public static long timeStringToTimeStamp(String timeString, String timeFormat) {
        SimpleDateFormat sdf = new SimpleDateFormat(timeFormat);
        Date date = null;
        try {
            date = sdf.parse(timeString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date.getTime()/1000;
    }

/******获取过去或者未来 任意天内的日期数组*************/

    /**
     * 获取过去第几天的日期
     *
     * @param past
     * @return
     */
    public static String getPastDate(int past) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - past);
        Date today = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String result = format.format(today);
        return result;
    }


    /**
    **
    * @Description: get midnight of one day in the past
    * @Param: [past, fromat, timeZone]
    * @Author: xuzh1
    * @Date: 2020/7/15
    */
    public static String getMidnigtOfDAY(int past, String timeFromat, String timeZone){
        Calendar calendar = Calendar.getInstance();

        long pastTimestamp = System.currentTimeMillis()/(24*3600*1000) * (24*3600*1000) - (past*24*3600*1000);

        calendar.setTimeInMillis(pastTimestamp);
        Date date = calendar.getTime();

        SimpleDateFormat sdf = new SimpleDateFormat(timeFromat);
        sdf.setTimeZone(TimeZone.getTimeZone(timeZone));

        return sdf.format(date);
    }




    /**
     * 获取未来 第 past 天的日期
     * @param past
     * @return
     */
    public static String getFutureDate(int past) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) + past);
        Date today = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        String result = format.format(today);
//        Log.e(null, result);
        return result;
    }
/*****************************************************************/


    public static void main(String[] args) {
//        System.out.println(getMidnigtOfPastDAY(1, "yyyy-MM-dd'T'HH:mm:ss", "GMT+00"));
        System.out.println(getMidnigtOfDAY(1, "yyyy-MM-dd'T'HH:mm:ss", "GMT+08"));
    }

}
