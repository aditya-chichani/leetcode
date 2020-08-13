package com.company.revision.arrays;

public class MaxGap {
    public static void main(String[] args) {
        System.out.println(new MaxGap().maxGap(new int[]{2, 3, 10, 6, 4, 8, 1}));
    }

    /*Find the maximum difference between two elements such that larger element appears after the smaller element
     * O(n) time: Takes 1 pass, O(1) extra space
     * */
    int maxGap(int[] nums) {
        int gap = 0;
        if (nums == null || nums.length < 2)
            return gap;
        int max = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            if (max > nums[i]) // Larger after smaller condition met
            {
                if (max - nums[i] > gap)
                    gap = max - nums[i];
            } else max = nums[i];
        }
        return gap;
    }
}
