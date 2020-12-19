package com.study.algorithms.class06_heap;

/*
 *    1  3  5
 * 4  5  7  9
 * 8  9  11  13
 *
 * 5, 7, 9, 9, 11, 13
 * dijkstra, we need a cell
 */

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallest {
    static class Cell {
        int row; // from B index
        int col; // from A index
        int value; // A + B value
        Cell(int row, int col, int value) {
            this.row = row;
            this.col = col;
            this.value = value;
        }
    }

    public int kthSmallest(int[] A, int[] B, int k) {
        // sanity check:
        if (k <= 0) {
            return -1;
        }
        if (A == null || A.length == 0) {
            if (B == null || B.length <= k) {
                return -1;
            }
            return B[k];
        }
        if (B == null || B.length == 0) {
            if (A == null || A.length <= k) {
                return -1;
            }
            return A[k];
        }
        if (k > (A.length - 1) * (B.length - 1)) {
            return -1;
        }

        int rows = B.length;
        int cols = A.length;
        PriorityQueue<Cell> minHeap = new PriorityQueue<>(new Comparator<Cell>() {
            @Override
            public int compare(Cell o1, Cell o2) {
                if (o1.equals(o2)) {
                    return 0;
                }
                return o1.value < o2.value ? -1 : 1;
            }
        });

        // avoid revisit
        boolean[][] visited = new boolean[rows][cols];
        minHeap.offer(new Cell(0,0,A[0] + B[0]));
        visited[0][0] = true;

        for (int i = 0; i < k; i++) {
            Cell cur = minHeap.poll(); // 注意！必须要poll，因为需要让停下来时，第k个在root
            if (cur.row + 1 < rows && !visited[cur.row + 1][cur.col]) {
                minHeap.offer(new Cell(cur.row + 1, cur.col, A[cur.col] + B[cur.row + 1]));
                visited[cur.row + 1][cur.col] = true;
            }
            if (cur.col + 1 < cols && !visited[cur.row][cur.col + 1]) {
                minHeap.offer(new Cell(cur.row, cur.col + 1, A[cur.col + 1] + B[cur.row]));
                visited[cur.row][cur.col + 1] = true;
            }
        }

        return minHeap.peek().value;
    }
}
