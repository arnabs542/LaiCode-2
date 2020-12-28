package com.study.algorithms.class12_DP_2;

public class Tester {

    public static void main(String[] args) {
        ArrayHopperII arrayHopperII = new ArrayHopperII();
        int[] array = new int[]{3, 3, 1, 0, 4};
        int minJump = arrayHopperII.minJump(array);
        boolean canJump = arrayHopperII.canJump(array);
        System.out.println(canJump); // true
        System.out.println(minJump); // 2


        LargestSubarraySum largestSubarraySum = new LargestSubarraySum();
        int[] array2 = new int[]{1,2,4,-1,-2,10,1};
        int largestSum = largestSubarraySum.largestSum(array2);
        System.out.println(largestSum);

        DictionaryWord dictionaryWord = new DictionaryWord();
        String input = "bobcatrob";
        String[] dict = new String[]{"bob", "cat", "rob"};
        boolean result = dictionaryWord.canBreak(input, dict);
        System.out.println(result);

        LargestSquareOfOnes largestSquareOfOnes = new LargestSquareOfOnes();
        int[][] matrix = new int[][]{{1,1,1,0},{0,1,1,0},{1,1,1,1},{1,1,1,0}};
        int largest = largestSquareOfOnes.largest(matrix);
        System.out.println(largest);

        EditDistance editDistance = new EditDistance();
        String word1 = "ab";
        String word2 = "dbbabc";
        int dist1 = editDistance.editDistanceRecursion(word1, word2);
        System.out.println(dist1);

        int dist2 = editDistance.editDistance(word1, word2);
        System.out.println(dist2);
    }
}
