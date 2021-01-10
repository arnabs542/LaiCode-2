package com.study.algorithms.class08_stringII;

public class StringReplace {
  // Given an original string input, and two strings S and T,
  // from left to right replace all occurrences of S in input with T.

  // input: input, source, target
  // output: replaced input

  // case 1: source.length() >= target.length()
  // case 2: source.length() < target.length()

  public String replace(String input, String source, String target) {
    // Assumpetion: 1. input, source, target are not null  2. input and source are not empty
    char[] array = input.toCharArray();
    if (source.length() >= target.length()) {
      return replaceShorter(array, source, target);
    }
    return replaceLonger(array, source, target);
  }


  private String replaceShorter(char[] array, String source, String target) {
    int writer = 0; // next place to write
    int reader = 0; // the element to read
    while (reader < array.length) { // should loop through
      // if match --> replace and jump
      // if not match --> copy
      if (reader <= array.length - target.length() && equalSubstring(array, reader, source)) {
        copySubstring(array, writer, target);
        writer += target.length();
        reader += source.length();
      } else {
        array[writer] = array[reader];
        writer++;
        reader++;
      }
    }
    return new String(array, 0, writer);
  }

  private boolean equalSubstring(char[] array, int reader, String source) {
    for (int i = 0; i < source.length(); i++) {
      if (array[reader + i] != source.charAt(i)) {
        return false;
      }
    }
    return true;
  }

  private void copySubstring(char[] array, int writer, String target) {
    for (int i = 0; i < target.length(); i++) {
      array[writer + i] = target.charAt(i);
    }
  }

  private String replaceLonger(char[] array, String source, String target) {
    return null;
  }
}
