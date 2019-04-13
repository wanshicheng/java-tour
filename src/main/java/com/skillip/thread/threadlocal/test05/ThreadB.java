package com.skillip.thread.threadlocal.test05;

import com.skillip.thread.threadlocal.test03.Tools;

public class ThreadB extends Thread {
    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("ThreadB:" + Tools.t1.get().getTime());
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
