package com.study.practice.class18_exception;

import java.io.IOException;

public class LearnThrows {
  static void fun() throws IllegalAccessException, IOException {
    System.out.println("Inside fun(). ");
    throw new IllegalAccessException("demo");
  }

  public static void main(String args[]) throws IOException{
    try {
      fun(); // Unhandled exception: java.io.IOException
    } catch (IllegalAccessException e) {
      System.out.println("caught in main.");
    } finally {
      System.out.println("finally");
    }
    System.out.println("after finally");
  }
}
