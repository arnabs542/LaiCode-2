package com.study.practice.class18_exception;

import java.io.*;

public class LearnException {
  static void fun() throws IOException {
    try {
      throw new IOException("demo");
      // int i = 1;
    } catch (IOException e) {
      System.out.println("Caught inside fun().");
      throw e; // rethrowing the exception
    }
  }

  public static void main (String args[]) throws IOException{
    try {
      fun();
    } catch (IOException e) {
      System.out.println("Caught in main.");
    }
    fun();
  }
}
