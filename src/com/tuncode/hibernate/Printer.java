package com.tuncode.hibernate;

public class Printer implements Runnable {

    private String name;

    public Printer(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + " is being ran now");
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println(name + " is being written : " + i);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
