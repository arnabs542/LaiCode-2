package com.study.algorithms.second_test;

import java.util.Set;

public class wordBreak {

  // 首先可以写一个递归的方法
  // M[i] 存储前i个字符的切法数量
  // 左大段是从0  -  i-1 这么多字符

  // M[i+1] = sum()

//  public int countBreak(Set<String> dict, String input) {
//
//  }


  // 考试的时候写了个recursion的方法

// input dictionary, word
// output int: using recorder to remember how may ways

//                         catsand
//  try to cut            /|||||\
//  check               (cat)
//                      /
//                    sand
//  try to cut        /||\
//  check           (sand)
//                  /
//            END


  public boolean wordBreak(Set<String> dict, String input, int index, int[] recorder) {
    // index mark the starting index, so we can stop if we run out of char

    // base case:
    if (index == input.length()) {
      recorder[0]++;
      return true; // use to check
    }

    for (int i = index + 1; i <= input.length(); i++) {
      // different cut
      // check
      if (dict.contains(input.substring(index, i))) {
        if (wordBreak(dict, input, i, recorder)) {
          return true;
        }
      }
    }

    return false;
  }
}
