package com.study.algorithms.class01_binary_search;

public class KClosest {
    public int[] kClosest(int[] array, int target, int k) {
        // 1. find the largest smaller equal (adjust largest smaller)
        // 2. do expansion. - or use the advance version
        if (array == null || array.length == 0) {
            return array;
        }
        if (k == 0) {
            return new int[0];
        }

        int left = largestSmallerEqual(array, target);
        int right = left + 1;
        int[] result = new int[k];
        // 两边开花
        for (int i = 0; i < k; i++) {
            // 都没了返回这个不满的result
            if (left < 0 && right > array.length - 1) {
                return result;
            }
            // 左边没了就加右边
            else if (left < 0) {
                result[i] = array[right];
                right++;
            }
            // 右边没有了就加左边
            else if (right > array.length - 1) {
                result[i] = array[left];
                left--;
            }
            // 都有，就比较大小，谁近移谁
            else {
                if (target - array[left] > array[right] - target) {
                    result[i] = array[right];
                    right++;
                } else {
                    result[i] = array[left];
                    left--;
                }
            }
        }
        return result;
    }

    public int largestSmallerEqual(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }
        if (array[0] > target) {
            return -1;
        }
        if (array[array.length - 1] < target) { // 删掉等于。
            return array.length - 1;
        }

        int left = 0;
        int right = array.length - 1;
        while (left < right - 1) { // left 一旦到达right-1就应该退出进行后处理
            int mid = left + (right - left) / 2;
            if (array[mid] <= target) { //  <= target 中可能有答案
                left = mid;
            } else {  // > target都要删掉
                right = mid - 1;
            }
        }
        if (array[right] <= target) {
            // right 更大
            return right;
        } else if (array[left] <= target) {
            return left;
        }
        return -1;
    }
}
