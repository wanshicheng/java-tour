package com.skillip.exam;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class MoreHardQuestion {
    // 判断101-200之间有多少个素数，并输出所有素数
    @Test
    public void test01() {
        System.out.println("101-200之间的素数有：");
        for (int i = 101; i <= 200; ++i) {
            boolean flag = true;
            for (int j = 2; j < i; ++j) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println(i);
            }
        }
    }

    // 一个球从100米高度自由落下，每次落地后反跳回原高度的一半，再落下，求它在第10次落地时，共经过多少米？第10次反弹多高？
    // 自身问题：首先没有考虑到类型该用 double
    @Test
    public void test02() {
        double height = 100;
        double distance = 0;
        int count = 10;
        for (int i = 1; i <= count; i++) {
            distance += height;// 加落下的距离
            height = height / 2;// 弹起的高度 第i次弹起的高度
            if (i != count) {
                distance += height; // 加弹起的距离
            }
        }
        System.out.println("第" + count + "次落地时，经过了：" + distance + "米");
        System.out.println("第" + count + "次反弹的高度是：" + height + "米");

    }

    // 请使用二分查找算法查找字符数组{“a”,”b”,”c”,”d”,”e”,”f”,”g”,”h”}中”g”元素的位置？
    @Test
    public void test11() {
        char[] c = {'a',  'b', 'c', 'd', 'e', 'f', 'g', 'h'};


    }

    // 12.	消除下面集合中重复元素？
    // List list = Arrays.asList(1,2,3,3,4,4,5,5,6,1,9,3,25,4);
    @Test
    public void test12() {
        List list = Arrays.asList(1,2,3,3,4,4,5,5,6,1,9,3,25,4);

        HashSet<Integer> set = new HashSet<>();
        set.addAll(list);
        System.out.println(set);
    }
}
