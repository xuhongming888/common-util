package com.xzh.www.utils;

import java.math.BigDecimal;

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

    //四舍五入都将永久保留2位小数
    public static String round2(Double number, int decimalCount) {
        if (number != null){
            BigDecimal bigDecimal = new BigDecimal(number).setScale(decimalCount, BigDecimal.ROUND_HALF_UP);
            String result = "0";
            if (bigDecimal.doubleValue() != 0) {
                result = String.format("%.2f", bigDecimal.doubleValue());
            }
            return result;
        }
        return "0";
    }



    //除法器
    public static double divider(long divisor, long dividend, int decimalCount){
        double result = (double)divisor/dividend;
        return round(result, 2);
    }

    public static double divider(double divisor, long dividend, int decimalCount){
        double result = (double)divisor/dividend;
        return round(result, 2);
    }

}
