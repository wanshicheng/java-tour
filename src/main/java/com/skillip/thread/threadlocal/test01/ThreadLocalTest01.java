package com.skillip.thread.threadlocal.test01;

public class ThreadLocalTest01 {
    public static ThreadLocal t1 = new ThreadLocal();

    public static void main(String[] args) {
        if(t1.get() == null) {
            System.out.println("空值");
            t1.set("我的值");
        }
        System.out.println(t1.get());
        System.out.println(t1.get());
    }
}
