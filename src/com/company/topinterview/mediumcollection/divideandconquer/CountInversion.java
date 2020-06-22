package com.company.topinterview.mediumcollection.divideandconquer;

import java.util.Arrays;

public class CountInversion {
    static int count;

    public static int countInversion(int[] nums) {
        count = 0;
        countInversion(nums, 0, nums.length - 1);
        return count;
    }

    private static void countInversion(int[] nums, int l, int r) {
        if (r <= l)
            return;
        int m = l + ((r - l) >> 1);
        countInversion(nums, l, m);
        countInversion(nums, m + 1, r);
        merge(nums, l, m, r);
    }

    private static void merge(int[] nums, int l, int m, int r) {
        //O(N) for copy

        int[] left = Arrays.copyOfRange(nums, l, m + 1);
        int[] right = Arrays.copyOfRange(nums, m + 1, r + 1);
        // O(n) for counting inversions separately and is redundant. Instead use mergeCountInversion2
        //mergeCountInversion1(left, left[0] <= right[right.length-1],0,right.length-1);
        //O(n) for merging 2 sorted arrays
        mergeOfSort(nums, left, right, l);
    }

    private static void mergeOfSort(int[] nums, int[] left, int[] right, int k) {
        int i;
        int j;
        i = 0;
        j = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j])
                nums[k++] = left[i++];
            else {
                nums[k++] = right[j++];
                mergeCountInversion2(right, i);
            }
        }
        while (i < left.length)
            nums[k++] = left[i++];
        while (j < right.length)
            nums[k++] = right[j++];
    }

    private static void mergeCountInversion2(int[] right, int i) {
        count += (right.length - i);
    }

    private static void mergeCountInversion1(int[] left, boolean b, int i, int j) {
        while (b) {
            i++;
            j--;
        }
        count += ((left.length - i) * (j + 1));
    }

    public static void main(String[] args) {
        System.out.println(countInversion(new int[]{8, 4, 2, 1}));
    }
}
