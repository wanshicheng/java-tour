package io.github.wanshicheng.juc.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockQueue<E> {
    private final Lock lock = new ReentrantLock();

    // 条件变量：队列不满
    final Condition notFull = lock.newCondition();
    // 条件变量：队列不空
    final Condition notEmpty = lock.newCondition();


    private Queue<E> queue = new LinkedList<>();

    private volatile int capacity;

    private int count;


    public BlockQueue(int capacity) {
        this.capacity = capacity;
    }

    // 入队
    public void enqueue(E x) {
        lock.lock();
        try {
            while (count == capacity) {
                // 等待队列不满
                notFull.await();
            }
            queue.add(x);
            count++;
            // 入队后,通知可出队
            notEmpty.signal();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    // 出队
    public E dequeue() {
        E elem;
        lock.lock();
        try {
            while (0 == count) {
                // 等待队列不空
                notEmpty.await();
            }
            elem = queue.poll();
            count--;
            // 出队后，通知可入队
            notFull.signal();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
        return elem;
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}
