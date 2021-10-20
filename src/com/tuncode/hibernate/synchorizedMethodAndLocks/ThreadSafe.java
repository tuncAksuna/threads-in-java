package com.tuncode.hibernate.synchorizedMethodAndLocks;

public class ThreadSafe {

    private int count = 0;

    public synchronized void count() {
        // 'synchorized' keyword used so that one method can use this method...
        count++;
    }

    public void runThreads() {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5000; i++) {
                    count();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5000; i++) {
                    count();
                }
            }
        });

        thread1.start();
        thread2.start();

        try {
            // until both methods are done, to stop the 'main thread'
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Count : " + count);
    }


    public static void main(String[] args) {
        ThreadSafe threadSafe = new ThreadSafe();
        threadSafe.runThreads();
    }
}
