package com.skillip.thread.threadlocal.test05;

import java.util.Date;

public class ThreadLocalExt extends ThreadLocal{
    @Override
    protected Object initialValue() {
        return new Date().getTime();
    }
}
