package com.test.demo.user.test;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.Data;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        System.out.println("======================================");

        //根据价格排序
        System.out.println("==appleList=="+appleList);
        List<Apple> breakDownVoList = appleList.stream().sorted(Comparator.comparing(Apple::getMoney)).collect(Collectors.toList());
        System.out.println("==breakDownVoList=="+breakDownVoList);
        List<Apple> breakDownVoList2 = appleList.stream().sorted(Comparator.comparing(Apple::getMoney).reversed()).collect(Collectors.toList());
        System.out.println("==breakDownVoList2=="+breakDownVoList2);
        System.out.println("======================================");

        Arrays.asList( "a", "b", "d" ).forEach( e -> {
            System.out.print( e );
        });
        System.out.println("======================================");
        String separator = ",";
        Arrays.asList( "a", "b", "d" ).forEach(
                ( String e ) -> System.out.print( e + separator ) );
        System.out.println("======================================");
        /**
         * 筛选与切片
         *         filter：过滤流中的某些元素
         *         limit(n)：获取n个元素
         *         skip(n)：跳过n元素，配合limit(n)可实现分页
         *         distinct：通过流中元素的 hashCode() 和 equals() 去除重复元素
         */
        Stream<Integer> stream = Stream.of(6, 4, 6, 7, 3, 9, 8, 10, 12, 14, 14);
        Stream<Integer> newStream = stream.filter(s -> s > 5) //6 6 7 9 8 10 12 14 14
                .distinct() //6 7 9 8 10 12 14
                .skip(2) //9 8 10 12 14
                .limit(2); //9 8
        newStream.forEach(System.out::println);
        System.out.println("======================================");

        /**
         * 映射
         *         map：接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
         *         flatMap：接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流。
         */
        List<String> list2 = Arrays.asList("a,b,c", "1,2,3");
        //将每个元素转成一个新的且不带逗号的元素
        Stream<String> s1 = list2.stream().map(s -> s.replaceAll(",", ""));
        s1.forEach(System.out::println); // abc  123

        Stream<String> s3 = list2.stream().flatMap(s -> {
            //将每个元素转换成一个stream
            String[] split = s.split(",");
            Stream<String> s2 = Arrays.stream(split);
            return s2;
        });
        s3.forEach(System.out::println); // a b c 1 2 3
        System.out.println("======================================");

        /**
         * 排序
         *         sorted()：自然排序，流中元素需实现Comparable接口
         *         sorted(Comparator com)：定制排序，自定义Comparator排序器
         */
        List<String> list3 = Arrays.asList("aa", "ff", "dd");
        //String 类自身已实现Compareable接口
        list3.stream().sorted().forEach(System.out::println);// aa dd ff

        Student st1 = new Student("aa", 10);
        Student st2 = new Student("bb", 20);
        Student st3 = new Student("aa", 30);
        Student st4 = new Student("dd", 40);
        List<Student> studentList = Arrays.asList(st1, st2, st3, st4);
//自定义排序：先按姓名升序，姓名相同则按年龄升序
        studentList.stream().sorted(
                (o1, o2) -> {
                    if (o1.getName().equals(o2.getName())) {
                        return o1.getAge() - o2.getAge();
                    } else {
                        return o1.getName().compareTo(o2.getName());
                    }
                }
        ).forEach(System.out::println);
        System.out.println("======================================");
        //自定义排序：先按姓名升序，姓名相同则按年龄升序
        List<Student> studentList2 = studentList.stream().sorted(Comparator.comparing(Student::getName).thenComparing(Student::getAge).reversed()).collect(Collectors.toList());
        System.out.println("==studentList2=="+studentList2);
        System.out.println("======================================");

        /**
         * 消费
         *         peek：如同于map，能得到流中的每一个元素。但map接收的是一个Function表达式，有返回值；而peek接收的是Consumer表达式，没有返回值。
         */
        Student stu1 = new Student("aa", 10);
        Student stu2 = new Student("bb", 20);
        List<Student> studentList3 = Arrays.asList(stu1, stu2);
        studentList3.stream()
                .peek(o -> o.setAge(100))
                .forEach(System.out::println);
        System.out.println("======================================");

        /**
         * 匹配、聚合操作
         *         allMatch：接收一个 Predicate 函数，当流中每个元素都符合该断言时才返回true，否则返回false
         *         noneMatch：接收一个 Predicate 函数，当流中每个元素都不符合该断言时才返回true，否则返回false
         *         anyMatch：接收一个 Predicate 函数，只要流中有一个元素满足该断言则返回true，否则返回false
         *         findFirst：返回流中第一个元素
         *         findAny：返回流中的任意元素
         *         count：返回流中元素的总个数
         *         max：返回流中元素最大值
         *         min：返回流中元素最小值
         */
        //求和
        List<Integer> primes = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        IntSummaryStatistics stats = primes.stream().mapToInt(x->x).summaryStatistics();
        System.out.println("max : " + stats.getMax());
        System.out.println("min : " + stats.getMin());
        System.out.println("sum : " + stats.getSum());
        System.out.println("average : " + stats.getAverage());

        IntSummaryStatistics ageSummary = studentList.stream().collect(Collectors.summarizingInt(student -> student.getAge()));
        System.out.println("==ageSummary=="+ageSummary);
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

@Data
class Student {
    private String name;
    private Integer age;
    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}