package com.study.project_final;

import com.study.algorithms.finalexam.question1;
import com.study.algorithms.finalexam.question2;
import com.study.algorithms.finalexam.question3;
import com.study.algorithms.finalexam.question4;
import com.study.util.TreeNode;

public class Tester {

  public static void main(String[] args) {
    MergeNPilesOfSands merge = new MergeNPilesOfSands();
    int[] array = new int[]{13,7,8};
    int K = 2;
    System.out.println(merge.mergeSands(array, K));
  }
}
