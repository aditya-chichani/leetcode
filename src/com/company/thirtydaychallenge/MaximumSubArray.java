package com.company.thirtydaychallenge;

import java.util.HashMap;
import java.util.Stack;

public class MaximumSubArray {
    public static void main(String[] args) {
        int[] nums = {-31,-41,59,26,-53,58,97,-93,-23,84};
        System.out.println(slidingWindowMaxSubArray(nums));
    }

    // Very Wrong approach to use Max Histogram for this problem! It fails since sum can be -ve also!
    public static int maxSubArray(int[] nums) {
        int maxCount = nums[0];
        Stack<Integer> lstack = new Stack<>();
        Stack<Integer> rstack = new Stack<>();
        Stack<Integer> lopstack = new Stack<>();
        int currPse;
        int pse=0,sum=0,nse;
        HashMap<Integer,Integer> cumulativeSumMap = new HashMap<>();
        cumulativeSumMap.put(-1,sum);
        for(nse=0; nse< nums.length;nse++)
        {
            while (!lstack.isEmpty() && nums[lstack.peek()]>=nums[nse])
                lstack.pop();

            if(lstack.isEmpty())
                currPse = -1;
            else
                currPse = lstack.peek();
            lstack.push(nse);

            sum+=nums[nse];
            cumulativeSumMap.put(nse,sum);

            while (!rstack.isEmpty() && rstack.peek() > nums[nse])
            {
                pse = lopstack.pop();
                rstack.pop();
                maxCount = Math.max(cumulativeSumMap.get(nse-1)- cumulativeSumMap.get(pse),maxCount);
            }
            rstack.push(nums[nse]);
            lopstack.push(currPse);
        }
        while (!rstack.isEmpty())
        {
            pse = lopstack.pop();
            rstack.pop();
            maxCount = Math.max(cumulativeSumMap.get(nse-1)- cumulativeSumMap.get(pse),maxCount);
        }
        return maxCount;
    }


    public static int slidingWindowMaxSubArray(int[] nums){
        if(nums.length == 0)  // Edge case - If array is empty
            return 0;
        int maxSum=Integer.MIN_VALUE,currSum=0,end=0;
        while (end<nums.length)
        {
            currSum+=nums[end];
            maxSum = Math.max(currSum,maxSum);
            if(currSum<0)
            {
                currSum=0;
            }
            end++;
        }
        return maxSum;
    }

}
