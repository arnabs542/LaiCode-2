package com.study.algorithms.class09_bit_representation;

// Generate the hexadecimal representation for a given non-negative integer number as a string.
// The hex representation should start with "0x".
public class HexRepresentation {
  // with leading zeros - 有时候这个更清晰。
  public String hex1(int number) {
    // we need a special kind of "bit tester" to know each hexadecimal digit's value
    // four bits = a digit --> use 0xF (1111) to get a digit
    // step1: (num >> 4 * (# of digits low than it)) & 0xF = its value
    // step2: change this value into char

    // corner case:
    if (number == 0) {
      return "0x0";
    }

    StringBuilder sb = new StringBuilder();
    sb.append("0x");
    for (int maskEnd = 28; maskEnd >= 0; maskEnd -= 4) {
      int rem = (number >> maskEnd) & 0xF;
      if (rem < 10) {
        sb.append((char) ('0' + rem));
      } else {
        sb.append((char) ('A' + rem - 10));
      }
    }
    return sb.toString();
    // if maskEnd starts from 0 and ends at 28, use .reverse() to reverse it
  }

  // without leading zeros
  public String hex2(int number) {
    // corner case:
    if (number == 0) {
      return "0x0";
    }

    StringBuilder sb = new StringBuilder();
    sb.append("0x");
    boolean isLeading = true;
    for (int maskEnd = 28; maskEnd >= 0; maskEnd -= 4) {
      int rem = (number >> maskEnd) & 0xF;
      if (rem == 0 && isLeading) {
        continue;
      } else if (rem < 10) {
        sb.append((char) ('0' + rem));
      } else {
        sb.append((char) ('A' + rem - 10));
      }
      isLeading = false;
    }
    return sb.toString();
    // if maskEnd starts from 0 and ends at 28, use .reverse() to reverse it
  }
}
