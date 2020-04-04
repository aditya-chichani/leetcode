package com.company.topinterview.easycollection.arrays;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] nums = {1,1,2};
        int len = removeDuplicates(nums);

// any modification to nums in your function would be known by the caller.
// using the length returned by your function, it prints the first len elements.
        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }
    }

    public static int removeDuplicates(int[] nums) {
        int validPos = 1, currUnique = nums[0];
        for(int i =1; i< nums.length; i++)
        {
            if(nums[i]!= currUnique)
            {
                currUnique = nums[i];
                nums[validPos] = currUnique;
                validPos++;
            }
        }
        return validPos;
    }
}
