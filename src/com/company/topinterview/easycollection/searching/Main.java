package com.company.topinterview.easycollection.searching;

public class Main {
    public static void main(String[] args) {
        // int[] nums = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610};
        //System.out.println(BinarySearch.binarySearchWithReducedComparisons(new int[]{2, 5}, 5));
        System.out.println(rangeBitwiseAnd(2147483646, 2147483647));
    }

    public static int rangeBitwiseAnd(int m, int n) {
        //System.out.println(2147483646&2147483647);
        int ans = m;
        for (int i = m + 1; i <= n; i++) {
            ans &= i;
            if (ans == 0)
                return 0;
        }
        return ans;
    }
}
