package com.company.topinterview.mediumcollection.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CoinChangeProblem {
    static int min;
    static Map<Integer, Integer> coinChangeMap;

    public static int coinChangeUsingDP(int[] coins, int amount) {
        int n = coins.length;
        min = -1;
        coinChangeMap = new HashMap<>();
        for (int coin : coins)
            coinChangeMap.put(coin, 1);
        Arrays.sort(coins);
        return coinChangeUsingDPHelper(coins, amount, n - 1);
    }

    private static int coinChangeUsingDPHelper(int[] coins, int amount, int i) {
        if (i < 0)
            return -1;

        if (coinChangeMap.containsKey(amount))
            return coinChangeMap.get(amount);

        int m = -1;
        int n = amount / coins[i];

        if (coins[i] * n == amount) {
            coinChangeMap.put(amount, n);
            return n;
        }

        for (int j = n; j >= 0; j--) {
            int part = coinChangeUsingDPHelper(coins, amount - coins[i] * j, i - 1);
            if (part != -1) {
                if (m == -1)
                    m = j + part;
                else m = Math.min(m, j + part);
            }
        }

        coinChangeMap.put(amount, m);
        return m;
    }

    public static int coinChangeBruteForce(int[] coins, int amount) {
        int n = coins.length;
        min = -1;
        Arrays.sort(coins);
        coinChangeHelper(coins, amount, 0, n - 1);
        return min;
    }

    private static void coinChangeHelper(int[] coins, int amount, int num, int i) {

        if (i < 0)
            return;

        int n = amount / coins[i];

        if (coins[i] * n == amount) {
            if (min == -1)
                min = num + n;
            else min = Math.min(num + n, min);
            return;
        } else {
            for (int j = n; j >= 0; j--)
                coinChangeHelper(coins, amount - coins[i] * j, num + j, i - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(coinChangeBruteForce(new int[]{1, 2, 3}, 4));
        System.out.println(coinChangeUsingDP(new int[]{1, 2, 3}, 4));
    }
}
