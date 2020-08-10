package com.company.revision.recursion;

public class CheckArrayIsSorted {
    static boolean isSortedAscending(int[] arr, int n) {
        if (n == arr.length - 1)
            return true;
        return isSortedAscending(arr, n + 1) && arr[n] <= arr[n + 1];
    }

    public static void main(String[] args) {
        System.out.println(isSortedAscending(new int[]{7, 5, 43, 1}, 0));
        System.out.println(isSortedAscending(new int[]{1, 5, 7, 43}, 0));
    }
}
