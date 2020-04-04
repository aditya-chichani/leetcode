package com.company.topinterview.easycollection.arrays;

import java.util.HashSet;

public class ContainsDuplicates {
    public static void main(String[] args) {
        int[] nums ={1,1,1,3,3,4,3,2,4,2};
        System.out.println(containsDuplicate(nums));
    }

    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> exists = new HashSet<>();
        for(int num : nums)
        {
            if(!exists.add(num))
                return true;     // Duplicate found
        }
        return false; // All elements are Unique
    }
}
