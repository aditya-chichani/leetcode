package com.company.revision.arrays;

import java.util.HashMap;

public class TwoSum {
    /* Easy:
    Given an array of integers, return indices of the two numbers such that they add up to a specific target.
    You may assume that each input would have exactly one solution, and you may not use the same element twice
    Note: Since there is exactly one solution - We dont need to worry about duplicates, because if a number has duplicate,
    it wont be part of the solution as it will then have more than 1 solution!
    * */
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        int i;
        for (i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i]) && map.get(target - nums[i]) != i) {
                break;
            }
        }
        ans[0] = i;
        ans[1] = map.get(target - nums[i]);
        return ans;
    }

    /*Medium:
    Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
    The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
    Note:
    1. You may assume that each input would have exactly one solution, and you may not use the same element twice
    2. Can use constant space only
    * */
    public int[] twoSumSorted(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        int sum;
        while (i != j) {
            sum = nums[i] + nums[j];
            if (sum == target)
                return new int[]{i, j};
            else {
                if (sum < target)
                    i++;
                else j--;
            }
        }
        return null;
    }

     /*Medium:
    Given an array of integers, return indices of all pairs such that they add up to a specific target.
    You can use the same value but cannot use the same element twice.
    * */

}
