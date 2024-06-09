package com.arz.coding.multithreadingpractise;

public class Deadlock extends Thread {
    public static void main(String[] args) {
        final String resource1 = "abc";
        final String resource2 = "xyz";

        Thread t1 = new Thread(() -> {
            synchronized (resource1) {
                System.out.println("Thread1: locked resource1");
                try{
                    Thread.sleep(100);
                }
                catch (InterruptedException e){
                    System.out.println("Exception occurred by thread1"+e);
                }
                synchronized (resource2){
                 System.out.println("Thread1: locked resource2");
                }
            }
        });

        Thread t2 = new Thread(() -> {
           synchronized (resource2){
               System.out.println("Thread 2 : locked resource2");
               try{
                   Thread.sleep(100);
               }
               catch(InterruptedException e){
                   System.out.println("Exception occurred by thread2"+e);
               }
               synchronized (resource1){
                   System.out.println("Thread2: locked resource1");
               }
           }
        });

        t1.start();
        t2.start();
    }
}
