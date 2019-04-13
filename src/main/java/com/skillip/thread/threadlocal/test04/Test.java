package com.skillip.thread.threadlocal.test04;

import com.skillip.thread.threadlocal.ext.ThreadLocalExt;

public class Test {
    public static ThreadLocal t = new ThreadLocalExt();
    public static void main(String[] args) {
        if(t.get() == null) {
            System.out.println("空值");
            t.set("我的值");
        }
        System.out.println(t.get());
        System.out.println(t.get());
    }
}
