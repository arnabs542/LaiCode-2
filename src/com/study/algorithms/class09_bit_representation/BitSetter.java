package com.study.algorithms.class09_bit_representation;

public class BitSetter {
  // Given a number x, set x's k-th bit to 1
  public int bitSetter(int x, int k) {
    // 0 0 1 0 0 0 0 0
    // 1 0 0 1 0 1 0 1 应该是或起来就行了
    return x | (1 << k);
  }
}
