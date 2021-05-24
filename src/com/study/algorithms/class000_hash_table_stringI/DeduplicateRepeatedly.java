package com.study.algorithms.class000_hash_table_stringI;

import java.util.ArrayDeque;
import java.util.Deque;

public class DeduplicateRepeatedly {
  // Repeatedly remove all adjacent, repeated characters in a given string from left to right
  // "aabccdc" → "bccdc" → "bdc"

  // 简单的dedup中，不需要repeated。所以扫描一次就行了。
  // 现在改用一个完全不同的思想来解决这个问题：用stack不断处理
  // 本处stack的作用：
  //      把这个过程："aaabccdc" → "bccdc" → "bdc"
  //      变成这样：
  /*      stack       input
   *       a           a      跳过所有a，随后pop掉a
   *       _           b
   *       b           c
   *       bc          c      跳过所有c，随后pop掉c
   *       b           d
   *       bd          c
   *       bdc         $ 终结
   * */
  //

  public String deDup(String input) {
    // corner case
    if (input == null || input.length() == 0) {
      return input;
    }

    char[] array = input.toCharArray();
    // Stack:
    Deque<Character> stack = new ArrayDeque<>();
    stack.offerFirst(array[0]);
    int cur = 1;
    while (cur < array.length) {
      // if (stack.peekFirst() == array[cur]) {  <-- NPE, 因为peekFirst返回null，然后左边reference type右边primitive type，会尝试unbox null。
      if (!stack.isEmpty() && stack.peekFirst() == array[cur]) {
        // while (array[cur] == stack.peekFirst()) { <-- ArrayIndexOutOfBoundsException , 因为array[cur]可能下标越界，要先检查在不在范围内。
        while (cur < array.length && array[cur] == stack.peekFirst()) {
          cur++;
        }
        stack.pollFirst(); // 不能一次只删掉一对
        continue;
      } else {
        stack.offerFirst(array[cur]);
        cur++;
      }
    }
    int length = stack.size();
    for (int i = length - 1; i >= 0; i--) {
      array[i] = stack.pollFirst();
    }
    return new String(array, 0, length);
  }
}
