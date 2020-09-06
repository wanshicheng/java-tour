package com.skillip.java.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {
    Queue<Integer> queue;
    int capacity;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.queue = new LinkedList<>();
        this.capacity = size;
    }

    public double next(int val) {
        double sum = 0;
        queue.add(val);
        if (this.queue.size() < this.capacity) {
            for (Integer value : queue) {
                sum += value;
            }
            return sum / (this.queue.size());
        }else {
            for (Integer value : queue) {
                sum += value;
            }
            queue.remove();
            return sum / (this.capacity);
        }
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
