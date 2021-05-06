package com.skillip.java.concurrent.monitor;

import java.util.concurrent.atomic.AtomicInteger;

public class Demo {
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger i = new AtomicInteger();
        Thread t1 = new Thread(() -> {
            while (true) {
                System.out.println(i);
                i.getAndIncrement();

            }
        });
        t1.start();
        t1.wait();

        new Thread(() -> {
            while (true) {

            }
        }).start();

        while (i.get() == 1000000) {

        }
    }
}
