package com.study.practice.class_23_concurrency;

// volatile use case 2

//这段代码本来的问题：
//  实例化一个对象其实可以分为三个步骤：分配内存空间、初始化对象、赋值引用
//  如果没有volatile，那么new和赋值可能是重排了
//  如果先赋值让它不null了，那么它在第一层判断非null，就可以获得return的值。
//  可是这个return的内容其实是没有初始化完的，在使用的时候就会出现问题。

//加了volatile后：
//  告诉编译器，不要随便优化它，包括不要进行指令的重排列。

// https://en.wikipedia.org/wiki/Double-checked_locking#Usage_in_Java
//  用double-checked是因为全锁住太慢了。
//  singleton如果不是null，大家可以同时获得它然后用。
//  所以先check是不是null，是null我才拿锁然后准备new，
//  但是在我等锁的时候别人可能正在new，所以我拿到锁以后还要double check。
public class Singleton {
  public static volatile Singleton singleton;

  private Singleton() {};

  public static Singleton getInstance() {
    if (singleton == null) {
      synchronized (singleton) {
        if (singleton == null) {
          singleton = new Singleton();
        }
      }
    }
    return singleton;
  }
}

