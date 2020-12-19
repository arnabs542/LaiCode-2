package com.study.algorithms.class02_sorting_algorithms;

public class MoveZeroI {
    // Move 0s to the right end of the array, no need to keep the relative order
    // of the elements in the original array
    // 注意：不care stable与否，所以可以用swap

    // [left, right] unchecked
    // [0, left) non-0s
    // (right, end] 0s

    public int[] moveZero(int[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            if (array[left] != 0) {
                left++;
            } else if(array[right] == 0) {
                right--;
            } else { //left -> 0, right -> not 0
                swap(array, left, right);
                right--;
            }
        }
        return array;
    }

    public void swap(int[] array, int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }
}
