package com.github.wanshicheng.juc;

public class VolatileTour {
    private static boolean flagWithoutVolatile = false;
    private static volatile boolean flagWithVolatile = false;


    public static void main(String[] args) throws InterruptedException {
//        testWithoutVolatile();
//        testWithVolatile();
        testSleep();
    }


    private static void testWithoutVolatile() throws InterruptedException {
        System.out.println("start");
        new Thread(() -> {
            while (!flagWithoutVolatile) {

            }
            System.out.println("sub thread finished!");
        }).start();
        Thread.sleep(1000);
        flagWithoutVolatile = true;
        System.out.println("main thread finished!");
    }

    private static void testWithVolatile() throws InterruptedException {
        System.out.println("start");
        new Thread(() -> {
            while (!flagWithVolatile) {

            }
            System.out.println("sub thread finished!");
        }).start();
        Thread.sleep(1000);
        flagWithVolatile = true;
        System.out.println("main thread finished!");
    }

    private static void testSleep() throws InterruptedException {
        System.out.println("start");
        new Thread(() -> {
            long startTimestamp = System.currentTimeMillis();
            while (!flagWithoutVolatile) {
                if (System.currentTimeMillis() - startTimestamp > 5 * 1000) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("sub thread finished!");
        }).start();
        Thread.sleep(1000);
        flagWithoutVolatile = true;

        System.out.println("main thread finished!");
    }

}
