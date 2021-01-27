package com.study.practice.data_structure;
// 线程安全的Singleton-单例模式


// 如果用final，则很明显是线程安全的
public class Singleton {
  private static final Singleton instance = new Singleton();
  private Singleton() {
    // set some fields if necessary
  }
  public static Singleton getInstance() {
    return instance;
  }
}


// 延迟初始化（lazy）方案（get的时候才创建），
// 通过double-checked locking 双重检查加锁 降低locking overhead
class Singleton2 {
  private static volatile Singleton2 instance = null;
  private Singleton2(){}

  public synchronized Singleton2 getInstance() {
    //  双重检查加锁 仅当锁定条件检查指示需要锁定时，才会发生锁定。
    //  降低overhead
    if (instance == null) { // 第一次
      synchronized(Singleton2.class) {
        // critical section
        if (instance == null) { // 第二次
          instance = new Singleton2();
        }
      }
    }
    return instance;
  }
  // 指令重排优化，使得instance实例化和赋值的顺序不确定
  // 如果先赋值再实例化，那么赋值后对象不是null了，这个时候别人在critical区域外判断是否是null，发现不是null就直接返回了一个错的。
  // 加上volatile后，标明该变量的更新可能是在其他线程中发生的。
}
