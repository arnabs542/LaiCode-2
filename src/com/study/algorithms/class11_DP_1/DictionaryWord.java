package com.study.algorithms.class11_DP_1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DictionaryWord {
  // input: a string, a string array
  // output: boolean
  public boolean canBreak(String input, String[] dict) {
    /**
     * 在不在字典里 == 能不能切出字典中的word == 左大段表中有没有效 && 右小段能不能有效
     * 左大段在表中有没有效 == 查prefix表
     * 所以表格记录了每个prefix是T还是F
     * base case是一个字母都没有的情况，是F
     */
    // trick: use Set method: contains.
    Set<String> dictSet = toSet(dict);

    boolean[] prefix = new boolean[input.length() + 1];
    prefix[0] = true;
    for (int i = 1; i <= input.length(); i++) { // [0,i] is current problem size
      for (int j = 0; j < i; j++) {           // different cases, from cut nothing to cut i-1 as left part
        if (prefix[j] && dictSet.contains(input.substring(j, i))) {
          prefix[i] = true; // this problem solved iff left section is valid prefix, and right section is in dictionary
          break;
        }
      }
    }
    // used to debug:
    System.out.println(Arrays.toString(prefix)); // use Arrays.toString()
    System.out.println(input);
    return prefix[input.length()];
  }

  private Set<String> toSet(String[] dict) {
    Set<String> set = new HashSet<>();
    for (String s : dict) {
      set.add(s);
    }
    return set;
  }
}
