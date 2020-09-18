package com.test.demo.xuliehua;

import java.io.*;
import java.util.Arrays;

public class Test2 {
    public static void main(String[] args) {
        //序列化
        byte[] bytes = null;
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(out);
            User student1 = new User("1", "王宁", "123456", "宁爷", "111");
            oos.writeObject(student1);
            bytes = out.toByteArray();
            System.out.println(Arrays.toString(bytes));
        } catch (IOException e) {
            e.printStackTrace();
        }


        //反序列化
        try {
            ByteArrayInputStream in = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream(in);
            User student2 = (User) ois.readObject();
            System.out.println(student2.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
