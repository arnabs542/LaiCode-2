package com.study.algorithms.class07_Heap_and_Graph_Search;

import java.util.Arrays;

public class KSmallest_QuickSelect {
    // QuickSelect 总结：
    // 1. 目的：给定 区间[left, right]和下标num， 确保[left, num]部分是[left, right]里面最小的部分 --> 但是不代表 [left, k], k<num 是最小
    // 2. 易错点：递归原则，要求pivotIndex刚好等于k才行，大了不能保证前k个是smallest，小了后面几个元素可能不够small；  另外，partition也容易错。
    // 3. 结构：
    //      kSmallest
    //          --- quickSelect
    //                -- partition -> 挡板法分割并返回pivotIndex
    //                -- quickSelect -> 分情况递归
    //          --- Arrays.copyOf
    //          --- Arrays.sort




    // 求前k小个，也有的地方说是第k小。 其实解法一样。
    // 1. MaxHeap:
    //    - time: O(k + (n-k)logk)  logk 是 log(size) size最大k
    //    - space: O(k)
    // 2. Quick Select: 每次只用考虑一侧
    //                  一次quickSelect：l, r, num.   要求l开始的(num-l)个元素，是最小的那几个。
    //                  策略：
    //                      当前pivot 位置小于 num：则为了让num左侧是smallest，应该对pivot + 1, right 进行quickSelect
    //                      当前pivot 位置大于 num：为了意味着num之前肯定小（pivot之前都是smallest）
    //                      当前pivot 位置 == num：返回，因为num之前都smallest了
    //
    //    - time:   平均情况， 每次选中中央，开销是：n/2, n/4, n/8 ... ==> 加起来是不超过n 所以是O(n)
    //              最差情况，每次partition都很不巧选的很差，是n, n-1, n-2, ... ==> 加起来O(n^2)
    //    - space:  递归最多O(height), 但是可以改写成非递归的形式

    public int[] kSmallest(int[] array, int k) {
        // corner case:
        if (array == null || array.length == 0 || k == 0) {
            return new int[0];
        }

        quickSelect(array, 0, array.length - 1, k - 1); // 转换为下标

        int[] result = Arrays.copyOf(array, k);
        Arrays.sort(result);
        return result;
    }

    // 确保在[left, right]这一段中， [left, num]部分是[left, right]里面最小的部分 --> 但是不代表 [left, k], k<num 是最小
    private void quickSelect(int[] array, int left, int right, int num) {
        int pivotIndex = partition(array, left, right);
        if (pivotIndex == num) {
            return;
        } else if (pivotIndex < num) {
            // 还需要继续向右扩展
            quickSelect(array, pivotIndex + 1, right, num);
        } else {
            // 需要细化，前num个是前num小，不代表前k是前k小。
            quickSelect(array, left, pivotIndex - 1, num);
        }
    }

    // 1 2 3 4
    //         s
    //       e

    // 进行切分
    private int partition(int[] array, int left, int right) {
        int pivotIndex = right;
        int pivotValue = array[pivotIndex];
        swap(array, pivotIndex, left);
        int start = left + 1; // 空出pivot
        int end = right; // start 左侧，是比pivot小的。end 右侧，是比pivot大与等于的。

        while (start <= end) {
            if (array[start] < pivotValue) {
                start++;
            } else {
                swap(array, start, end);
                end--;
            }
        }
        swap(array, end, left); // 此时end在start左侧，指向了一个属于小于pivot的元素，所以array应该从left和end替换，而不是和start替换。
        // 如果一开始把pivot换到右侧，那么此时应该和start对换，应为pivot本来应该的位置是一个大于pivot的值。也就是start此时指向的位置
        return end;
    }

    private void swap(int[] array, int start, int end) {
        int tmp = array[start];
        array[start] = array[end];
        array[end] = tmp;
    }
}
