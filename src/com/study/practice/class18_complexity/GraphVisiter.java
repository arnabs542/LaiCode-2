package com.study.practice.class18_complexity;

// Each GraphNode has a field visited to mark if it is visited. Visit all nodes in List<GraphNode> graph.

import java.util.ArrayList;
import java.util.List;

class GraphVisiter {
  public void traverse(List<GraphNode> graph) {
    for (GraphNode n : graph) {
      if (!n.visited) {
        dfs(n);
      }
    }
  }

  private void dfs(GraphNode node) {
    node.visited = true;
    for (GraphNode n : node.nei) {
      if (!n.visited) {
        dfs(n);
      }
    }
  }
}

class GraphNode {
  public int value;
  public List<GraphNode> nei;
  boolean visited;

  public GraphNode(int v) {
    value = v;
    nei = new ArrayList<>();
    visited = false;
  }
}
