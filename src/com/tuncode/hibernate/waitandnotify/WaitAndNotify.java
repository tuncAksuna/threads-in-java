package com.tuncode.hibernate.waitandnotify;

import java.util.Scanner;

public class WaitAndNotify {

    private Object lock = new Object();

    public void thread1Function(){

        synchronized (lock){
            System.out.println("Thread 1 is being ran");

            try {
                lock.wait();
                System.out.println("Thread 1 is waiting for thread 2");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Thread 1 has been notified. It is being ran");
        }
    }

    public void thread2Function(){
        Scanner scanner = new Scanner(System.in);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (lock){
            System.out.println("Thread 2 is being ran");

            System.out.println("Press any key to continue ");
            scanner.nextLine();

            lock.notify();
            System.out.println("Thread 1 is being notified");
        }
    }
}
