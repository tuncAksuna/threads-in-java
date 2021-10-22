package com.tuncode.hibernate.threadpools;


public class ThreadPoolsAndExecutorService implements Runnable {

    private String name;
    private int taskId;

    public ThreadPoolsAndExecutorService(String name, int taskId) {
        this.name = name;
        this.taskId = taskId;
    }

    @Override
    public void run() {
        System.out.println("Worker : " + name + " Task ID : " + taskId + ". işe başladı.");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println("Worker : " + name + " Task ID : " + taskId + ". işi bitirdi.");
    }
}
