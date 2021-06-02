package com.study.algorithms.class09_hash_table_stringI.重听;

import java.util.Arrays;

public class Tester {
    public static void main(String[] args) {
        TopKFrequent topKFrequent = new TopKFrequent();
        String[] res = topKFrequent.topKFrequent(new String[]{"d","a","c","b","d","a","b","b","a","d","d","a","d"}, 5);
        System.out.println(Arrays.toString(res));
    }
}
