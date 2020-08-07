package com.test.demo.synchronized1;

public class Test {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("开始");
        for (int i = 0; i < 500000; i++) {
            createCar();
        }
        System.out.println("结束");
        Thread.sleep(10000000);
    }


    private static void createCar() {
        Car car = new Car();
    }
}

class Car{

}
