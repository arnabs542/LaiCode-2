package com.study.algorithms.class23_graph_search_3;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class TopologicalSort {
  // graph is the adjacency list representation of course prerequisites.
  private int[] topologicalSort(List<List<Integer>> graph) {
    int numCourses = graph.size();
    int[] topologicalOrder = new int[numCourses];
    int[] incomingEdges = new int[numCourses];
    for (int x = 0; x < numCourses; x++) {
      for (int y : graph.get(x)) {
        incomingEdges[y]++;
      }
    }

    // nodes with no incoming edges.
    Queue<Integer> queue = new ArrayDeque<>();
    for (int x = 0; x < numCourses; x++) {
      if (incomingEdges[x] == 0) {
        queue.offer(x);
      }
    }

    int numExpanded = 0;
    while (!queue.isEmpty()) {
      int x = queue.poll();
      topologicalOrder[numExpanded++] = x;
      for (int y : graph.get(x)) {
        if (--incomingEdges[y] == 0) {
          queue.offer(y);
        }
      }
    }
    return numExpanded == numCourses ? topologicalOrder : new int[]{};
  }
}
