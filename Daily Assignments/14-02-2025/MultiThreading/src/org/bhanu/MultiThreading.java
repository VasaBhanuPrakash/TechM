package org.bhanu;

public class MultiThreading implements Runnable {
    public void run() {
        System.out.println("Thread " + Thread.currentThread().getName() + " is executed");
    }
}