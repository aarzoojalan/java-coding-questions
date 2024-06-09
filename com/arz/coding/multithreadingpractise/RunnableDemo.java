package com.arz.coding.multithreadingpractise;

public class RunnableDemo {
    public static void main(String args[]) throws InterruptedException {

        Thread t1 = new Thread(() -> {
        for (int i = 0; i < 5; i++) {
            System.out.println("Hii"+ Thread.currentThread().getPriority());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
        }
      },"Hii Thread");

        Thread t2 = new Thread(() -> {
            for(int i = 0; i<5; i++){
                System.out.println("Hello");
                try{
                    Thread.sleep(1000);
                }
                catch (InterruptedException e){

                }
            }
        },"Hello Thread");

        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);

        System.out.println(t1.getPriority());
        System.out.println(t2.getPriority());
        t1.start();;
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Bye");
    }
}
