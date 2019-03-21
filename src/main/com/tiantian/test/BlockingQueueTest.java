package com.tiantian.test;

import lombok.Synchronized;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueueTest {
    public static void main(String[] args) {
        final BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(3); //缓冲区允许放3个数据

        Object o = new Object();
        for(int i = 0; i < 2; i ++) {

            new Thread() { //开启两个线程不停的往缓冲区存数据

                @Override
                public void run() {

                    ReentrantLock reentrantLock = new ReentrantLock();
                    synchronized (o) {
                        while (true) {
                            try {

                                System.out.println(Thread.currentThread().getName() + "准备放数据"

                                        + (queue.size() == 3 ? "..队列已满，正在等待" : "..."));

                                queue.put(1);
                                o.wait();
                                System.out.println(Thread.currentThread().getName() + "存入数据，"
                                        + "队列目前有" + queue.size() + "个数据");
                            } catch (InterruptedException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            } finally {
                                reentrantLock.unlock();
                            }
                        }
                    }

                }
            }.start();
        }

        new Thread() { //开启一个线程不停的从缓冲区取数据

            @Override
            public void run() {
                while(true) {
                    try {

                        System.out.println(Thread.currentThread().getName() + "准备取数据"
                                + (queue.size() == 0?"..队列已空，正在等待":"..."));
                        queue.take();
                        System.out.println(Thread.currentThread().getName() + "取出数据，"
                                + "队列目前有" + queue.size() + "个数据");
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }


}
