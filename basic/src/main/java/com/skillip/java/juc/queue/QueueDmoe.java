package com.skillip.java.juc.queue;

import java.util.concurrent.ArrayBlockingQueue;

public class QueueDmoe {
    public static void main(String[] args) {
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(16);
        try {
            queue.put("test");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        try {
            queue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
