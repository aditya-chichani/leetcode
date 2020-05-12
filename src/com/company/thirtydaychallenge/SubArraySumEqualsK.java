package com.company.thirtydaychallenge;

import java.util.HashMap;

public class SubArraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        if (nums.length == 0)
            return 0;
        int sum = 0, count = 0, i;
        HashMap<Integer, Integer> posFrequencyMap = new HashMap<>();
        for (i = 0; i < nums.length; i++) {
            sum += nums[i];
            nums[i] = sum;
            if (posFrequencyMap.containsKey(sum))
                posFrequencyMap.put(sum, posFrequencyMap.get(sum) + 1);
            else
                posFrequencyMap.put(sum, 1);
        }
        if (posFrequencyMap.containsKey(k))
            count += posFrequencyMap.get(k);
        for (i = 0; i < nums.length; i++) {
            if (posFrequencyMap.containsKey(nums[i] - k))
                count += posFrequencyMap.get(nums[i] - k);
        }
        return count;
    }


    public int subarraySumBruteForce(int[] nums, int k) {    //O(n^2)
        int sum = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k)
                    count++;
            }
        }
        return count;
    }
}
