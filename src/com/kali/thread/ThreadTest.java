package com.kali.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadTest {
    public static void main(String[] args) {
        //  使用共享变量获取线程的执行结果
        AtomicInteger shareVariable = new AtomicInteger(0);
        System.out.println(shareVariable);
        Thread thread = new Thread(() -> {
            shareVariable.set(5);
        });
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(shareVariable);
    }
}
