package com.company.revision.stack;

import java.util.Arrays;

//Find maximum of minimum for every window size in a given array: https://www.geeksforgeeks.org/find-the-maximum-of-minimums-for-every-window-size-in-a-given-array/
public class MinMaxRiddle {

    public static void main(String[] args) {
        Arrays.stream(new MinMaxRiddle().findMinMaxBruteForce(new int[]{10, 20, 30, 50, 10, 70, 30})).forEach(System.out::println);
    }

    int[] findMinMaxBruteForce(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int i, j, k;
        int min, max;
        for (k = 1; k <= n; k++) {
            max = Integer.MIN_VALUE; // max of this window size
            for (i = 0; i < n - k + 1; i++) {
                min = Integer.MAX_VALUE;  // min of this window
                for (j = i; j < i + k; j++) {
                    min = Math.min(min, nums[j]);
                }
                max = Math.max(max, min);
            }
            ans[k - 1] = max;
        }
        return ans;
    }
}
