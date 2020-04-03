package com.company.topinterview.easycollection;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        rotate(nums,3);
        System.out.println(Arrays.toString(nums));
    }

    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k%n;
        int[] ans = new int[n];
        System.arraycopy(nums,0,ans,0,n);
        System.arraycopy(ans,n-k,nums,0,k);
        System.arraycopy(ans,0,nums,k,n-k);
    }
}
