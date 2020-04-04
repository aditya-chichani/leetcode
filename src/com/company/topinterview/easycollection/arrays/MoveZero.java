package com.company.topinterview.easycollection.arrays;

public class MoveZero {
    public void moveZeroes(int[] nums) {
        int pos=0;
        for(int i =0; i<nums.length; i++) // O(n)
        {
            if(nums[i]!=0)
                nums[pos++]=nums[i];
        }
        for(int i = pos; i<nums.length; i++)  // O(no. of Zeroes) i.e O(n)
            nums[i]=0;
    }
}
