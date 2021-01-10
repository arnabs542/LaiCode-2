package com.study.algorithms.class08_stringII;

import java.util.*;

public class PermutationsII {
  // 以前的版本：no duplicate letters in the input string a(bcde)，每个元素都会出现在result里，用DFS + swap
  // 现在的版本：maybe duplicate letters "a b1 b2 b3 c"
  // recursion tree:     # of letter layers,    each layer fill a position
  /*
  *                      a  b1 b2 b3 c
  *                  /   |        |     \    \
  *            a(bbbc)  b(abbc)  b(babc)  b(bbac) c(bbba)
  *  但是这样下去迟早会有重复的。
  *  因此限制：同一个节点下，同一个类型的letter，只能swap到开头一次。
  * */

  // Time: 第一层有n个节点，第二层有n-1个节点 ... 所以是O(n!)
  // Space: 每个node要维护一个O(# of branch) 来确保不重复
  //        在“粉色"路径上，各个node的hashmap大小之和，是等差数列求和，为O(n^2)



  // input: a String
  // output: a List<String>

  public List<String> permutations(String input) {
    // sanity check:
    if (input == null) {
      return null;
    }

    List<String> results = new ArrayList<>();
    char[] array = input.toCharArray();
    helper(array, 0, results);
    return results;
  }

  private void helper(char[] array, int index, List<String> results) {
    // base case:
    if (array.length == index) {
      results.add(new String(array));
    }
    // recursion rule:
    Set<Character> set = new HashSet<>();
    for (int i = index; i < array.length; i++) {
      // if not duplicated
      // NOTICE:不需要contains了，因为add会返回true、false。如果有了就是false。
      if (set.add(array[i])) { // add will return false if the value is exist
        swap(array, i, index);
        helper(array, index + 1, results);
        swap(array, i, index); // swap back
      }
    }
  }

  private void swap(char[] array, int i, int j) {
    char temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}
