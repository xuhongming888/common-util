package com.xzh.www.utils;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Description: Java Calendar Api接口习
 * @Author: xuzh1
 * @Date: 2018-09-28 14:24
 *
 * 使用总结
 * (1)Calendar设定月份都是加1
 *
 *
 *参考博客
 * (1)关于时间，日期，星期，月份的算法（Java中Calendar的使用方法）
 * https://blog.csdn.net/xiaoyuan511/article/details/38109237
 *
 **/
public class CalendarUtilTest {

    //add(int field, int amount) 根据日历的规则，为给定的日历字段添加或减去指定的时间量
    //set(int field, int value) 将给定的日历字段设置为给定值。
    @Test
    public void add(){
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal=Calendar.getInstance();  //实例化日历对象
        cal.set(Calendar.YEAR, 2006);
        cal.set(Calendar.MONTH, 8);    //实际月份会比设定的月份加1
        cal.set(Calendar.DAY_OF_MONTH, 3);
        cal.add(Calendar.DATE, -4);
        Date date=cal.getTime();
        System.out.println(df.format(date));
        cal.add(Calendar.DATE, 4);
        date=cal.getTime();
        System.out.println(df.format(date));
    }

    @Test
    public void add2(){
        Calendar cal=Calendar.getInstance();  //实例化日历对象
        cal.set(Calendar.YEAR, 2016);
        cal.set(Calendar.MONTH, 8);    //实际月份会比设定的月份加1
        cal.set(Calendar.DAY_OF_MONTH, 3);
        cal.set(Calendar.HOUR_OF_DAY, 22);
        cal.set(Calendar.MINUTE, 58);
        cal.add(Calendar.MINUTE, 6);
        Date date=cal.getTime();
        System.out.println(date);
    }

    //Date.before()测试
    @Test
    public void dateBefore(){
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Calendar cal=Calendar.getInstance();  //实例化日历对象
        cal.set(Calendar.YEAR, 2016);
        cal.set(Calendar.MONTH, 8);    //实际月份会比设定的月份加1
        cal.set(Calendar.DAY_OF_MONTH, 3);
        cal.set(Calendar.HOUR_OF_DAY, 22);
        cal.set(Calendar.MINUTE, 58);

        Date startDate = cal.getTime();

        cal.set(Calendar.MINUTE, 57);
        Date endDate1 = cal.getTime();

        cal.set(Calendar.MINUTE, 59);
        Date endDate2 = cal.getTime();


        System.out.println("startDate : " + df.format(startDate) + "; endDate1: " + df.format(endDate1) + "; endDate2: " + df.format(endDate2));
        System.out.println("endDat1 < startDate : " + endDate1.before(startDate) + ";  startDate < endDate2: " + startDate.before(endDate2));


    }

}
