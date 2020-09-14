package com.test.demo.xuliehua;

import java.io.*;

public class Test {
    public static void main(String[] args) {
        //序列化
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("object.out");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            User student1 = new User("1", "王宁", "123456", "宁爷", "111");
            oos.writeObject(student1);
            oos.flush();
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        //反序列化
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("object.out");
            ObjectInputStream ois = new ObjectInputStream(fis);
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
