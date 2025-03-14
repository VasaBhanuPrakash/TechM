package org.bhanu;

import org.junit.*;

public class JunitTest {
    @Test
    public void testMultiThreadingExecution() {
        Thread thread1 = new Thread(new MultiThreading(), "Thread-1");
        Thread thread2 = new Thread(new MultiThreading(), "Thread-2");
        
        thread1.start();
        thread2.start();
        
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            Assert.fail("Thread execution was interrupted");
        }
}}
