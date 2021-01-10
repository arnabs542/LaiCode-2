package com.study.practice.class18_exception;
public class Q6String {
  String str = "a";

  void A() {
    try {
      str +="b";
      B();
    } catch (Exception e) {
      str += "c"; // "abdec"
    }
    //
  }

  void B() throws Exception {
    try {
      str += "d";
      C();
    } catch(Exception e) {

      throw new Exception();

    } finally {
      str += "e"; // 这个是会执行的，之后是"abde"
    }
    str += "f";
  }

  void C() throws Exception {
    throw new Exception();
  }

  void display() {
    System.out.println(str);
  }
  public static void main(String[] args) {
    Q6String object = new Q6String();
    object.A();
    object.display();
  }
  // 问题，最后这个str会是什么value？
}
