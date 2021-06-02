package com.study.algorithms.class09_hash_table_stringI.重听;

import java.util.*;

public class TopKFrequent {
    public String[] topKFrequent(String[] combo, int k) {
        if (combo == null || k <= 0) {
            return new String[0];
        }

        // generate map
        Map<String, Integer> hashMap = new HashMap<>(); // init size 16
        for (int i = 0; i < combo.length; i++) {
            int count = hashMap.getOrDefault(combo[i], 0);
            hashMap.put(combo[i], count + 1);
        }

        // generate min heap
        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(k, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.equals(o2)) {
                    return 0;
                }
                return (o1.getValue().compareTo(o2.getValue())); // o1 < o2时，返回-1.
            }
        });
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) { // entrySet才是set的view
            if (minHeap.size() + 1 <= k) { // 本次offer之后要保证不超过k
                minHeap.offer(entry);
            } else if (entry.getValue() > minHeap.peek().getValue()) {
                // 和最差的比较，如果比最差的大，就把它替换掉。
                minHeap.poll();
                minHeap.offer(entry);
            }
        }

        // generate array
        String[] results = new String[minHeap.size()];
        // for (int i = 0; i < k; i++) {  // 不可以用k。因为k可能比size大，那样会出现null的情况。
        for (int i = minHeap.size() - 1; i >= 0; i--) {
            Map.Entry<String, Integer> entry = minHeap.poll();
            results[i] = entry.getKey();
        }
        return results;
    }
}
