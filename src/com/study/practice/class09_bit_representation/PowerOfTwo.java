package com.study.practice.class09_bit_representation;

public class PowerOfTwo {
  // 普通思路：
  //    不断除以2，如果最终结果不是0那么不是2的幂

  // 二进制思路 - 1:
  //    只能有1个1 --> 1*2^n 才是power of 2

  // 二进制思路 - 2:
  //    将 (x) & (x-1)，可以删掉rightmost 1
  //
  //       ??1000000
  //     & ??0111111
  //    -->??0000000
  //
  //    如果是power2，&以后一定是大于0
  //    如果不是power2，&以后一定不等于0（最低位以外的1依然存在）

  // 二进制思路 - 1
  public boolean isPowerOfTwoI (int number) {
    // assume 0 is not power of two
    if (number <= 0) {
      return false;
    }
    // count the number of 1's
    int count = 0;
    while (number > 0) {
      count += number & 1;
      number = number >>> 1; // unsigned right shift
    }
    return count == 1;
  }

  // 二进制思路 - 2
  public boolean isPowerOfTwoII (int number) {
    if (number <= 0) {
      return false;
    }
    return (number & (number - 1)) == 0;
  }
}
