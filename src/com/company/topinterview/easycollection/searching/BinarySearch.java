package com.company.topinterview.easycollection.searching;

public class BinarySearch {

    public static int search(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    static int binarySearch(int[] nums, int target, int start, int end) {
        if (start > end)
            return -1;    // return start instead of -1 if you want to know the position at which this new element should be inserted
        int mid = (start + end) / 2;
        if (nums[mid] == target)
            return mid;
        if (nums[mid] < target)
            return binarySearch(nums, target, mid + 1, end);
        return binarySearch(nums, target, start, mid - 1);

    }
}
