package com.arz.coding.multithreadingpractise;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
class Producer implements Runnable {
    private List<String> buffer;
    private ReentrantLock bufferLock;

    public Producer(List<String> buffer,ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.bufferLock = bufferLock;
    }

    @Override
    public void run() {
        String numbers[] = {"1", "2", "3","4","5"};
        for (String number : numbers) {
            bufferLock.lock();
            try {
                buffer.add(number);
            }
            finally {
                bufferLock.unlock();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) { }
            System.out.println(Thread.currentThread().getName() + " added " + number);
        }
        System.out.println(Thread.currentThread().getName() + " added " + ReterrantLockMultiThread.EOF);
        bufferLock.lock();
        try {
            buffer.add(ReterrantLockMultiThread.EOF);
        }
        finally {
            bufferLock.unlock();
        }
    }
}

class Consumer implements Runnable {
    private List<String> buffer;
    private ReentrantLock bufferLock;

    public Consumer(List<String> buffer,ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.bufferLock = bufferLock;
    }

    @Override
    public void run() {
        while (true) {
               bufferLock.lock();
               try {
                   if (buffer.isEmpty()) {
                       continue;
                   }
                   if (buffer.get(0).equals(ReterrantLockMultiThread.EOF)) {
                       System.out.println(Thread.currentThread().getName() + " exiting.");
                       break;
                   } else {
                       System.out.println(Thread.currentThread().getName() + " removed " + buffer.remove(0));
                       try {
                           Thread.sleep(1000);
                       } catch (InterruptedException e) {}
                   }
               }
               finally {
                   bufferLock.unlock();
               }
        }
    }
}

public class ReterrantLockMultiThread {
    public static final String EOF = "EOF";
    public static void main(String[] args) {
        List<String> buffer = new ArrayList<>();
        ReentrantLock bufferLock =  new ReentrantLock();

        new Thread(new Producer(buffer,bufferLock),"producerThread").start();
        new Thread(new Consumer(buffer,bufferLock),"consumerThread").start();
    }
}
