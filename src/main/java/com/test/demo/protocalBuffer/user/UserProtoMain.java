package com.test.demo.protocalBuffer.user;

import com.google.protobuf.InvalidProtocolBufferException;

import java.util.Arrays;

public class UserProtoMain {

    public static void main(String[] args) {
        UserProtoBuf.User.Builder builder = UserProtoBuf.User.newBuilder();
        builder.setId(1);
        builder.setName("protoc-java");
        builder.setAge(18);
        builder.setMobile("15011186302");
        UserProtoBuf.User user = builder.build();
        System.out.println(user.toString());
        System.out.println(user.toByteArray());
        System.out.println(Arrays.toString(user.toByteArray()));

        //反序列化
        UserProtoBuf.User person1 = null;
        try {
            person1 = UserProtoBuf.User.parseFrom(user.toByteArray());
            //System.out.println(JSON.toJSONString(person1));
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
        //;
    }
}


