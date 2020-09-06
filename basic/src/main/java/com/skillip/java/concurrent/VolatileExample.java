package com.skillip.java.concurrent;

public class VolatileExample {
    volatile int x = 0;
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
        VolatileExample example = new VolatileExample();
    }
}
