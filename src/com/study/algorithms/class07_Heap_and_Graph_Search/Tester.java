package com.study.algorithms.class07_Heap_and_Graph_Search;

public class Tester {

  public static void main(String[] args) {
    /*
     *    1  3  5
     * 4  5  7  9
     * 8  9  11  13
     *
     * 5, 7, 9, 9, 11, 13
     * dijkstra, we need a cell
     */
    KthSmallest kthSmallest = new KthSmallest();
    int result = kthSmallest.kthSmallest(new int[]{1, 3, 5}, new int[]{4, 8}, 2);
    System.out.println(result);
  }
}
