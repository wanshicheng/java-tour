package com.skillip.thread.threadlocal.test03;

import java.util.Date;

public class ThreadB extends Thread {
    @Override
    public void run() {
        try {
            for (int i = 0; i < 20; i++) {
                if (Tools.t1.get() == null) {
                    Tools.t1.set(new Date());
                }
                System.out.println("B " + Tools.t1.get().getTime());
                Thread.sleep(200);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
