package com.study.practice.class09_bit_representation;

// Reverse bits of a 32-bit integer.
public class ReverseBits {
  // String reversal的思路
  public int reverseBits(int n) {
    // 0 1 0 0 1 1 ... 0
    // j               i
    // high          low

    int high = 31;
    int low = 0;
    while (high > low) {
      n = swap(n, high, low);
      high--;
      low++;
    }
    return n;
  }

  private int swap(int n, int high, int low) {
    // bit tester
    int leftBit = (n >> high) & 1;
    int rightBit = (n >> low) & 1;
    if (leftBit == rightBit) {
      return n;
    } else {
      // bit toggle using xor
      n = n ^ (1 << high);
      n = n ^ (1 << low);
      return n;
    }
  }


  // String reversal的思路
  public long reverseBits(long n) {
    // 0 1 0 0 1 1 ... 0
    // j               i
    // high          low

    int high = 31;
    int low = 0;
    while (high > low) {
      n = swap(n, high, low);
      high--;
      low++;
    }
    return n;
  }

  private long swap(long n, int high, int low) {
    // bit tester
    long leftBit = (n >> high) & 1;
    long rightBit = (n >> low) & 1;
    if (leftBit == rightBit) {
      return n;
    } else {
      // bit toggle using xor
      n = n ^ (1L << high); // for long type, this should be 1L instead of 1.
      n = n ^ (1L << low);  // otherwise, there will be 32 prefix 1.
      return n;
    }
  }

  // MergeSort way of reversing all the bits:
  // 每次交换当前section的两个部分。
  // 12345678
  // 5678 1234

  // ... >> 2 --> 0056 0012
  // ... >> 2 --> 7800 3400
  // 0056 0012 | 7800 3400 = 78563412

  // 7050304010 >> 1 --> 0705030401
  // ... >> 1 --> xxxx

    public long reverseII(long num) {
      num = ((num & 0xFFFF0000) >>> 16) | ((num & 0x0000FFFF) << 16);
      num = ((num & 0xFF00FF00) >>> 8) | ((num & 0x00FF00FF) << 8); // 11111111
      num = ((num & 0xF0F0F0F0) >>> 4) | ((num & 0x0F0F0F0F) << 4); // 1111 --> 15 = F
      num = ((num & 0xCCCCCCCC) >>> 2) | ((num & 0x33333333) << 2); // 1100
      num = ((num & 0xAAAAAAAA) >>> 1) | ((num & 0x55555555) << 1); // 1010
      return num;
    }
}
