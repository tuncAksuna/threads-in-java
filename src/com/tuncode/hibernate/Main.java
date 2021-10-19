package com.tuncode.hibernate;

public class Main {

    public static void main(String[] args) {

        System.out.println("Main thread is being ran");

        Thread printer1 = new Thread(new Printer("Printer1"));
        Thread printer2 = new Thread(new Printer("Printer2"));

        printer1.start();
        printer2.start();

    }
}
