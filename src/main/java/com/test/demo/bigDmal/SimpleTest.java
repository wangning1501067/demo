package com.test.demo.bigDmal;

import java.math.BigDecimal;

/**
 * @Description : e
 * @Author : wangningning
 * @Date: 2020/5/29 14:38
 *
 *
 * 避免丢失精度
 *      使用new BigDecimal(String)构造函数，创建一个参数以字符串表示数值的对象
 */
public class SimpleTest {
    public static void main(String[] args) {
        double v1 = 1.8;
        double v2 = 2.6;
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        System.out.println("使用bigDecimal进行转换---》》》》"+b1);
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        System.out.println("使用bigDecimal进行转换---》》》》"+b2);
        BigDecimal b3 = b1.multiply(b2);//此处举例使用乘法（注意：必须使用一个新的BigDecimal来获得运算后的值）
        Double b4 = b3.doubleValue();
        System.out.println(b4);//可直接使用这个值，set、输出都可以（部分步骤可简化）


        double a = 113.880;
        String b = "113.880";
        System.out.println("使用bigDecimal进行转换---》》》》"+new BigDecimal(a));
        // 使用String接收数值
        System.out.println("使用bigDecimal进行转换---》》》》" + new BigDecimal(b));
    }
}