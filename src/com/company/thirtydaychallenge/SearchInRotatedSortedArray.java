package com.company.thirtydaychallenge;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        System.out.println(new SearchInRotatedSortedArray().search(new int[]{3, 1}, 1));
    }

    static int findMin(int[] nums) {
        int start = 0, end = nums.length - 1, mid;
        while (true) {
            mid = (start + end) / 2;
            if (mid == 0 && nums[mid + 1] < nums[mid])
                return mid + 1;
            if (mid == 0 || nums[mid - 1] > nums[mid])
                return mid;
            if (nums[mid] > nums[end])
                start = mid + 1;
            else end = mid - 1;
        }
    }

    static int binarySearch(int[] nums, int target, int start, int end) {
        int mid;
        while (start <= end) {
            mid = (start + end) / 2;
            if (target == nums[mid])
                return mid;
            if (target < nums[mid])
                end = mid - 1;
            else
                start = mid + 1;
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        if (nums.length == 0)
            return -1;
        if (nums.length == 1) {
            return target == nums[0] ? 0 : -1;
        }
        int m = findMin(nums);
        int n = nums.length;

        if (target >= nums[m] && target <= nums[n - 1])
            return binarySearch(nums, target, m, n - 1);

        return binarySearch(nums, target, 0, m - 1);

    }
}
