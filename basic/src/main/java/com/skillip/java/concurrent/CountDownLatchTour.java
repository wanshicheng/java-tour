package com.skillip.java.concurrent;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTour {
    private final Thread keepAliveThread;
    private final CountDownLatch keepAliveLatch = new CountDownLatch(1);

    public CountDownLatchTour() {
        keepAliveThread = new Thread(() -> {
            try {
                System.out.println("keepAliveThread...");
                Thread.sleep(10000);
                keepAliveLatch.await();
            } catch (InterruptedException e) {
                // bail out
            }
        }, "keepAlive");
        keepAliveThread.setDaemon(false);
        // keep this thread alive (non daemon thread) until we shutdown
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("keepAliveLatch");
            keepAliveLatch.countDown();
        }));
    }

    public static void main(String[] args) {
//        ExecutorService executor = Executors.newFixedThreadPool(2);
        CountDownLatchTour countDownLatchTour = new CountDownLatchTour();
        countDownLatchTour.keepAliveThread.start();
    }
}
