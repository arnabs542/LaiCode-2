package com.study.practice.class_19.iterators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

// 迭代器指向的位置是元素之前的位置
public class IteratorTest {
  public static void main(String args[]) {
    List<Integer> list = new ArrayList<>();
    list.add(1);
    list.add(2);
    list.add(3);

    for (Iterator<Integer> iter = list.iterator(); iter.hasNext();) {
      System.out.println(iter.next()); // return the next value (iterator指向的是元素之前的隔板）
      iter.remove(); // remove last returned one
    }

    System.out.println(list);

    // [^0,1,2,3,4,5,6,7,8,9]
    // ^就是iterator的位置。prev返回它之前的值，next返回它之后的值。
    for (int i = 0; i < 10; i++) {
      list.add(i);
    }
    for (ListIterator<Integer> iter = list.listIterator(); iter.hasNext();) {
      System.out.println("next is: " + iter.next());
      if (iter.hasNext()) {
        System.out.println("next is: " + iter.next());
        System.out.println("prev is: " + iter.previous());
      }
    }
  }
}
