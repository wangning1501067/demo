package com.test.demo.user.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * ${DESCRIPTION}.
 *
 * @date: 2020-01-02
 * @version: 1.0
 * @author: zhangquanshuo@beyondsoft.com
 */
public class DoubleUtil {
    public static void main(String[] args) {
        String value="1.98765";
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println(df.format(Double.valueOf(value)));

//        DoubleUtil dt = new DoubleUtil();
//        dt.fun1();
//        dt.fun2();
//        dt.fun3();
//        dt.fun4();

    }
        //保留两位小数第三位如果大于4会进一位（四舍五入）
        double f = 6.23556;

        /**
         * 使用精确小数BigDecimal
         */
        public void fun1() {
            BigDecimal bg = new BigDecimal(f);
            /**
             * 参数：
             newScale - 要返回的 BigDecimal 值的标度。
             roundingMode - 要应用的舍入模式。
             返回：
             一个 BigDecimal，其标度为指定值，其非标度值可以通过此 BigDecimal 的非标度值乘以或除以十的适当次幂来确定。
             */
            double f1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            System.out.println(f1);
        }

        /**
         * DecimalFormat转换最简便
         */
        public void fun2() {
            DecimalFormat df = new DecimalFormat("#.00");
            System.out.println(df.format(f));
        }

        /**
         * String.format打印最简便
         */
        public void fun3() {
            System.out.println(String.format("%.2f", f));
        }

        /**
         * 使用NumberFormat
         */
        public void fun4() {
            NumberFormat nf = NumberFormat.getNumberInstance();
            /**
             * setMaximumFractionDigits(int newValue)
             设置数的小数部分所允许的最大位数。
             */
            nf.setMaximumFractionDigits(2);
            System.out.println(nf.format(f));
        }



}
