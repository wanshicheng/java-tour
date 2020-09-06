package com.skillip.java.concurrent.asynchronization;

public class AsynTest {

    public static void main(String[] args) throws InterruptedException {
        new AsynTest().invoke(new ActionImpl());
    }

    private void invoke(Action action) throws InterruptedException {
        System.out.println("start");
        action.doSomething("invoke");
        System.out.println("end");
    }
}
