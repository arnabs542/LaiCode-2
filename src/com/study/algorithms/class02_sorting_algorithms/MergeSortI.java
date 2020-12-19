package com.study.algorithms.class02_sorting_algorithms;

public class MergeSortI {
    public int[] mergeSort(int[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }
        return mergeSort(array, 0, array.length - 1);
    }

    private int[] mergeSort(int[] array, int start, int end) {
        // base case:
        if (start == end) {
            return new int[]{array[start]};
        }
        // recursion rule
        int mid = start + (end - start) / 2;
        int[] leftResult = mergeSort(array, start, mid);
        int[] rightResult = mergeSort(array, mid + 1, end);
        return merge(leftResult, rightResult);
    }

    private int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int leftIndex = 0;
        int rightIndex = 0;
        int resultIndex = 0;

        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] < right[rightIndex]) {
                result[resultIndex] = left[leftIndex];
                resultIndex++;
                leftIndex++;
            } else {
                result[resultIndex] = right[rightIndex];
                resultIndex++;
                rightIndex++;
            }
        }
        // post processing
        while (leftIndex < left.length) {
            result[resultIndex] = left[leftIndex];
            resultIndex++;
            leftIndex++;
        }
        while (rightIndex < right.length) {
            result[resultIndex] = right[rightIndex];
            resultIndex++;
            rightIndex++;
        }
        return result;
    }
}
