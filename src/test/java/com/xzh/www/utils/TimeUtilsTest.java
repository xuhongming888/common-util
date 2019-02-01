package com.xzh.www.utils;

import org.junit.Test;

import static com.xzh.www.constants.Constatns.FORMAT_YYYY_MM_DD_HH;
import static com.xzh.www.constants.Constatns.FORMAT_YYYY_MM_DD_HH_MM_SS;

public class TimeUtilsTest {



    @Test
    public void getCurrentTime() {
        System.out.println(TimeUtils.getCurrentTime());
    }

    @Test
    public void parseDate(){
        System.out.println(TimeUtils.parseDate("2018-09-28 14:00:45"));
    }

    @Test
    public void getParseDate(){
        System.out.println(TimeUtils.getPastDate(16));
        System.out.println(TimeUtils.getPastDate(16).substring(0, 7));
    }

    @Test
    public void timeStampToTimeString(){
        System.out.println(TimeUtils.timeStampToTimeString(1538114460, FORMAT_YYYY_MM_DD_HH));
    }

    @Test
    public void timeStringToTimeStamp(){
        System.out.println(TimeUtils.timeStringToTimeStamp("2018-09-28 14:01:00", FORMAT_YYYY_MM_DD_HH_MM_SS));
    }



}