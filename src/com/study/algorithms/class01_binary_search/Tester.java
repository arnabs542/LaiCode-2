package com.study.algorithms.class01_binary_search;

import java.util.Arrays;

public class Tester {
  public static void main(String[] args) {
    ClassicalBinarySearch bs = new ClassicalBinarySearch();
    int result1 = bs.binarySearch(new int[]{1, 3, 5, 7, 9}, 9);
    System.out.println(result1); // 4

    SearchInSortedMatrix bsMatrix = new SearchInSortedMatrix();
    int[][] matrix = {{1, 3, 5}, {7, 9, 11}};
    int[] result2 = bsMatrix.search(matrix, 3);
    System.out.println(Arrays.toString(result2)); // [0, 1]

    int[][] matrix2 = {{1, 2, 3, 4}};
    result2 = bsMatrix.search(matrix2, 2);
    System.out.println(Arrays.toString(result2)); // [0, 1]

    // largestSmaller
    int[] array = {1, 2, 5, 7, 9};
    LargestElementSmallerThanTarget largestSmaller = new LargestElementSmallerThanTarget();
    int result3 = largestSmaller.largestElementSmallerThanTarget(array, 3);
    System.out.println(result3); // 1 --> i.e. value 2

    // smallestLarger
    SmallestElementLargerThanTarget smallestLarger = new SmallestElementLargerThanTarget();
    result3 = smallestLarger.smallestElementLargerThanTarget(array, 3);
    System.out.println(result3); // 2 --> index 2 i.e. value 5

    KClosest kClosest = new KClosest();
    int[] result4 = kClosest.kClosest(array, 10, 3);
    System.out.println(Arrays.toString(result4));
  }
}
