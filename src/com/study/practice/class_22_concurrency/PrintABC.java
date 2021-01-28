package com.study.practice.class_22_concurrency;

// sleep(0)时效果相当于yield()。
// 会让当前线程放弃剩余时间片，进入相同优先级线程队列的队尾，
// 只有排在前面的所有同优先级线程完成调度后，它才能再次获执行的机会。

import java.util.Arrays;

public class PrintABC {
  public static void main(String[] args) throws InterruptedException {
    // synchronized + wait + notify
    // control the sequence of ABCABC
    Object a = new Object();
    Object b = new Object();
    Object c = new Object();
    ThreadPrinter pa = new ThreadPrinter("A", c, a);
    ThreadPrinter pb = new ThreadPrinter("B", a, b);
    ThreadPrinter pc = new ThreadPrinter("C", b, c);

    Thread ta = new Thread(pa);
    ta.start();
    Thread.sleep(10);  //保证初始ABC的启动顺序 主线程等待10ms后进入ready-to-run的队列的队尾
    Thread tb = new Thread(pb);
    tb.start();
    Thread.sleep(10);
    Thread tc = new Thread(pc);
    tc.start();
    Thread.sleep(10);
  }
}
