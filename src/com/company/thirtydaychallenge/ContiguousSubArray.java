package com.company.thirtydaychallenge;

public class ContiguousSubArray {
    public static void main(String[] args) {
        //int[] nums = new int[]{0,1, 0, 1, 1, 1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1};
        // System.out.println(nums.length);
        //   System.out.println(findMaxLength(nums));
        char c = '4' - '0';
        int j = c;
        System.out.println(j);
    }

    public static int findMaxLength(int[] nums) {
        int n = nums.length;
        int sum;
        int maxsize = 0;

        // Pick a starting point as i

        for (int i = 0; i < n - 1; i++) {
            sum = (nums[i] == 0) ? -1 : 1;

            // Consider all subarrays starting from i

            for (int j = i + 1; j < n; j++) {
                if (nums[j] == 0)
                    sum += -1;

                else
                    sum += 1;

                // If this is a 0 sum subarray, then
                // compare it with maximum size subarray
                // calculated so far

                if (sum == 0 && maxsize < j - i + 1) {
                    maxsize = j - i + 1;
                }
            }
        }

        return maxsize;
    }
}