package com.study.algorithms.midterm;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DictionaryWord {
  // input: String[] dict, String s
  // output: boolean

  // DP: increase problem size from base case
  // meaning: M[i] represents whether the first i letters can be broken down into dict words; i: [0,length]
  // base rule: M[0] true.
  // induction rule: M[i] = OR(results of all cases) j: [0 to i)
  // one case: cut after first j letters:
  //      left part (first j letters)  |       right part (word.subString(j, i))
  //      M[j]                         AND     dict contains it or not

  public boolean canBreak(String s, String[] dict) {
    Set<String> dictSet = toSet(dict);
    boolean M[] = new boolean[s.length() + 1];
    // base rule: M[0] true
    M[0] = true;
    // indcution rule: for first i letters
    for (int i = 1; i <= s.length(); i++) {
      for (int j = 0; j < i; j++) { // rightmost cut is after first j letters
        // left part first j letters
        if (M[j] && dictSet.contains(s.substring(j, i))) {
          M[i] = true;
          break;
        }
      }
    }
    return M[s.length()];
  }

  private Set<String> toSet(String[] dict) {
    Set<String> set = new HashSet<>();
    for (String s : dict) {
      set.add(s);
    }
    return set;
  }
}
