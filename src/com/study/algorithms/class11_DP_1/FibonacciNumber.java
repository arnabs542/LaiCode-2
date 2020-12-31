package com.study.algorithms.class11_DP_1;

public class FibonacciNumber {
  // M[] array
  // index    0   1   2   3   4
  // M[i]     0   1   ...

  // space O(n), time O(n)
  public long fibonacci(int K) {
    // get the K-th number in the Fibonacci Sequence
    if (K <= 0) {
      return 0;
    }
    if (K == 1) {
      return 1;
    }
    long[] M = new long[K + 1]; // fibo is too big, we need a long array
    M[0] = 0;
    M[1] = 1;
    for (int i = 2; i <= K; i++) {
      M[i] = M[i - 1] + M[i - 2];
    }
    return M[K];
  }

  // space O(1), time O(n)
  public long fibonacciII(int K) {
    if (K <= 0) {
      return 0;
    }
    if (K == 1) {
      return 1;
    }
    long m = 0;
    long n = 1;
    for (int i = 2; i <= K; i++) {
      long temp = m + n;
      m = n;
      n = temp;
    }
    return n;
  }
}
