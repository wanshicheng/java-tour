package com.skillip.disruptor;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import com.skillip.disruptor.common.LongEvent;

import java.nio.ByteBuffer;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class MultiProducerDemo {
    public static void main(String[] args) {
        ThreadFactory producerFactory = Executors.defaultThreadFactory();
        // 创建bufferSize ,也就是RingBuffer大小，必须是2的N次方
        int ringBufferSize = 16;
        Disruptor<LongEvent> disruptor = new Disruptor<>(LongEvent::new, ringBufferSize, producerFactory,
                ProducerType.SINGLE, new BlockingWaitStrategy());
        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();


        //注册事件处理器
        disruptor.handleEventsWith(
                (event, sequence, endOfBatch) -> {
                    System.out.println(Thread.currentThread().getName());
                    System.out.println("E: " + event);
                    Thread.sleep(1000);
                });
        //启动Disruptor
        disruptor.start();


        //生产Event
        ByteBuffer bb = ByteBuffer.allocate(8);

        new Thread(() -> {
            for (long l = 0; true; l++) {
                bb.putLong(0, l);
                //生产者生产消息
                ringBuffer.publishEvent(

                        (event, sequence, buffer) ->
                                event.setValue(buffer.getLong(0)), bb);
//            try {
                System.out.println(Thread.currentThread().getName());
                System.out.println(bb.get(0));
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            }
        }).start();

        new Thread(() -> {
            for (long l = 0; true; l++) {
                bb.putLong(0, l);
                //生产者生产消息
                ringBuffer.publishEvent(
                        (event, sequence, buffer) ->
                                event.setValue(buffer.getLong(0)), bb);
//            try {
                System.out.println(Thread.currentThread().getName());
                System.out.println(bb.get(0));
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            }
        }).start();


    }
}
