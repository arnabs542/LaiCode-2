package com.study.practice.class10_implementing_heaps;

public class NewMinHeap {
    //------------------------------------------------------------------------
    // - min heap 需要的性质
    // 1. the parent node is the smallest node in the subtree rooted at itself --> heap's property
    // 2. the relation between the two child nodes can differ.
    //------------------------------------------------------------------------
    // - minHeap不必要是complete binary tree
    // the common implementation of a heap, is using a complete binary tree
    // !!!! 即最小堆的一种常用时间方案，是用完全二叉树。 而不是说一定要完全二叉树。
    //------------------------------------------------------------------------
    // - CBT -> 可以用数组表示
    // CBT parent到child的关系：
        // p: i
        // lc: 2*i+1
        // rc: 2*i+2
    //
        // c:i
        // p: (i-1)/2
    //
    //------------------------------------------------------------------------
    // 问：CBT为什么要做成一个array，而不是一个真的tree?
    // 答：1. 降低overhead（不需要parent指针，也能走到parent），
    //    2. 而且可以直接跳到目的地（比如直接跳到sibling or grandparent）。
    //------------------------------------------------------------------------

    // percolateUp()
    // When: offer a new element
    // How:  太子升职记 --> 加在第一个有空的地方，然后不断和parent比较。等到比parent大 or 到顶。
    // time: O(height)

    // percolateDown()
    // When: poll the root
    // How:  国王驾崩 --> 权臣不敢上位，新立傀儡幼帝 --> compare the elements with the smaller child.
    //       只要比孩子中的一个小，就要换下去。所以找孩子中的最小的来比较。
    // time: O(height)

    //------------------------------------------------------------------------
    // heapify()
    // when: convert an array into a heap in O(n) time
    // ----------------- 方案一 -----------------
    // how:
    //      1. 原理：当一个node左子树也是堆、右子树也是堆，对它本身percolateDown，就能让这一组nodes变成堆。
    //      2. 当前CBT的每个非叶子节点，都要做percolateDown。for each node that has at least one child, we perform percolateDown() action.
    // trick: 在CBT中，从第一个非叶子节点开始调整  它index = ((n-1)-1)/2 = n/2 - 1
    //       在array里从 n/2-1 开始向前percolateDown，就相当于是在tree里从下到上，从右到左进行处理。
    // time:
    //      错位相减法
    //      第k层，有2^k个nodes，每个开销是 (levels - k)
    //      列出来，乘以2，然后错位相减，可以得到一个等比数列，
    //      sum是 O(2^k)
    //      k是logn，所以sum是 O(n)

    // 不要乱猜，一定要记住计算的思想。 --> 可以算算，然后算错了，没关系。 但是不能脱口而出。

    // ----------------- 另一个方案：-----------------
    // 从空开始，使用percolateUp，一个一个offer进来
    // 那么这个方案，每个元素进来，会swap O(height), 最差是第2^(k-1)个要swap (k-1) 次
    // 用错位相减法，可以得到 O(k2^k)
    // 即 O(nlogn)
    // --------------------------------------------------------------------
    // 最本质的区别  -->  !!!!!! 在于最贵的操作的Nodes数量的不同 !!!!!!
    // 用percolateDown + 调整CBT，那么最贵的操作是接近root的，最下面一层根本不用swap。
    // 用percolateUp + offer，那么最贵的操作是leaf nodes，即最多的那一侧。
    // --------------------------------------------------------------------

    // Java没有update，但是可以提供update （Java觉得一个Queue不应该update）
    // --> udpate了以后，要判断percolateDown还是percolateUp --> 和源元素比：
    //  1. 比原元素大，那么优先级变小了，percolateDown
    //  2. 比原元素小，那么percolateUp
    // 二选一

    // Key Point:
    // 1. percolateUp:
    //      offer
    //      update, and smaller
    //
    // 2. percolateDown:
    //      poll
    //      heapify
    //      update, and bigger

    //
}
