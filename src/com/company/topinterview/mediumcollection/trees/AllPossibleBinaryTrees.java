package com.company.topinterview.mediumcollection.trees;

public class AllPossibleBinaryTrees {
    static int count;

    public static void main(String[] args) {
        System.out.println(allPossibleFullBinaryTrees(19));
    }

    public static int allPossibleBinaryTrees(int n) {
        count = 0;
        if (n == 0 || n == 1)
            return 1;
        allPossibleBinaryTreesHelper(n - 1, 1);
        return count;
    }

    public static int allPossibleFullBinaryTrees(int n) {
        count = 0;
        if (n % 2 == 0)
            return 0;
        allPossibleFullBinaryTreesHelper(n - 1, 1);
        return count;
    }

    private static void allPossibleFullBinaryTreesHelper(int n, int m) {
        if (n == 0) {
            count++;
            return;
        }
        int max = Math.min(n, 2 * m);
        for (int k = 2; k <= max; k += 2) {
            int numOfCalls = combi(m, k / 2);
            for (int i = 0; i < numOfCalls; i++)
                allPossibleFullBinaryTreesHelper(n - k, k);
        }
    }

    private static void allPossibleBinaryTreesHelper(int n, int m) {
        if (n == 0) {
            count++;
            return;
        }
        int max = Math.min(n, 2 * m);
        for (int k = 1; k <= max; k++) {
            int numOfCalls = combi(2 * m, k);
            for (int i = 0; i < numOfCalls; i++)
                allPossibleBinaryTreesHelper(n - k, k);
        }
    }

    private static int combi(int n, int r) {
        int c = n - r + 1;
        int num = 1;
        while (c <= n) {
            num *= c;
            c++;
        }
        int den = 1;
        c = 1;
        while (c <= r) {
            den *= c;
            c++;
        }
        return num / den;
    }
}
