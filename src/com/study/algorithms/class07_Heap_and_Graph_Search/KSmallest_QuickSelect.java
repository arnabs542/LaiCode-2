package com.study.algorithms.class07_Heap_and_Graph_Search;

public class KSmallest_QuickSelect {
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




}
