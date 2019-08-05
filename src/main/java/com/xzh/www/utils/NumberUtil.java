package com.xzh.www.utils;

import java.math.BigDecimal;
import java.text.NumberFormat;

/**
 * @Description:
 * @Author: xuzh1
 * @Date: 2018-11-03 10:32
 **/
public class NumberUtil {

    //对double类型的number数据进行四舍五入，保留decimal位数字
    public static double round(double number, int decimalCount){
        BigDecimal bigDecimal = new BigDecimal(String.valueOf(number));
        double roundNumber = bigDecimal.setScale(decimalCount, BigDecimal.ROUND_HALF_UP).doubleValue();

        return roundNumber;
    }

    //整数除法器
    public static double divider(long divisor, long dividend, int decimalCount){
        double result = (double)divisor/dividend;
        return round(result, 2);
    }

    /**
    * @Description: 将小数number转换为百分比，decimalCount决定百分比后的小数位数
    * @Author: created by xuzh1 on 2019/8/5
    */
    public static String decimal2Percent(double number, int decimalCount){
        NumberFormat nf = NumberFormat.getPercentInstance();
        nf.setMinimumFractionDigits(decimalCount);
        return nf.format(number);
    }


}
