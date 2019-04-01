package com.skillip.exam;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class BonusQuestion {
    public static void main(String[] args) {
        Object lock = new Object();
        Queue<Integer> q = new PriorityQueue<>();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    synchronized (lock) {
                        q.add((int) (Math.random() * 100));
                        if(Math.random() > 0.5) {
                            lock.notify();
                        }
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    while (true) {
                        if (q.size() > 0) {
                            Integer i = q.remove();
                            System.out.println(i);
                        }else {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }).start();
    }

    @Test
    public void t8() {
        int[] numbers = {2, 3,1, 4, 5, 9};
        bubbleSort(numbers);
        System.out.println(Arrays.toString(numbers));
    }

    /**
     * 冒泡排序
     * 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
     * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。
     * 针对所有的元素重复以上的步骤，除了最后一个。
     * 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
     * @param numbers 需要排序的整型数组
     */
    public static void bubbleSort(int[] numbers) {
        int temp = 0;
        int len = numbers.length;

        for(int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
    }

    // https://blog.csdn.net/IT_ZJYANG/article/details/53406764
    public static void quickSort(int[] numbers) {

    }

    @Test
    public void test7() {
        // 位于 main 方法
    }

    @Test
    public void test6() {
        int[] array = {1, 2, 5, 3, 2, 4, 2};
        int left = 0;
        int right = 0;
        for (int i = 1; i < array.length - 1; i++) {
            for (int j = 0; j < i; j++) {
                left += array[j];
            }
            for (int k = array.length - 1; k > i; k--) {
                right += array[k];
            }
            if (left == right) {
                System.out.println("第" + (i + 1) + "个位置");
            }
            left = 0;
            right = 0;
        }
    }

    @Test
    public void test5() {

    }



    /*
    public static String replace(String text, String target, String replace){
    ....
    }
    示例：replace(“aabbccbb”, “bb”, “dd”);  结果：aaddccdd
    注意：不能使用String及StringBuffer等类的replace等现成的替换API方法。
    */
    @Test
    public void test1() {
//        /*String str = "abbc";
//
//        System.out.println(str.indexOf("bb"));
//        StringBuffer sb = new StringBuffer();
////        str.replace();*/
        int i = 0;
    }

    @Test
    public void t1() {
        System.out.println(replace("aabbbccbbbb", "bb", "dd"));
    }

    public static String replace(String text, String target,String replace) {
        String[] strs = text.split(target);
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < strs.length; i++) {
            sb.append(strs[i]);
            sb.append(replace);
        }

        return sb.toString();
    }

}

