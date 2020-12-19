package com.study.practice.tips;

import java.util.*;



public class ForEachLoop {
    public static void main(String args[]) {
        Map<String, Integer> map = new HashMap<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

        int temp = 0;
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }

        long s1 = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            temp = list.get(i);
        }
        long e1 = System.currentTimeMillis();

        long s2 = System.currentTimeMillis();
        for (Integer cur : list) {
            temp = cur;
        }
        long e2 = System.currentTimeMillis();

        System.out.println("for (int i = 0; i < list.size(); i++): \t" + (e1-s1) + "ms");
        System.out.println("for (Integer cur : list): \t\t\t\t" + (e2-s2) + "ms");
    }
}


