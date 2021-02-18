package com.study.algorithms.finalexam;

import java.util.ArrayList;
import java.util.List;

public class question4 {
  // infinite loop around the dinner table
  // input: an array of names(capital letters)
  // output: if we can arrange the students so that the names of all students around the table form an "infinite loop"
  //         i.e.  for each pair of neighboring students s1 and s2, the last letter of s1's name must be identical to the first letter of s2's name
  //               名字接龙，而且能构成循环

  // DFS:
  // how many layers: num of names
  // what a layer do: select the correct name from the remaining names.
  // how many branch: depends on the # of matched students, O(n) n is the number of names.

  // in base case: check if the last one's last letter match the first one's first letter
  // if match then return true;

  // what i expect from my children: true or false
  // if at least one true, return ture;
  // other wise, return false;

  public boolean canFormInfiniteLoop(String[] names) {
    // assume names is not null and have at least two names.
    List<String> nameArray = new ArrayList<>();
    nameArray.add(names[0]);
    return helper(names, 0, 0, nameArray);
  }

  private boolean helper(String[] names, int index, int size, List<String> nameArray) {
    // index: the index of last inserted name;
    // size: the size of settled students.

    // base case:
    if (size == names.length - 1) {
      // check
      String s1 = names[index];
      String s2 = names[0];
      return match(s1, s2);
    }

    // recursion rule:
    // try to find a matched student name
    boolean hasMatch = false;
    for (int i = index + 1; i < names.length; i++) {
      if (match(names[index], names[i])) {
        swap(names, index + 1, i);
        nameArray.add(names[index + 1]);
        if (helper(names, index + 1, size + 1, nameArray)) {
          hasMatch = true;
        }
        nameArray.remove(names[index + 1]);
        swap(names, index + 1, i);
      }
    }
    return hasMatch;
  }

  private boolean match(String s1, String s2) {
    if (s1.charAt(s1.length() - 1) == s2.charAt(0)) {
      return true;
    }
    return false;
  }

  private void swap(String[] names, int i, int j) {
    String temp = names[i];
    names[i] = names[j];
    names[j] = temp;
  }
}
