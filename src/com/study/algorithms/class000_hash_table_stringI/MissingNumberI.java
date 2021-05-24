package com.study.algorithms.class000_hash_table_stringI;

// Given an integer array of size N-1, containing al the numbers from 1 to N except one,
// find the missing number:

// Assumption:
// - assume the array is sorted?                Cannot assume
// - assume the array is not null or empty?     Can assume
// - return N if no missing?                    Can


import java.util.HashSet;

public class MissingNumberI {
  // Given an integer array of size N - 1
  // containing all the numbers from 1 to N except one number,
  // find the missing number.

  // I will return N if no missing number found.

  // Method 1: use HashSet
  // put all numbers into hashset, for i = 1 to i = n, check if the set contains it.
  // Time = O(n),
  // Space = O(n)
  public int missingI(int[] array) {
    int n = array.length + 1;
    HashSet<Integer> set = new HashSet<>();
    for (int num : array) {
      set.add(num);
    }
    for (int i = 1; i <= n; i++) {
      if (!set.contains(i)) {
        return i;
      }
    }
    return 0;
  }

  // Method 2: use sum
  // expectedSum = (1 + n) * n / 2
  // realSum = get the real sum
  // missingNum = expectedSum - realSum
  // Time = O(n)
  // Space = O(1) --> may need a long if there are too many numbers.
  public int missingII(int[] array) {
    int n = array.length + 1;
    long expectedSum = (1 + n) * n / 2;
    long realSum = 0L; // 0L means it is a long number
    for (int num : array) {
      realSum += num;
    }
    return (int) (expectedSum - realSum); // remember to cast to int
  }

  // Method 3: use exclusive or
  // Theory:
  //      111 XOR 111 = 000 - rule1
  //      000 XOR 111 = 111 - rule2
  // Usage:
  //      let:    XOR(all input numbers) = result1,    XOR(all expected numbers) = result2
  //      -> result1 XOR missing = result2
  //      -> result1 XOR missing XOR result2 = result2 XOR result2
  //      -> result1 XOR result2 XOR missing = 0
  //      -> result1 XOR result2 = missing
  //      -> XOR(1 to n and all input num) = missing
  // *Comprehension:
  //      all numbers from 1 to n are pair xor'ed except for the missing number
  //      since x ^ x = 0, the remaining number is the result:
  // Time = O(n)
  // Space = O(1)
  public int missingIII(int[] array) {
    int n = array.length + 1;
    // xor all expected num and all input num, and then can get the missing num
    int xor = 0;
    // step1: xor 1 to n
    for (int i = 1; i <= n; i++) {
      xor ^= i;
    }
    // step2: xor all input number
    for (int num : array) {
      xor ^= num;
    }
    return xor;
  }

}
