package com.company.topinterview.mediumcollection.sorting;

public class QuickSort {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int start, int end) {
        if (end <= start)
            return;
        int pivot = partition(nums, start, end);
        quickSort(nums, start, pivot - 1);
        quickSort(nums, pivot + 1, end);
    }

    private int partition(int[] nums, int l, int r) {
        int pivot = r;
        int i = -1, j = l;
        while (j <= r) {
            if (nums[j] <= nums[pivot]) {
                if (i != -1) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                    i++;
                }
            } else if (i == -1)
                i = j;

            j++;
        }
        i--;

        return i < 0 ? r : i;

    }

}
