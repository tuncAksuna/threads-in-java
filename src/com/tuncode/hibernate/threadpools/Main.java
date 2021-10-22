package com.tuncode.hibernate.threadpools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

        /* BEST PRACTICE :  */

        ExecutorService executorService = Executors.newFixedThreadPool(2); // run two threads at the same time

        for (int i = 0; i <= 5; i++) {
            executorService.submit(new ThreadPoolsAndExecutorService(String.valueOf(i), i));
        }

        executorService.shutdown();
        System.out.println("All task has been completed and executor service closed");

        /* await threads automatically */
        try {
            executorService.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All tasks has been completed");

         /* BAD PRACTICE
        Thread t1 = new Thread(new ThreadPoolsAndExecutorService("1", 1));
        Thread t2 = new Thread(new ThreadPoolsAndExecutorService("2", 2));
        Thread t3 = new Thread(new ThreadPoolsAndExecutorService("3", 3));
        Thread t4 = new Thread(new ThreadPoolsAndExecutorService("4", 4));
        Thread t5 = new Thread(new ThreadPoolsAndExecutorService("5", 5));

        System.out.println("All tasks is being started");

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t3.start();
        t4.start();
        try {

            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t5.start();
        try {
            t5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("All tasks has been completed !");
        */
    }
}
