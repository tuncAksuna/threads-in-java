package com.tuncode.hibernate.waitandnotify;

public class Main {

    public static void main(String[] args) {

        WaitAndNotify wN = new WaitAndNotify();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                wN.thread1Function();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                wN.thread2Function();
            }
        });
    }
}
