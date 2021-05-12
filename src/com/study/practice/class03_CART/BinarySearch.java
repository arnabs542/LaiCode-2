package com.study.practice.class03_CART;

public class BinarySearch {
    // ascending order
    // 注意：移动下标的原理：确保每次搜索空间会减小，而且不能排除掉有可能的结果
    // 注意：循环的原理：不能陷入死循环（测试1、2个元素）

    // 找target
    public int binarySearch(int[] array, int target) {
        // corner case:
        if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }


    // 1 2 4 7 8 9   target = 5
    //     L
    //       R
    //     M
    // [偶数的M会在靠左这边]

    // 注意，L和R最终可能会挨着，此时应该挑出来，然后比较这俩哪个和target比较近

    // 找与target最接近的, 距离一样的, prefer 小的
    public int binarySearchClosest(int[] array, int target) {
        // corner case:
        if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        // loop:
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        // 如果只有1个元素，依然会走到这里。而且left == right == 0
        if (target - array[left] <= array[right] - target) {
            return left;
        } else {
            return right;
        }
    }


    // closet k elements
    // assumption: assume return an array holding closet k elements.
    // new corner case: k should be not null and k <= array.length. otherwise return empty array.

    // 1 2 4 7 8 9    target = 5, k = 3
    // L
    //           R
    //     M

    // step 1: find out the closet one                    O(log2(n))
    // step 2: post processing, expand L and R 谁小移谁     O(k)

    // 如果有一样的，prefer小的 --> 也是写成 <=

    public int[] kClosest(int[] array, int target, int k) {
        // corner case:
        if (array == null || array.length == 0) {
            return array; // 相当于return null 或者 return new int[0]
        }
        int closetIndex = binarySearchClosest(array, target); // prefer小的
        int left = closetIndex;
        int right = closetIndex + 1; // 可能已经越界，一会儿要检查.
        int[] result = new int[k];
        // 难点： 如何编写这个逻辑？
        // hint：
        //  1. 只思考两个分支（加左边或者加右边），不要搞一大堆if else，那样容易漏。
        //  2. 只修改其中一个分支，让它work: 比如何时加左边：
        // - 如果右边到头了，就加左边（保证k比n小）
        // - 如果左边没到头，而且左侧更近，就加左边
        for (int i = 0; i < k; i++) {
            if (right >= array.length ||
                    left >= 0 && target - array[left] <= array[right] - target) {
                result[i] = array[left--];
            } else {
                result[i] = array[right++];
            }
        }
        return result;
    }
}
