package com.skillip.java.concurrent.asynchronization;

public class ActionImpl implements Action {
    @Override
    public String doSomething(String str) throws InterruptedException {
        Thread.sleep(5000);
        return "do: " + str;
    }
}
