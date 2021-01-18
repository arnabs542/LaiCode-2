package com.study.algorithms.class18_cross_training_1;

import com.study.algorithms.class18_cross_training_1.oneD.Deduplication;

import java.util.Arrays;

public class Teseter {
  public static void main(String[] args) {
    Deduplication dedup1 = new Deduplication();
    System.out.println(Arrays.toString(dedup1.dedup(new int[]{1,2,2,2,1,3})));
  }
}
