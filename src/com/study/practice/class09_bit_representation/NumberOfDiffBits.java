package com.study.practice.class09_bit_representation;

// Determine the number of bits that are different for two given integers.
// Examples:   5(“0101”) and 8(“1000”) has 3 different bits

public class NumberOfDiffBits {
  // 我感觉可以用异或 + count,  也可以一个一个比较
  public int diffBits(int a, int b) {
    int x = a ^ b;
    int count = 0;
//    while (x > 0) { 错误，可以小于0
    while (x != 0) {
      count += x & 1;
      x = x >>> 1;
    }
    return count;
  }
}
