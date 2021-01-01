package com.study.algorithms.class08_stringII;

public class ReverseWords {
  // Whenever you want to reverse every component in a string
  // without change the inner order of each component,
  // you need --> I Love Yahoo Trick:
  // step1: reverse the whole sentence
  // step2: reverse every single word

  public String reverseWords(String input) {
    // Assumption: words are separated  by a single space
    if (input == null || input.length() == 0) {
      return input;
    }
    // inplcae
    char[] array = input.toCharArray();
    // step1: reverse the whole array:   i love yahoo --> oohay evol i
    reverse(array, 0, input.length() - 1);
    // step2: reverse each word:         oohay evol i --> yahoo love i
    int start = 0;
    for (int end = 0; end <= array.length; end++) {
      // yahoo love i
      //             e
      //            s
      if (end == array.length || array[end] == ' ') { // 第二个分支写在后面，防止越界
        reverse(array, start, end - 1);
        start = end + 1;
      }
    }
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
