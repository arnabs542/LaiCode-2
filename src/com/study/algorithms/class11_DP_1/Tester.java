package com.study.algorithms.class11_DP_1;

public class Tester {

  public static void main(String[] args) {
    // write your code here
    FibonacciNumber fibonacciNumber = new FibonacciNumber();
    long fibo1 = fibonacciNumber.fibonacci(10);
    long fibo2 = fibonacciNumber.fibonacciII(10);
    System.out.println(fibo1);
    System.out.println(fibo2);

    LongestAscendingSubArray longestAscendingSubArray = new LongestAscendingSubArray();
    int result = longestAscendingSubArray.longest(new int[]{7, 2, 3, 1, 5, 8, 9, 6});
    System.out.println(result);

    MaxProductOfCuttingRope maxProductOfCuttingRope = new MaxProductOfCuttingRope();
    int max = maxProductOfCuttingRope.maxProduct(10);
    System.out.println(max);

    DictionaryWord dictionaryWord = new DictionaryWord();
    String input = "bobcatrob";
    String[] dict = new String[]{"bob", "cat", "rob"};
    dictionaryWord.canBreak(input, dict);
  }
}
