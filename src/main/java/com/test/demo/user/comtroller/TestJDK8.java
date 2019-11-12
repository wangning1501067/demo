package com.test.demo.user.comtroller;

import com.alibaba.fastjson.JSONArray;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestJDK8 {
    public static void main(String[] args) {
        //List遍历
        List<String> list = Lists.newArrayList();
        list.add("php");
        list.add("java");
        list.add("python");
        list.stream().forEach(string ->{
            System.out.println(string);
        });
        System.out.println("======================================");
        list.forEach(System.out::println);
        System.out.println("======================================");
        //Map遍历
        Map<String, Integer> items = Maps.newHashMap();
        items.put("java", 10);
        items.put("php", 20);
        items.put("python", 30);
        items.put("D", 40);
        items.put("E", 50);
        items.put("F", 60);
        items.forEach((k,v)->System.out.println("Item=1 : " + k + " Count : " + v));
        System.out.println("======================================");
        items.forEach((k,v)-> {
            System.out.println("Item=2 : " + k + " Count : " + v);
        });
        System.out.println("======================================");

        //组合起来复杂些，List<Map>
        /*String str = "123sdf12ergsd";
        List<Map> mapList = JSONArray.parseArray(str,Map.class);
        mapList.forEach(map1 -> { map1.forEach((k,v) -> { System.out.println(v); }); });*/

        List<Apple> appleList = Lists.newArrayList();//存放apple对象集合
        Apple apple1 =  new Apple(1,"苹果1",new BigDecimal("3.25"),10);
        Apple apple12 = new Apple(1,"苹果2",new BigDecimal("1.35"),20);
        Apple apple2 =  new Apple(2,"香蕉",new BigDecimal("2.89"),30);
        Apple apple3 =  new Apple(3,"荔枝",new BigDecimal("9.99"),40);
        appleList.add(apple1);
        appleList.add(apple12);
        appleList.add(apple2);
        appleList.add(apple3);
        /**
         * List -> Map
         * 需要注意的是：
         * toMap 如果集合对象有重复的key，会报错Duplicate key ....
         *  apple1,apple12的id都为1。
         *  可以用 (k1,k2)->k1 来设置，如果有重复的key,则保留key1,舍弃key2
         */
        Map<Integer, Apple> appleMap = appleList.stream().collect(Collectors.toMap(Apple::getId, a -> a,(k1, k2)->k1));
        System.out.println("==appleMap=="+appleMap.toString());
        System.out.println("======================================");

        //List 以ID分组 Map<Integer,List<Apple>>
        Map<Integer, List<Apple>> groupBy = appleList.stream().collect(Collectors.groupingBy(Apple::getId));
        System.err.println("groupBy:"+groupBy);
        System.out.println("======================================");

        //过滤出符合条件的数据
        List<Apple> filterList = appleList.stream().filter(a -> a.getName().equals("香蕉")).collect(Collectors.toList());
        System.err.println("filterList:"+filterList);
        System.out.println("======================================");

        //计算 总金额
        BigDecimal totalMoney = appleList.stream().map(Apple::getMoney).reduce(BigDecimal.ZERO, BigDecimal::add);
        System.err.println("totalMoney:"+totalMoney);  //totalMoney:17.48
        System.out.println("======================================");

        //计算 数量
        int sum = appleList.stream().mapToInt(Apple::getNum).sum();
        System.err.println("sum:"+sum);  //sum:100
        System.out.println("======================================");

        //List根据ID转MAP
        List<Apple> appleList2 = Lists.newArrayList();//存放apple对象集合
        appleList2.add(apple1);
        appleList2.add(apple2);
        appleList2.add(apple3);
        Map<Integer, Apple> map2 = appleList2.stream().collect(Collectors.toMap(Apple::getId, apple -> apple));
        System.out.println("==map2=="+map2.toString());
        System.out.println("======================================");

        //对数字进行排序
        List<Integer> nums = Arrays.asList(3,1,5,2,9,8,4,10,6,7);
        nums.sort(Comparator.reverseOrder()); //reverseOrder倒序
        System.err.println("倒序:"+nums);
        nums.sort(Comparator.naturalOrder()); //naturalOrder自然排序即：正序
        System.err.println("正序:"+nums);

    }
}

@Data
class Apple {
    private Integer id;
    private String name;
    private BigDecimal money;
    private Integer num;
    public Apple(Integer id, String name, BigDecimal money, Integer num) {
        this.id = id;
        this.name = name;
        this.money = money;
        this.num = num;
    }
}