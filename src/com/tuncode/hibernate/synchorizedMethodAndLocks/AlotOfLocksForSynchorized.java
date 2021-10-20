package com.tuncode.hibernate.synchorizedMethodAndLocks;

import java.util.ArrayList;
import java.util.Random;

public class AlotOfLocksForSynchorized {

    Random randomValues = new Random();
    ArrayList<Integer> list1 = new ArrayList<>();
    ArrayList<Integer> list2 = new ArrayList<>();

    // two locks for time performance...
    private Object lock1 = new Object();
    private Object lock2 = new Object();

    public void addValueToList1() {
        synchronized (lock1) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list1.add(randomValues.nextInt(100));
        }

    }

    public void addValueToList2() {
        synchronized (lock2) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list2.add(randomValues.nextInt(100));
        }
    }

    public void addValue() {
        for (int i = 0; i < 1000; i++) {
            addValueToList1();
            addValueToList2();
        }
    }

    public void runThreads() {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                addValue();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                addValue();
            }
        });

        long startTime = System.currentTimeMillis();

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("List 1 : " + list1.size() + " List2 : " + list2.size());

        long endTime = System.currentTimeMillis();

        System.out.println("SPENT TIME :  " + (endTime - startTime));
    }
}
