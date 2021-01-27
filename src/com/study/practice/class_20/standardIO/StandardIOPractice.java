package com.study.practice.class_20.standardIO;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

// Standard I/O: the user's program can
// take input from a keyboard
// and then produce an output on the computer screen
public class StandardIOPractice {
  public static void main(String[] args) throws IOException{
    StandardIOPractice.standardIOE();
  }

  // 1. Standard Input/Output/Error
  // byte by byte reading, convert to char, use q to stop.
  public static void standardIOE() throws IOException {
    InputStreamReader cin = null; // charater input
    try {
      cin = new InputStreamReader(System.in);
      StringBuilder userInput = new StringBuilder();
      System.out.println("Enter characters. Enter 'q' to quit.");
      while (true) {
        char c = (char) cin.read();
        if (c == 'q') {
          break;
        }
        userInput.append(c);
      }
      System.out.println(userInput.toString());
    } finally {
      if (cin != null) {
        cin.close();
      }
    }
  }

  //
}
