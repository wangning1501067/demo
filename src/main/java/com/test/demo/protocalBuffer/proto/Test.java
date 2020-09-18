//package com.test.demo.protocalBuffer.proto;
//
//import com.google.protobuf.InvalidProtocolBufferException;
//
//import java.util.Arrays;
//
//public class Test {
//
//    public static void main(String[] args) throws InvalidProtocolBufferException {
//        //构造器
//        PersonBean.Person.Builder builder = PersonBean.Person.newBuilder();
//        builder.setId(1);
//        builder.setName("王宁");
//        builder.setEmail("417345853@qq.com");
//        builder.addPhone(PersonBean.Person.PhoneNumber.newBuilder().setNumber("13213015289")
//                        .setType(PersonBean.Person.PhoneType.HOME));
//        PersonBean.Person person = builder.build();
//        System.out.println(person.toString());
//        byte[] bytes = person.toByteArray();
//        System.out.println(Arrays.toString(bytes));
//
//        //反序列化
//        PersonBean.Person person1 = PersonBean.Person.parseFrom(bytes);
//        System.out.println(person1.getEmail());
//        //System.out.println(JSON.toJSONString(person1));
//
//    }
//}