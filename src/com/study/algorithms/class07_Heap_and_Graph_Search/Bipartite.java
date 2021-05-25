package com.study.algorithms.class07_Heap_and_Graph_Search;

import com.study.util.GraphNode;

import java.util.*;

public class Bipartite {
  /*
  Assumptions:
  1. the given graph is not null.
   */
  public boolean isBipartite1(List<GraphNode> graph) {
    // use 0 and 1 to denote two different set.
    // the map maintains the belonging of each node
    HashMap<GraphNode, Integer> visited = new HashMap<>();
    // We do BFS here:
    for (GraphNode node : graph) {
      if (!BFS(node, visited)) {
        return false;
      }
    }
    return true;
  }

  public boolean BFS(GraphNode node, HashMap<GraphNode, Integer> visited) {
    // if this node has been traversed, no need to do BFS again.
    if (visited.containsKey(node)) {
      return true;
    }
    Queue<GraphNode> queue = new LinkedList<>();
    queue.offer(node);
    // start BFS from this unvisited(uncolored) node. we can assign it to a graph.
    visited.put(node, 0);
    while (!queue.isEmpty()) {
      GraphNode cur = queue.poll();
      int curGroup = visited.get(cur);
      int neiGroup = curGroup == 1 ? 0 : 1;

      for (GraphNode nei : cur.neighbors) {
        if (!visited.containsKey(nei)) {
          visited.put(nei, neiGroup);
          queue.offer(nei);
        } else if (visited.get(nei) != neiGroup) {
          return false;
        }
      }
    }
    return true;
  }


  // 重听，写Bipartite
  // whether a graph's node can be divided into two groups, such that the nodes in each group
  // do not have direct edges between the nodes that belong to the same group

  //       1
  //      /  \
  //     2 -- 3

  // queue [1]
  // generated{1u}

  // 1(u)           expand 1, 标记为u集合
  // 2(v), 3(v)     generate 2、3，标记欧威v集合
  // queue [2,3]
  // generated{1u,2v,3v}  -->  发现原来里面无2，3，所以加入。

  // 2(v)         expand 2
  // 1(u), 3(u)   generate 1,3
  // queue [3]
  // generated{1u,2v,3v} --> 发现1匹配，但是3不符合，return false

  // 发现3的集合归属有conflict。

  // 通过一个HashMap来查conflict，key是node，value是set归属
  public boolean isBipartite(List<GraphNode> graph) {
    if (graph == null || graph.isEmpty()) {
      return true;
    }
    Queue<GraphNode> queue = new ArrayDeque<>();
    HashMap<GraphNode, Integer> labelled = new HashMap<>(); // set_1 and set_0
    // 随后，让那个List中的每个节点，都BFS一次，看结果有没有冲突的
    for (GraphNode node : graph) { // 这个循环，只是担心可能图不是全联通的。出现不可达的地方。
      // 为了避免不同node开头取0时，互相矛盾的场景，踢掉连通区域的所有点
      if (labelled.containsKey(node)) {
        continue;
      }

      // BFS:
      queue.offer(node);
      labelled.put(node, 0);
      while (!queue.isEmpty()) {
        // expand:
        GraphNode cur = queue.poll();
        Integer setID = labelled.get(cur);
        if (setID == null) {
          return false; // impossible situation
        }
        int newID = (setID == 0) ? 1 : 0;

        // generate:
        for (GraphNode nei : cur.neighbors) {
          if (!labelled.containsKey(nei)) {
            queue.offer(nei);
            labelled.put(nei, newID); // normal case
          } else if (labelled.get(nei) != newID) {
            return false; // find a conflict case
          }
        }
      }
    }
    return true;
  }
}
