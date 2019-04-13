package com.skillip.thread.inheritablethreadlocal.test01;

import java.util.Date;

public class InheritableThreadLocalExt extends InheritableThreadLocal {
    @Override
    protected Object initialValue() {
        return new Date().getTime();
    }

    @Override
    protected Object childValue(Object parentValue) {
        return parentValue + "子线程处理一下";
    }
}
