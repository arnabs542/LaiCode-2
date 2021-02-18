package com.study.algorithms.finalexam;

import java.util.ArrayList;
import java.util.List;

public class question1 {
  public List<String> allSchedules(String inputEvents) {
    // input: each university is represented as a single capital letter
    // output: all possible schedules. between two universities, there may be an "x"
    // use DFS to solve it.
    // # of slots layers
    // each layer two branches, take a break or not

    List<String> results = new ArrayList<>();
    if (inputEvents == null) {
      return results;
    }
    char[] events = inputEvents.toCharArray();
    StringBuilder sb = new StringBuilder();
    helper(events, 0, sb, results);
    return results;
  }

  private void helper(char[] events, int index, StringBuilder sb, List<String> results) {
    // index: the slot after the index letter is the slot under evaluation
    //        index: from 0 to length-2

    // base case
    if (index == events.length - 1) {
      sb.append(events[index]);
      results.add(sb.toString());
      sb.deleteCharAt(sb.length() - 1);
      return;
    }

    // recursion rule:
    // case 1: not break
    sb.append(events[index]);
    helper(events, index + 1, sb, results);
    sb.deleteCharAt(sb.length() - 1);
    // case 2: break
    sb.append(events[index]);
    sb.append("x");
    helper(events, index + 1, sb, results);
    sb.deleteCharAt(sb.length() - 1);
    sb.deleteCharAt(sb.length() - 1);
  }
}
