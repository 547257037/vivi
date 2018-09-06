package com.tiantian.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by zyx on 2017/6/28.
 */
public class BigDecimalUtils {

    public static BigDecimal divide(Long numerator, Long denominator) {
        if (denominator == null || numerator == null || denominator == 0) {//分母校验
            return new BigDecimal(0);
        }
        return new BigDecimal(numerator).divide(new BigDecimal(denominator), 4, BigDecimal.ROUND_HALF_DOWN);
    }

    public static BigDecimal dividePercent(Long numerator, Long denominator) {
        if (denominator == null || numerator == null || denominator == 0) {//分母校验
            return new BigDecimal(0);
        }
        return new BigDecimal(numerator).divide(new BigDecimal(denominator), 6, BigDecimal.ROUND_HALF_DOWN).multiply
                (new BigDecimal(100)).setScale(4, BigDecimal.ROUND_HALF_DOWN);
    }

    public static String dividePercentString(Long numerator, Long denominator) {
        return dividePercent(numerator, denominator) + "%";
    }


    public static BigDecimal add(BigDecimal x, BigDecimal y) {
        return x.add(y).setScale(4, BigDecimal.ROUND_HALF_DOWN);
    }
    public static String getDivDecimals(Integer value1,Integer value2){

        BigDecimal b1 = new BigDecimal(value1);
        BigDecimal b2 = new BigDecimal(value2);
        BigDecimal v = b1.divide(b2,2, RoundingMode.HALF_UP);
        return v.toString();
    }
    public static void main(String[] pp){
        System.out.println(dividePercentString(600L,99990L));

    }

}
