package com.study.algorithms.class08_stringII;

public class RightShift {
  // "abc", 4 -> "cab"
  // "abcdef", 2 -> "efabcd"

  // treat it like:
  //    "ab cdef" --> "cdef ab" --> I love yahoo trick
  // 1. the input string is a sentence
  // 2. the input integer determine where the "space“ is
  //    for leftShift: length - n --> first letter of the second word
  //    for rightShift: n --> first letter of the second word

  public String rightShift(String input, int n) {
    // corner cases:
    if (input == null || input.length() <= 1) {
      return input;
    }
    char[] array = input.toCharArray();
    n %= input.length(); // n may be very large.
    // step 1
    reverse(array, 0, array.length - 1); // abcdef -> fedcba
    // step 2
    reverse(array, 0, n - 1); // fe dcba -> ef dcba
    reverse(array, n, array.length - 1); // ef dcba -> ef abcd
    return new String(array);
  }

  private void reverse(char[] input, int left, int right) {
    while (left < right) {
      char temp = input[left];
      input[left] = input[right];
      input[right] = temp;
      left++;
      right--;
    }
  }
}
