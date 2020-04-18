package com.company.topinterview.easycollection.searching;

public class JumpSearch {
    public static int search(int[] nums, int target) {
        //Worst Time complexity : √ n (This is the optimal block size) Better than linear search, worse than binary search
        int m = (int) Math.sqrt(nums.length);
        int i;
        for (i = 0; i < nums.length; i += m) // Worst case : n/m
        {
            if (nums[i] == target)
                return i;
            if (nums[i] > target)
                break;
        }
        int end = Math.min(nums.length, i);
        for (int j = end - m; j < end; j++) // Worst case : m-1
        {
            if (nums[j] == target)
                return j;
        }
        return -1;
    }
}
