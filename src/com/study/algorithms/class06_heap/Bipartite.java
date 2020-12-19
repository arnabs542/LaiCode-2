package com.study.algorithms.class06_heap;

import com.study.util.GraphNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Bipartite {
    /*
    Assumptions:
    1. the given graph is not null.
     */
    public boolean isBipartite(List<GraphNode> graph) {
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
}
