package com.skillip.thread.threadlocal.ThreadLocalTest02;

public class ThreadA extends Thread {

    @Override
    public void run() {
        try {
            for (int i = 0; i < 100; i++) {
                Tools.t1.set("ThreadA " + i);
                System.out.println("ThreadA get value = "
                        + Tools.t1.get());
            }
                Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
