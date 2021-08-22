package com.skillip.disruptor;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.util.DaemonThreadFactory;
import com.skillip.disruptor.common.LongEvent;

import java.nio.ByteBuffer;

public class SimpleDemo {
    public static void main(String[] args) {
        //指定RingBuffer大小,
        //必须是2的N次方
        int bufferSize = 16;

        //构建Disruptor
        Disruptor<LongEvent> disruptor = new Disruptor<>(
                LongEvent::new, bufferSize, DaemonThreadFactory.INSTANCE);

        //注册事件处理器
        disruptor.handleEventsWith(
                (event, sequence, endOfBatch) -> {
                    System.out.println(Thread.currentThread().getName());
                    System.out.println("E: " + event);
                    Thread.sleep(5000);
                });
        //启动Disruptor
        disruptor.start();


        //获取RingBuffer
        RingBuffer<LongEvent> ringBuffer
                = disruptor.getRingBuffer();
        //生产Event
        ByteBuffer bb = ByteBuffer.allocate(8);


        for (long l = 0; true; l++) {
            bb.putLong(0, l);
            //生产者生产消息
            ringBuffer.publishEvent(
                    (event, sequence, buffer) ->
                            event.setValue(buffer.getLong(0)), bb);
            try {
                System.out.println(Thread.currentThread().getName());
                System.out.println(bb.get(0));
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}