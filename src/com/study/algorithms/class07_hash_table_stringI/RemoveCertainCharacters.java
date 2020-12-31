package com.study.algorithms.class07_hash_table_stringI;

import java.util.HashSet;
import java.util.Set;

public class RemoveCertainCharacters {
  // remove given characters in input string
  // the relative order of other characters should be remained
  // return the new string after deletion

  // e.g. input: "student", t: "un"
  //      output is "stdet"
  public String remove(String input, String t) {
    // two pointers:
    //      slow: the next place of processed part
    //      fast: the next element to be evaluated
    // fast pointer will jump over all needless char

    // We need to solve it with an in-place way
    // But Java String is immutable, so we convert it to char[]
    char[] array = input.toCharArray();
    // Get set of all distinct characters in t, so that look up is efficient
    Set<Character> set = buildSet(t);
    // [0, slow) processed
    // [fast, array.length) area to explore
    int slow = 0;
    int fast = 0;
    while (fast < array.length) {
      if (!set.contains(array[fast])) {
        array[slow] = array[fast];
        slow++;
        fast++;
      } else {
        fast++;
      }
    }
    return new String(array, 0, slow);
    // String(byte[] bytes, int offset, int length)
  }

  private Set<Character> buildSet(String t) {
    Set<Character> set = new HashSet<>();
    for (int i = 0; i < t.length(); i++) {
      set.add(t.charAt(i));
    }
    return set;
  }
}
