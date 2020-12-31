package com.study.util;

import java.util.HashSet;
import java.util.Set;

public class ToSet {
  public static Set<String> toSet(String[] dict) {
    Set<String> set = new HashSet<>();
    for (String s : dict) {
      set.add(s);
    }
    return set;
  }
}
