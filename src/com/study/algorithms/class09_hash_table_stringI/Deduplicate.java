package com.study.algorithms.class09_hash_table_stringI;

public class Deduplicate {
  // Remove adjacent, repeated characters in a given string
  // leaving only one character for each group of such characters.
  // “aabbbazw” => “abazw”

  // [0,i) output
  // [j, length) need to be evaluated

  // algo:
  // 1. initialization: i = 1, j = 1. 因为第一个字母一定要copy的嘛。
  //                    这样也可以方便地访问 [i-1]
  //  "a"
  // 2. for each j letter:
  //      case 1: 与处理过的最后一个值[i-1]相同，j++
  //      case 2: 不同，copy, i++, j++
  // "abazwazw"
  //       i  j
  // 3. output new String(array, 0, i)
  // "abazw"

  public String deDup(String input) {
    // corner case:
    if (input == null || input.length() == 0) {
      return input;
    }
    // Try to do it inplace,
    // So convert the String into char array (String is immutable)
    char[] array = input.toCharArray();
    int end = 1;
    for (int cur = 1; cur < array.length; cur++) {
      if (array[end - 1] != array[cur]) {
        array[end++] = array[cur];
      }
    }
    return new String(array, 0, end); // [0, end)
  }
}
