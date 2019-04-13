package com.skillip.thread.threadlocal.test05;

public class ThreadA extends Thread{
    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("ThreadA:" + Tools.t1.get());
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
