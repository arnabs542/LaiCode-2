package com.study.algorithms.class18_cross_training_1.oneD;

import java.util.ArrayDeque;
import java.util.Deque;

public class DeduplicateRepeatedly {
  // 1 2 2 2 1 3 --> 3

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
        stack.offerFirst(array[cur]);                  // w++
        cur++;
      }
    }
    int length = stack.size();
    for (int i = length - 1; i >= 0; i--) {
      array[i] = stack.pollFirst();                     // w--
    }
    return new String(array, 0, length);
  }

  // Method 2: Don't need stack:
  // writer: will write here, the writer-1 is the last processed one
  // reader: the index being processed
  // [writer, reader) --> garbage

  // [0, writer - 1] --> my "stack", 栈顶是array[writer - 1]

  // 1 2 2 2 1 3 ==> 3
  // Initialize: f = 0, s = 0
  // For each step:
  // Case 1:  if a[r] != a[w - 1], then a[w] = a[r], 都++  <-- 模拟和top比较。
  // Case 2:  if a[r] == a[w - 1], then （keep f++ unitl a[r] != a[w - 1]）
  //                                      r++到一个依然在范围内且不等于的情况。
  //                               then w--.               <-- 模拟出栈！
  


}
