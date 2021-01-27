package com.study.practice.class_22_concurrency;

public class CreateThread {
  public static void main(String args[]) throws Exception{
    Thread t = new Thread() {
      @Override
      public void run() {
        System.out.println("Hello1");
      }
    };
    t.start();
    System.out.println("Hello2");
    t.join();
    System.out.println("Hello3");

    Thread t2 = new Thread(new AnotherClass());
    t2.start();
    System.out.println("Hello2");
    t2.join();
    System.out.println("Hello3");
  }
}
