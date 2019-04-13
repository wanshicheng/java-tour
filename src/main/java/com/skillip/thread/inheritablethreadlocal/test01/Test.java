package com.skillip.thread.inheritablethreadlocal.test01;

public class Test {
    public static void main(String[] args) {
        try{
            for (int i = 0; i < 10; i++) {
                System.out.println("Main:" + Tools.t1.get());
                Thread.sleep(100);
            }
            Thread.sleep(5000);
            Thread a = new ThreadA();
            a.start();
            Tools.t1.set("~~~~~~~~~" + System.currentTimeMillis());
            System.out.println(Tools.t1.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
