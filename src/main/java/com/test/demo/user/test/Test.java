package com.test.demo.user.test;

import org.springframework.scheduling.annotation.Async;

/**
 * ${DESCRIPTION}.
 *
 * @date: 2019-12-25
 * @version: 1.0
 * @author: zhangquanshuo@beyondsoft.com
 */
public class Test {
    public static void main(String[] args) {
        //System.out.println(f(10));
        int [] array={4,5,6,1,3,2};
        Test test=new Test();

        Aops.getSelf(test).bubbleSort(array,array.length);

        //test.bubbleSort(array,array.length);
        insertionSort(array,array.length);
        System.out.println("》》》》》》》》》》》》》》》》");
    }
    static int f(int n){
        if(n==1) return  1;
        if(n==2) return  2;
        return f(n-1) + f(n-2);
    }
    @Async
    public  void bubbleSort(int[] a, int n) {
        if (n <= 1) return;
        for (int i = 0; i < n; ++i) {
            System.out.println("外层循环："+i);
            // 提前退出冒泡循环的标志位
            boolean flag = false;
            for (int j = 0; j < n - i - 1; ++j) {
                System.out.println("内层循环："+j);
                if (a[j] > a[j+1]) { // 交换
                    int tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                    flag = true; // 表示有数据交换
                }
            }
            if (!flag) break; // 没有数据交换，提前退出
        }
        System.out.println("222222222222");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("11111111111");
    }
    public static void  insertionSort(int[] a, int n) {
//        if (n <= 1) return;
//        for (int i = 1; i < n; ++i) {
//            int value = a[i];
//            int j = i - 1;
//            // 查找插入的位置
//            for (; j >= 0; --j) {
//                if (a[j] > value) {
//                    a[j+1] = a[j]; // 数据移动
//                } else {
//                    break;
//                }
//            }
//            a[j+1] = value; // 插入数据
//        }

        for(int i=1; i<a.length; i++){
            for(int j=i; j>0; j--){
                if(a[j]<a[j-1]){
                    int temp = a[j-1];
                    a[j-1] = a[j];
                    a[j] = temp;
                }
            }
        }
        System.out.println(a);
    }


}
