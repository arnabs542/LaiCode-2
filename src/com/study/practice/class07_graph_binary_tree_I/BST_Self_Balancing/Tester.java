package com.study.practice.class07_graph_binary_tree_I.BST_Self_Balancing;

import java.util.TreeMap;
import java.util.TreeSet;

public class Tester {
  public static void main(String args[]) {
    // TreeMap / TreeSet 是Java中的类似Red-Black Tree的实现
    TreeMap<Integer, String> treeMap = new TreeMap<>();
    TreeSet<Integer> treeSet = new TreeSet<>();
    treeMap.put(1, "miao");
    treeMap.put(2, "wang");
    treeMap.put(4, "haha");
    System.out.println(treeMap.get(2));
  }
}
