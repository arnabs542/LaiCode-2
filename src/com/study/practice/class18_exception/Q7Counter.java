package com.study.practice.class18_exception;

public class Q7Counter {
  int count = 0;

  void A() throws Exception {
    try {
      count++;  // 1
      try {
        count++;   // 2
        try {
          count++;   // 3
          throw new Exception();
        } catch (Exception ex) {
          count++;
          throw new Exception();
        }
      } catch (Exception ex) {
        count++;
      }
    } catch (Exception ex) {
      count++;
    }
    // 哪个catch不会被执行？try里面无exception，就不会执行。即最后一个不会执行
    count++;
  }

  void display() {
    System.out.println(count);
  }

  public static void main(String[] args) throws Exception {
    Q7Counter obj = new Q7Counter();
    obj.A();
    obj.display();
  }
}
