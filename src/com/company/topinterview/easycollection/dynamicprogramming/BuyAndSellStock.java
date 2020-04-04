package com.company.topinterview.easycollection.dynamicprogramming;

public class BuyAndSellStock {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len<2)
            return 0;

        int maxCount = Integer.MIN_VALUE;

        int[] index = new int[len-1];
        index[len-2] = prices[len-1]; // Last element remains same
        for(int i=len-2;i>0;i--)
        {
            index[i-1] = Math.max(prices[i],index[i]);
        }

        for(int i=0;i<len-1;i++)
        {
            maxCount = Math.max(index[i]-prices[i],maxCount);
        }

        return Math.max(maxCount,0);
    }
}
