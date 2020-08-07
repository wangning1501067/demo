package com.test.demo.xuliehua;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.*;

public class SerializeUtil {

    // 序列化
    public static byte[] serialize(Object object) {

        ObjectOutputStream oos = null;
        ByteArrayOutputStream baos = null;
        byte[] bytes = null;
        try {
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(object);
            bytes = baos.toByteArray();
        } catch (Exception e) {
            System.err.println("序列化失败" + e.getMessage());
        }
        return bytes;
    }

    // 反序列化
    public static Object deserialize(byte[] bytes) throws IOException, ClassNotFoundException {

        ByteArrayInputStream bais = null;
        ObjectInputStream ois = null;
        try {
            bais = new ByteArrayInputStream(bytes);
            ois = new ObjectInputStream(bais);
        } catch (Exception e) {
            System.err.println("反序列化失败" + e.getMessage());
        }
        return ois.readObject();
    }

    /*public static void main(String[] args) {
        User user=new User("1000", "宝宝", "xioabao");
        jedis.set(user.getId().getBytes(), SerializeUtils.serialize(user));
        byte[] bytes=jedis.get(user.getId().getBytes());
        System.out.println((User)SerializeUtils.deSerialize(bytes));
    }*/

    public static void main(String args[]){
        JedisPoolConfig config = new JedisPoolConfig();
        //最大空闲连接数, 默认8个
        config.setMaxIdle(8);
        //最大连接数, 默认8个
        config.setMaxTotal(8);
        //获取连接时的最大等待毫秒数(如果设置为阻塞时BlockWhenExhausted),如果超时就抛异常, 小于零:阻塞不确定的时间,  默认-1
        config.setMaxWaitMillis(1000);
        JedisPool jedisPool = new JedisPool(config, "192.168.23.121", 6379, 10000, "123456", 0);
        Jedis jedis = jedisPool.getResource();
        User user = new User();
        user.setId("1");
        user.setGender("男");
        user.setNickname("cherish");
        user.setPassword("123456");
        user.setUsername("admin");
        jedis.set("user".getBytes(), SerializeUtil.serialize(user));
        jedis.expire("user".getBytes(), 10);
        System.out.println("--------------------------------------------------------------------");
        try {
            User userResult = (User) SerializeUtil.deserialize(jedis.get("user".getBytes()));
            System.out.println(userResult.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
