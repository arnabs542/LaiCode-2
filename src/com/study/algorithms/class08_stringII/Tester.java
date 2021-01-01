package com.study.algorithms.class08_stringII;

public class Tester {

  public static void main(String[] args) {
    ReverseWords rw = new ReverseWords();
    String str = "I love Yahoo";
    System.out.println(rw.reverseWords(str));

    RightShift rs = new RightShift();
    String str2 = "abcdef";
    System.out.println(rs.rightShift(str2, 2));
  }
}
