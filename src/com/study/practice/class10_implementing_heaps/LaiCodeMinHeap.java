package com.study.practice.class10_implementing_heaps;

public class LaiCodeMinHeap {
    public int[] heapify(int[] array) {
         for (int i = (array.length - 1) / 2; i >= 0; i--) {
           percolateDown(array, i, array.length);
         }
         return array;
    }

    public int[] heapifyWithPercolateUp(int[] array) {
        int[] result = new int[array.length];
        for (int i = 0; i <= array.length - 1; i++) {
            result[i] = array[i];
            percolateUp(result, i, i + 1);
        }
        return result;
    }

    private void percolateDown(int[] array, int index, int size) { // index是当前幼帝的位置
        // sanity check
        if (index < 0 || index >= size) {
            return;
        }
        int leftIndex = index * 2 + 1;
        int rightIndex = index * 2 + 2;
        while (leftIndex <= size - 1) {
            int smallIndex = leftIndex;
            if (rightIndex <= size - 1 && array[rightIndex] < array[leftIndex]) {
                smallIndex =  rightIndex;
            }

            if (array[smallIndex] < array[index]) {
                swap(array, smallIndex, index);
            } else {
                break;
            }
            index = smallIndex;
            leftIndex = index * 2 + 1;
            rightIndex = index * 2 + 2;
        }
    }

    private void percolateUp(int[] array, int index, int size) { // 对index，进行percolateUp。index是太子当前的位置
        // sanity check
        if (index < 0 || index >= size) {
            return;
        }
        int parentIndex = (index - 1) / 2;
        while (parentIndex >= 0 && array[parentIndex] > array[index]) {
            swap(array, parentIndex, index);
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }

    private void swap(int[] array, int l, int r) {
        int tmp = array[l];
        array[l] = array[r];
        array[r] = tmp;
    }
}
