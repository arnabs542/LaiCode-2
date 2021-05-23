package com.study.practice.class07_graph_binary_tree_I;

import java.util.ArrayList;
import java.util.List;

// Graph:
// V: vertex
// E: Edge, min O, max O(V^2);  如果是O(V) 就是sparse graph了

// Graph representation
// 1. Adjacency Matrix - 不常用，除非dense，否则浪费空间
// 2. Adjacency List - 顶点List，每个bucket是一个neighbors的list。
//     但是要把node能成功抽象出来
// 3. 实际上，用这个Class：
public class GraphNode {
  int key;
  // store neighbors
  List<GraphNode> neighbors;
  public GraphNode(int key) {
    this.key = key;
    neighbors = new ArrayList<>();
  }
}
