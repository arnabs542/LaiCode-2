package com.study.algorithms.class07_Heap_and_Graph_Search;

public class Dijkstra_BFS_2 {
    // BFS 1: 使用queue （分层打印、Bipartite）
    // BFS 2: 使用priority queue （Dijkstra）

    // BFS 2可以求最短路径（非负cost），单源 到 其他所有的点的最短路径
    // BFS 1也可以求最短路径，但是必须在没有weight的图里。
    // 注意：node只能expand一次，可以多次generate。 generate的东西，可以更新visited的内容，但是不能加入queue（queue里的是expand对象）

    // 何时使用
    // BFS 1: Level 内的关系
    // BFS 2: shortest path。 一般要建模（Kth Smallest in sorted matrix）
}
