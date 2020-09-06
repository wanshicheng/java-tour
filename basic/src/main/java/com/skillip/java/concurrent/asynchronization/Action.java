package com.skillip.java.concurrent.asynchronization;

public interface Action {
    String doSomething(String str) throws InterruptedException;
}
