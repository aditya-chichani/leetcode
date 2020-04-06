package com.company.thirtydaychallenge;

import java.util.Arrays;
import java.util.HashMap;

public class BuyAndSellStockII {
    static HashMap<Integer,Integer> indexProfitMap = new HashMap<>();
    public static void main(String[] args) {
        int[] nums = new int[]{7,6,5,0,0,0};
        System.out.println(maxProfit(nums));
    }
    // Optimized brute force - recursive function still called n^n times!
    public static int maxProfit(int[] prices) {
        return maxProfitHelper(prices,0);
    }

    public static int maxProfitHelper(int[] prices, int index)
    {
        if(indexProfitMap.containsKey(index))
            return indexProfitMap.get(index);

        if(index>= prices.length-1)
            return 0;

        int maxProfit = Math.max(maxProfitHelper(prices,index+1),0),curr=0;
        for(int i=index+1;i<prices.length;i++)
        {       curr = Math.max(prices[i]-prices[index],0);
            maxProfit = Math.max(maxProfit,curr+maxProfitHelper(prices,i+1));
        }
        indexProfitMap.put(index,maxProfit);
        return maxProfit;
    }
}
