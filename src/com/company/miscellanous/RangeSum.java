package com.company.miscellanous;

import java.util.Arrays;

public class RangeSum {
    public static void main(String[] args) {
        System.out.println(new RangeSum().rangeSum(new int[]{1, 2, 3, 4}, 4, 1, 5));
    }

    public int rangeSum(int[] nums, int n, int left, int right) {
        int len = (n * (n + 1)) / 2;
        int[] ans = new int[len];
        int count = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                ans[count++] = sum;
            }
        }
        Arrays.sort(ans);
        left--;
        long s = 0;
        for (int i = left; i <= right; i++) {
            s += ans[i];
        }
        return (int) s % (1000000007);
    }
}
