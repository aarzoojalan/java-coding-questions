package com.arz.coding.multithreadingpractise;

import java.util.ArrayList;
import java.util.List;

class MyProducer implements  Runnable {
    private List<String> buffer;
    MyProducer (List<String> buffer){
        this.buffer = buffer;
    }
    @Override
    public void run(){
      String numbers[] = {"1","2","3"};
      for(String n:numbers) {
          synchronized (buffer){
              buffer.add(n);
              try {
                  Thread.sleep(1000);
              } catch (InterruptedException e){
                  System.out.println(Thread.currentThread().getName() +"interrupted.");
              }
          }
          System.out.println(Thread.currentThread().getName()+" added "+n);
      }
        System.out.println(Thread.currentThread().getName()+" added "+SynchronizedMultiThread.EOF);
      synchronized (buffer){
          buffer.add(SynchronizedMultiThread.EOF);
      }
    }
}

class MyConsumer implements Runnable {
    private List<String> buffer;
    MyConsumer(List<String> buffer){
        this.buffer = buffer;
    }
    @Override
    public void run() {
        while (true){
            synchronized (buffer) {
                if (buffer.isEmpty()) {
                    continue;
                } else if (buffer.get(0).equals(SynchronizedMultiThread.EOF)) {
                    System.out.println(Thread.currentThread().getName() + " exiting.");
                    break;
                } else {
                    System.out.println(Thread.currentThread().getName() + " removed." + buffer.remove(0));
                }
            }
        }
    }
}
public class SynchronizedMultiThread {
    public static final String EOF ="EOF";
    public static void main(String[] args) {
        List<String> buffer = new ArrayList<>();

       Thread producerThread = new Thread(new MyProducer(buffer));
       producerThread.setName("producerThread");

       Thread consumerThread = new Thread(new MyConsumer(buffer));
       consumerThread.setName("consumerThread");

       producerThread.start();
       consumerThread.start();
    }
}
