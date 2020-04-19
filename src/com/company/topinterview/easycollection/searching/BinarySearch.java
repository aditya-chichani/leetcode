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

    static int binarySearchWithReducedComparisons(int[] nums, int target) {
        if (nums.length == 0)
            return -1;     // Return 0 for Insert position

        int mid, start = 0, end = nums.length - 1;
        while (end - start > 1) {
            mid = (start + end) / 2;
            if (nums[mid] < target)
                start = mid;
            else
                end = mid;
        }

        if (nums[start] == target)
            return start;

        if (nums[end] == target)
            return end;

       /* if(nums[start]>=target) // If target is less than or equal to start
            return start;
         if(nums[end]<target)  // If target bigger than end
            return end+1;
         return end;*/  //If target is bigger than start but less than or equal to end

        return -1;
    }
}
