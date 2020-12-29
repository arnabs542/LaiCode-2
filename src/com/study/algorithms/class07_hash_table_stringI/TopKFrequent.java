package com.study.algorithms.class07_hash_table_stringI;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent {
    // Given a composition with different kinds of words,
    // return a list of the top K most frequent words in the composition
    public String[] topKFrequent(String[] combo, int k) {
        // step1: hash map: <string, frequency>
        // step2: min heap of size k: iterate over the hashmap, use a minheap to store the top k frequent
        // create hash map --> time O(n)             assume key length is within a limitation.
        // minheap --> time O(k + (n-k)logk)

        // corner case: return empty String array if combo is null or empty.
        if (combo == null || combo.length == 0) {
            return new String[0];
        }

        // HashMap: get all the distinct strings as key,
        // and their frequencies as values
        Map<String, Integer> freqMap = getFreqMap(combo);
        // minHeap: Set Map.Entry as element to get frequency and key at same time.
        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(k, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.equals(o2)) {
                    return 0;
                }
                return o1.getValue().compareTo(o2.getValue()); // I call the Integer's compareTo instead of unboxing them and compare manually.
            }
        });
        for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
            if (minHeap.size() < k) { // k=2时，size=1可以进入，size=2不可以进入
                minHeap.add(entry);
            } else if (entry.getValue() > minHeap.peek().getValue()) {
                minHeap.poll();
                minHeap.add(entry);
            }
        }
        return HeapToArray(minHeap);
    }

    private String[] HeapToArray(PriorityQueue<Map.Entry<String, Integer>> minHeap) {
        String[] result = new String[minHeap.size()];
        for (int i = minHeap.size() - 1; i >= 0; i--) {
            // we want store the most frequent one in result[0], so add from tail:
            result[i] = minHeap.poll().getKey(); // get Key
        }
        return result;
    }

    private Map<String, Integer> getFreqMap(String[] combo) {
        Map<String, Integer> freqMap = new HashMap<>(); // initial capacity: 16
        for (String s : combo) {
            freqMap.put(s, freqMap.getOrDefault(s, 0) + 1);
        }
        return freqMap;
    }
}
