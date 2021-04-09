//package com.study.algorithms.class10_recursion_2;
//
//import com.study.algorithms.class10_recursion_2.linkedlist.BinaryTreeUpsideDown;
//import com.study.algorithms.class10_recursion_2.string.AbbriviationMatch;
//import com.study.algorithms.class10_recursion_2.tree.MaxPathSumII;
//import com.study.algorithms.class10_recursion_2.two_dimensional.NQueens;
//import com.study.util.TreeNode;
//
//import java.util.List;
//
//public class Tester {
//
//  public static void main(String[] args) {
//    TreeNode root = new TreeNode(1);
//    root.left = new TreeNode(2);
//    root.right = new TreeNode(5);
//    root.left.left = new TreeNode(3);
//    root.left.right = new TreeNode(4);
//
//    BinaryTreeUpsideDown bt = new BinaryTreeUpsideDown();
//    TreeNode result = bt.reverse_iterative(root);
//
//
//    AbbriviationMatch match = new AbbriviationMatch();
//    String word = "student";
//    String pattern = "s2d3";
//    System.out.println(match.match(word,pattern));
//    System.out.println(match.match_iterative(word,pattern));
//
//
//    TreeNode root2 = new TreeNode(-91);
//    root2.left = new TreeNode(83);
//    root2.right = new TreeNode(68);
//    MaxPathSumII mps = new MaxPathSumII();
//    int max = mps.maxPathSum(root2);
//    System.out.println(max);
//
//    NQueens nQueens = new NQueens();
//    List<List<Integer>> solution= nQueens.nQueens(8);
//    System.out.println(solution);
//    System.out.println(solution.size());
//  }
//}
