package com.skillip.java.concurrent;

import java.util.Arrays;

public class VoaltileExample {
    int x = 0;
    volatile boolean v = false;
    public void writer() {
        x = 42;
        v = true;
    }

    public void reader() {
        if (v == true) {
            System.out.println(x);
        }
     }

    public static void main(String[] args) {
        System.out.println((int) '1');
        System.out.println((int) 'a');
        char[] chars = {'a', '1', 'c'};
        Arrays.sort(chars);
        for (char aChar : chars) {
            System.out.println(aChar);
        }

    }
}
