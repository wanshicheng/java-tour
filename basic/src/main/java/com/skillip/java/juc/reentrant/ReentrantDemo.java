package com.skillip.java.juc.reentrant;

/**
 * functionA()和functionB()都是同步方法，当线程进入funcitonA()会获得该类的对象锁，
 * 在functionA()对方法functionB()做了调用，但是functionB()也是同步的，因此该线程需要再次获得该对象锁。
 */
public class ReentrantDemo {
    public synchronized void functionA() {
        System.out.println("iAmFunctionA");
        functionB();
    }

    public synchronized void functionB() {
        System.out.println("iAmFunctionB");
    }
}
