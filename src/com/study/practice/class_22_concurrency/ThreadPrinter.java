package com.study.practice.class_22_concurrency;

public class ThreadPrinter implements Runnable{
  private String name;
  private Object prev;
  private Object self;

  public ThreadPrinter(String name, Object prev, Object self) {
    this.name = name;
    this.prev = prev;
    this.self = self;
  }
  // 每个线程：wait prev的锁，自己释放的时候要notify wait自己这个对象锁的线程
  //         除了第一次手动控制外，
  //         A wait C, B wait A, C wait B
  //              A.notify  B.notify  C.notify
  //              A noti B, B noti C, C noti A
  @Override
  public void run() {
    int count = 16;
    while (count > 0) {
      synchronized (prev) {
        // critical section start
        synchronized (self) {
          System.out.print(name);
          count--;

          self.notify(); // 当执行notify/notifyAll方法时，会唤醒一个处于等待该 对象锁 的线程，然后继续往下执行，直到执行完退出对象锁锁住的区域（synchronized修饰的代码块）后再释放锁。
        }
        // critical section end
        try {
          prev.wait(); // 当线程执行wait()时，会把当前的锁释放，然后让出CPU，进入等待状态。
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }


}
