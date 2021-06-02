package com.study.practice.class11_LCA;

import com.study.util.TreeNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Tester {

    static class Cell{
        int key;
        int index;

        public Cell(int key, int index) {
            this.key = key;
            this.index = index;
        }

//        @Override
//        public int compareTo(Cell o) {
//            if (this.key == o.key) {
//                return 0;
//            }
//            return this.key < o.key ? -1 : 1;
//        }
    }

    public static void main(String args[]) {
        PriorityQueue<Cell> pq = new PriorityQueue<>(new Comparator<Cell>() {
            @Override
            public int compare(Cell o1, Cell o2) {
                return o1.key < o2.key ? -1 : 1;
            }
        });
        Cell c1 = new Cell(10,0);
        Cell c2 = new Cell(10,1);
        Cell c3 = new Cell(10, 2);
        pq.offer(c1);
        pq.offer(c2);
        pq.offer(c3);

        System.out.println(pq.poll().index);
        System.out.println(pq.poll().index);
        System.out.println(pq.poll().index);

        // null is a reference (ok)
        boolean a = null == null;
        System.out.println(a);

        // reference of same type (ok)
        TreeNode n1 = null;
        TreeNode n2 = null;
        boolean b = n1 == n2;
        System.out.println(b);

        // reference of different type (error)
        TreeNodeP n3 = null;
        TreeNode n4 = null;
//        boolean c = n3 == n4;
//        System.out.println(c);
    }
}
