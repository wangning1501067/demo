package com.test.demo.xuliehua;

import java.io.*;

public class Person implements Externalizable {
    private String name;
    private int age;
    //我不提供无参构造器
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        //将name反转后写入二进制流
        StringBuffer reverse = new StringBuffer(name).reverse();
        System.out.println(reverse.toString());
        out.writeObject(reverse);
        out.writeInt(age);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        //将读取的字符串反转后赋值给name实例变量
        this.name = ((StringBuffer) in.readObject()).reverse().toString();
        System.out.println(name);
        this.age = in.readInt();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ExPerson.txt"));
             ObjectInputStream ois = new ObjectInputStream(new FileInputStream("ExPerson.txt"))) {
            oos.writeObject(new Person("brady", 23));
            Person ep = (Person) ois.readObject();
            System.out.println(ep);
        }
    }
}

class WriteObject {
    public static void main(String[] args) {
        try (//创建一个ObjectOutputStream输出流
             ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("object.txt"))) {
            //将对象序列化到文件s
            Person person = new Person("9龙", 23);
            System.out.println(person);
            oos.writeObject(person);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class ReadObject {
    public static void main(String[] args) {
        try (//创建一个ObjectInputStream输入流
             ObjectInputStream ois = new ObjectInputStream(new FileInputStream("object.txt"))) {
            Person brady = (Person) ois.readObject();
            System.out.println(brady);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
