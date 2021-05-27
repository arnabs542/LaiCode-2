package com.study.algorithms.class08_DFS.重听;

import com.study.algorithms.class08_DFS.PermutationsI;

public class Tester {
    public static void main(String[] args) {
        int target = 100;
        int[] coins = new int[]{99};
        CombinationsOfCoins combinationsOfCoins = new CombinationsOfCoins();
        System.out.println(combinationsOfCoins.combinations(target, coins));

        AllPermutations allPermutations = new AllPermutations();
        System.out.println(allPermutations.permutations("abc"));
    }
}
