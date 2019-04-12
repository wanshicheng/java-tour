package com.skillip.thread.threadlocal.ThreadLocalTest02;

// 验证线程变量的隔离性
public class ThreadLocalTest02 {
    public static void main(String[] args) {
        Thread t1 = new ThreadA();
        Thread t2 = new ThreadB();
        t1.start();
        t2.start();
        try {
            for (int i = 0; i < 100; i++) {
                Tools.t1.set("Main " + i);
                System.out.println("Main get value = "
                        + Tools.t1.get());
            }
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
