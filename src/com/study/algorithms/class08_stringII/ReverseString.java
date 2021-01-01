package com.study.algorithms.class08_stringII;

public class ReverseString {
  // apple --> elppa
  // in-place solution
  // we need two pointers

  // iterative
  // time: O(n), space: O(1)
  public String reverse(String input) {
    if (input == null || input.length() == 0) {
      return input;
    }

    char[] array = input.toCharArray();
    int i = 0;
    int j = array.length - 1;
    while (i <= j) {
      char temp = array[i];
      array[i] = array[j];
      array[j] = temp;
      i++;
      j--;
    }
    return new String(array);
  }

  // recursion
  // Time: O(n)
  // Space: O(n)
  public String reverseI(String input) {
    if (input == null || input.length() == 0) {
      return input;
    }
    char[] array = input.toCharArray();
    helper(array, 0, input.length() - 1);
    return new String(array);
  }

  private void helper(char[] array, int left, int right) {
    if (left >= right) {
      return;
    }
    char temp = array[left];
    array[left] = array[right];
    array[right] = temp;
    helper(array, left + 1, right - 1);
  }
}
