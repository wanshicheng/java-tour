package com.skillip.java.concurrent;

public class Foo {
    private volatile static int i = 0;

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (this) {
            if(i != 0) {
                this.wait();

            }
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            i++;
            this.notifyAll();
        }

    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (Foo.class) {
            if(i != 1) {
                this.wait();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            i++;
            this.notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (Foo.class) {
            if(i != 2) {
                this.wait();
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
            i = 0;
            this.notifyAll();
        }
    }
}
