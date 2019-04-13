package com.skillip.thread.threadlocal.ext;

public class ThreadLocalExt extends ThreadLocal {

    @Override
    protected Object initialValue() {
        return "默认值";
    }
}
