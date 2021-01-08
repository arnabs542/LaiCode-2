package com.study.algorithms.class13_DP_3;

import com.study.algorithms.class12_DP_2.*;

public class Tester {

  public static void main(String[] args) {
    System.out.println("DP-3");
    LargestCrossOfOnes cross = new LargestCrossOfOnes();
    int arm_length = cross.largest(new int[][]{{1,1,1,0,1},{1,0,1,1,1},{1,1,1,1,1},{1,0,1,1,0},{0,0,1,1,0}});
    System.out.println(arm_length);
  }
}
