package com.study.algorithms.class10_recursion_2.string;

public class AbbriviationMatch {
  // 有一种奇特的缩写：
  // book --> 4, 101k, b3, b2k, ...

  // valid example:
  // s tu d en t
  // s 2 d 2 t

  // invalid example
  // zoooooooom
  // z3m

  // base case:
  // - one at end prior to another return false
  // - both at end return true
  // also:
  // - not match early return false. --> not match: too many or too few (exceed or letters don't match)

  // recursive rule:
  // 1. a letter in pattern:
  //    - match the letter
  //    - recursively match the rest
  // 2. a number in pattern:
  //    - jump over this number of letters
  //    - recursively match the rest

  // how many levels in recursion tree? - O(text.length)=O(n)
  // each level consumes O(1) --> total time O(n)

  public boolean match(String text, String pattern) {
    // assume only contains letter and number.
    char[] textArray = text.toCharArray();
    char[] patternArray = pattern.toCharArray();
    return match(textArray, 0, patternArray, 0);
  }
  private boolean match(char[] text, int ti, char[] pattern, int pi) {
    // base case:
    if (ti == text.length && pi == pattern.length) {
      // return true only when both string become empty at the same time.
      return true;
    } else if (ti == text.length || pi == pattern.length) {
      // return false when one of them become empty prior to another.
      return false;
    }

    // recursive rule:
    if (isLetter(pattern[pi])) {
      if (text[ti] != pattern[pi]) {
        return false;
      }
      return match(text, ti + 1, pattern, pi + 1);
    } else if (isDigit(pattern[pi])) {
      // number可能不止1位，要考虑多位的情况：
      int number = 0;
      while (pi < pattern.length && isDigit(pattern[pi])) {  // Error1: ip可能越界
        number = number * 10 + (pattern[pi] - '0');
        pi++;
      }
      if (ti + number > text.length) {
        return false;                                       // Error2: ti + number == text.length的情况要交给base case来处理。不能这里early return。
      }
      return match(text, ti + number, pattern, pi);
    }
    return false; // not digit or letter, invalid input;
  }

  private boolean isLetter(char c) {
    return ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z');
  }

  private boolean isDigit(char c) {
    return '0' <= c && c <= '9';
  }

  public boolean match_iterative(String text, String pattern) {
    int ti = 0;
    int pi = 0;
    while (ti < text.length() && pi < pattern.length()) {
      // case 1:
      if (isLetter(pattern.charAt(pi))) {
        if (text.charAt(ti) != pattern.charAt(pi)) {
          return false;
        }
        ti++;
        pi++;
      } else if (isDigit(pattern.charAt(pi))) {
        int number = 0;
        while (pi < pattern.length() && isDigit(pattern.charAt(pi))) {
          number = number * 10 + (pattern.charAt(pi) - '0');
          pi++;
        }
        ti += number;
      } else {
        return false; // invalid input
      }
    }
    // post processing:
    return ti == text.length() && pi == pattern.length();
  }
}
