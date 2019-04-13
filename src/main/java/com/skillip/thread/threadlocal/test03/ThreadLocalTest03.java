package com.skillip.thread.threadlocal.test03;

public class ThreadLocalTest03 {
    public static void main(String[] args) {
        try {
            ThreadA t1 = new ThreadA();
            t1.start();
            Thread.sleep(1000);
            ThreadB t2 = new ThreadB();
            t2.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
