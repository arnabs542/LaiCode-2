package com.study.practice.class_22_concurrency;

import java.util.Scanner;

public class VolatileTest {
  // The volatile keyword guaranteed visibility (semantically) much like acquiring and releasing a lock
  // atomic

  // flag to stop
  public static volatile boolean flag = false; // volatile
  public static class MyRunnable implements Runnable {
    @Override
    public void run() {
      int i = 0;
      System.out.println("The thread is running...");
      while (!flag) {
        // System.out.println("The thread is running...");
        i++;
      }
      System.out.println("The thread is finished!");
    }
  }

  public static void main(String[] args) throws InterruptedException {
    Thread t1 = new Thread(new MyRunnable());
    t1.start();
    // Thread.sleep(50); // 主线程睡觉
    Scanner scan = new Scanner(System.in);
    if (scan.hasNextBoolean()) {
      flag = scan.nextBoolean();  // volatile field
    }
    System.out.println("Main thread is finished!!");
  }
}
