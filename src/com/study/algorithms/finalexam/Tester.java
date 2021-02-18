package com.study.algorithms.finalexam;

import com.study.algorithms.class22_DP_4.CuttingWoodII;
import com.study.util.TreeNode;

import java.util.Arrays;

public class Tester {

  public static void main(String[] args) {
    question1 q1 = new question1();
    System.out.println(q1.allSchedules("ABC"));

    question2 q2 = new question2();
    TreeNode root = new TreeNode(6);
    root.left = new TreeNode(3);
    root.right = new TreeNode(5);
    root.left.left = new TreeNode(7);
    root.left.right = new TreeNode(8);
    root.right.left = new TreeNode(1);
    root.right.right = new TreeNode(2);

    System.out.println(q2.areCousins(root, root.left.left, root.right.right));

    question3 q3 = new question3();
    System.out.println(q3.minBoxes(5));

    question4 q4 = new question4();
    System.out.println(q4.canFormInfiniteLoop(new String[]{"ALICE", "CHARLES", "ERIC", "SOPHIA"}));
  }
}
