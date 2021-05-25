package com.study.practice.class09_bit_representation;

public class BitResetter {
  // 与setter相反，设置第k位为0，而不是1.
  // 沿用setter的思路，但是取个反就能获得 1111011111...
  // 注意：别用11111111...110来左移，因为左移始终补零。
  public int resetter(int x, int k) {
    return x & (~(1 << k));
  }
}
