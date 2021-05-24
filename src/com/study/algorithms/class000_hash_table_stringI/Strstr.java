package com.study.algorithms.class000_hash_table_stringI;

public class Strstr {
  // Determine if a small string is a substring of another large string
  // return the index of the first occurrence of the small string in the large string
  // return -1 if the small string is not a substring of the large one

  // Native: time O(m^2), m = # of letters in large.
  public int strstrI(String large, String small) {
    // corner cases:
    // return -1 if large is smaller than small
    if (large.length() < small.length()) {
      return -1;
    }
    // return 0 if small is empty
    if (small.length() == 0) {
      return 0;
    }

    // logic: 滑动窗口匹配
    for (int i = 0; i <= large.length() - small.length(); i++) {
      // "abc"
      //  01
      // "bc"
      // if (large.startsWith(small, i)) 可以用这个API，但是不知道具体实现方法。也不知道具体的复杂度。
      // 不用这个API，我们可以自己写一个字符匹配。while循环查找滑动窗口内的匹配项(合并了一个if到while里面)
      // 这个方法每个for里面有个O(n)复杂度的东西
      int j = 0;
      while (j < small.length() && large.charAt(i + j) == small.charAt(j)) {
        j++;
      }
      if (j == small.length()) {
        return i;
      }
    }
    return -1;
  }

  // Rabin-Karp:
  // 如果只有26个字母，所以可以把一个滑动窗口当成一组26进制数
  // 用Rabin-Karp，可以在每次重新计算hash的时候，只消耗O(1)的时间而非O(n)的时间。

  // Time: O(n+m + (m-n)) = O(2m)
  //    Initialization: O(n) + O(m)
  //    Each time we move the sliding window: O(1), Move (m-n) steps
  // n = # of char in small, m = # of char in large

  // I know there are another solution also can solve it in O(n)
  // which is KMP algorithm.

  // Rabin-Karp -- 26 small letter version
  public int strstrII(String large, String small) {
    // corner case: (assume they are not null)
    if (large == null || large.length() < small.length()) {
      return -1;
    }
    if (small.length() == 0) {
      return 0;
    }

    // if we can hash the short string to a unique integer.
    long smallHash = initHash(small, small.length());
    // then we can just compare each substring of large's hashed value with it.
    // tricks to compute this number:
    // 1. delete the top digit      abc -> _bc
    // 2. remaining part * 26       _bc -> bc_
    // 3. add the lowest digit      bc_ -> bcd
    long largeHash = initHash(large, small.length());
    if (smallHash == largeHash) {
      return 0;
    }
    for (int i = 1; i <= large.length() - small.length(); i++) {
      largeHash -= val(large.charAt(i - 1)) * (Math.pow(26, small.length() - 1)); // 1. delete the top digit      abc -> _bc
      largeHash *= 26;                                            // 2. remaining part * 26       _bc -> bc_
      largeHash += val(large.charAt(i + small.length() - 1));         // 3. add the lowest digit      bc_ -> bcd
      if (largeHash == smallHash) {
        return i;
      }
    }
    return -1;
  }

  private long initHash(String str, int length) {
    long hash = 0;
    for (int i = 0; i < length; i++) {
      hash *= 26;
      hash += val(str.charAt(i));
    }
    return hash;
  }

  private int val(char c) {
    return (int) (c - 'a');
  }

  // Rabin-Karp -- updated with smallPrime 31 and largePrime 101,
  // it can process all Unicode char,
  // it can process substring that length > 14.
  // it need an additional checkEqual func to handle collision
  public int strstrIII(String large, String small) {
    // corner case: (assume they are not null)
    if (large == null || large.length() < small.length()) {
      return -1;
    }
    if (small.length() == 0) {
      return 0;
    }

    int smallP = 31;  // small prime and large prime
    int largeP = 101;
    // if we can hash the short string to a hash value
    int seed = 0;
    int smallHash = 0;
    int largeHash = 0;
    for (int i = 0; i < small.length(); i++) {
      // seed = (1*smallP^k + 0*smallP^(k-1) + ... + 0*smallP^0) % largeP
      if (i == 0) {
        seed = moduleHashAdd(seed, 1, smallP, largeP);
      } else {
        seed = moduleHashAdd(seed, 0, smallP, largeP);
      }
      // hash = (c_1*smallP^k + c_2*smallP^(k-1) + ... + c_k*smallP^0) % largeP
      smallHash = moduleHashAdd(smallHash, small.charAt(i), smallP, largeP);
      largeHash = moduleHashAdd(largeHash, large.charAt(i), smallP, largeP);
    }
    if (smallHash == largeHash && checkEqual(large, small, 0)) {
      return 0;
    }

    // and then compare it with each hash value of each sliding window
    for (int i = 1; i <= large.length() - small.length(); i++) {
      // 注意，不能用abs，要保证依然是largePrime的mode结果才行。
      largeHash = moduleHashRemove(largeHash, seed * large.charAt(i - 1), largeP);
      largeHash = moduleHashAdd(largeHash, large.charAt(i + small.length() - 1), smallP, largeP);
      if (largeHash == smallHash && checkEqual(large, small, i)) {
        return i;
      }
    }
    return -1;
  }

  private int moduleHashAdd(int hash, int addition, int smallP, int largeP) {
    return (hash * smallP % largeP + addition % largeP) % largeP;
  }

  private int moduleHashRemove(int hash, int deduction, int largeP) {
    return NonNegative((hash % largeP - deduction % largeP) % largeP, largeP);
  }

  private int NonNegative(int hash, int largeP) {
    return hash >= 0 ? hash : hash + largeP;
  }

  private boolean checkEqual(String large, String small, int start) {
    for (int i = 0; i < small.length(); i++) {
      if (large.charAt(i + start) != small.charAt(i)) {
        return false;
      }
    }
    return true;
  }

  /*
  模运算与基本四则运算有些相似，但是除法例外。其规则如下：
      (a + b) % p = (a % p + b % p) % p   (1)
      (a - b) % p = (a % p - b % p) % p   (2)
      (a * b) % p = (a % p * b % p) % p   (3)
      a ^ b % p = ((a % p)^b) % p         (4)
  结合律：
    ((a+b) % p + c) % p = (a + (b+c) % p) % p   (5)
    ((a*b) % p * c)% p = (a * (b*c) % p) % p    (6)
  交换律：
    (a + b) % p = (b+a) % p               (7)
    (a * b) % p = (b * a) % p             (8)
  分配律：
    ((a +b)% p * c) % p = ((a * c) % p + (b * c) % p) % p   (9)


   滚动hash的算法：
   hash = (c_1*smallP^k + c_2*smallP^(k-1) + ... + c_k*smallP^0) % largeP
   使用规则(1) 得知：
   hash = (c_1*smallP^k + c_2*smallP^(k-1) + ... + c_k*smallP^0) % largeP
        = (c_1*smallP^k % largeP + c_2*smallP^(k-1) % largeP + ... + c_k*smallP^0 % largeP) % largeP

   每次删除最高位的时候，用规则(2)得知：
   hash = (hash - 最高位的值 % largeP) % largeP
   最高位的值 = seed * larget.charAt(i-1). seed负责将低位变换到最高位。
   删除后，要绝对值处理，因为可能为负数了。

   seed的求法：根据规则(3)需要用到moduleHash函数。

   每次进位与添加低位的时候，根据规则(1)(3)可知：
   hash = (hash*smallP % largeP  +  低位 % largeP) % largeP
              (3)                 (1)


   把上述这些 先mode largeP，再加起来，再mode largeP的过程抽出来，
   作为一个moduleHash函数。
  * */
}
