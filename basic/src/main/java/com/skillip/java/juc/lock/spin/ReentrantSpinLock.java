package com.skillip.java.juc.lock.spin;

import java.util.concurrent.atomic.AtomicReference;

public class ReentrantSpinLock {
    private AtomicReference<Thread> owner = new AtomicReference<>();

    /** 重入次数 */
    private int count = 0;
}
