package com.study.algorithms.class18_cross_training_1;

import com.study.algorithms.class18_cross_training_1.oneD.*;

import java.util.Arrays;

public class Teseter {
  public static void main(String[] args) {
//    Deduplication dedup1 = new Deduplication();
//    Deduplication_keepTwo dedup2 = new Deduplication_keepTwo();
//    DeduplicateRepeatedly dedup3 = new DeduplicateRepeatedly();
//    DeduplicateNotRepeatedly dedup4 = new DeduplicateNotRepeatedly();
//    System.out.println(Arrays.toString(dedup1.dedup(new int[]{1,2,2,2,3})));
//    System.out.println(Arrays.toString(dedup2.dedup(new int[]{1,2,2,2,3})));
//    System.out.println(Arrays.toString(dedup3.dedup(new int[]{1,2,2,2,1,3})));
//    System.out.println(Arrays.toString(dedup4.dedup(new int[]{1,1,2,3,3,4,5,5,5})));
//
//    MoveZerosToTheEnd moveZeros = new MoveZerosToTheEnd();
//    System.out.println(Arrays.toString(moveZeros.moveZero(new int[]{1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0})));

    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= 128; i++) {
      sb.append(" " + i + ",");
    }
    System.out.println(sb.toString());
  }
}
