package com.kali.thread;

import java.util.concurrent.*;

public class TaskTest {
    public static void main(String[] args) {
        // 1.使用Runnable和自定义结果对象获取线程返回结果
        Task task = new Task();
        System.out.println(task.getResult());
        Thread thread = new Thread(task);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(task.getResult());

        // 2.使用Callable和Future获取线程返回值
        System.out.println("----------------");
        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        Future submit = executorService.submit(()->5);
        Future submit = executorService.submit(new Task1());
        try {
            System.out.println(submit.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }

}

class Task implements Runnable {
    int result;

    public int getResult() {
        return result;
    }

    @Override
    public void run() {
        result = 5;
    }
}

class Task1 implements Callable{
    @Override
    public Object call() throws Exception {
        return 5;
    }
}
