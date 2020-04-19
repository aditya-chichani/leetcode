package com.company.topinterview.easycollection.arrays;

import java.util.HashMap;

public class IntersectionTwoArraysII {
    public static void main(String[] args) {
        int [] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        intersect(nums1,nums2);
        System.out.println();
    }
    public static int[] intersect(int[] nums1, int[] nums2) {
        int[] ans = new int[Math.max(nums1.length, nums2.length)];
        int count=0,finalCount=0;
        HashMap<Integer,Integer> nums1Map = new HashMap<>();
        for(int num1 : nums1) // O(n1)
        {
            if(nums1Map.containsKey(num1))
                nums1Map.put(num1,nums1Map.get(num1)+1);
            else
                nums1Map.put(num1,1);
        }

        for(int num2 : nums2) // O(n2) Processes elements of num2 on the go so no need to load them all
        {
            if(nums1Map.containsKey(num2) && nums1Map.get(num2)>0)
            {
                ans[count++]=num2;
                nums1Map.put(num2,nums1Map.get(num2)-1);
            }
        }

        // Shrinking ans to finalAns to avoid zeroes - Find way of avoiding - O(min(n1,n2)) complexity
        int [] finalAns = new int[count];
        for(int i=0; i<count; i++)
            finalAns[finalCount++] = ans[i];
        return finalAns;
        //return Arrays.copyOfRange(ans,0,count); Can also be done like this - has same complexity
    }
}
