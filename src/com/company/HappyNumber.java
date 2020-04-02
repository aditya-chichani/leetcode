package com.company;

import java.util.HashMap;

public class HappyNumber {
    HashMap<Integer,Integer> numSumMap = new HashMap<>(); // Used for SF solution so that slow doesnt have to compute values!
    public static void main(String[] args) {
        HappyNumber happyNumber = new HappyNumber();
        //System.out.println(happyNumber.isHappy(4));  // Caused Stack Overflow
       // System.out.println(happyNumber.isHappyIterative(19));  // Cause Time Limit Exceeded
        System.out.println(happyNumber.isHappyUsingSF(19));
    }

    public boolean isHappy(int n) {
        return isHappyHelper(n,n,0);
    }

    private boolean isHappyHelper(int curr,int original, int flag) {
        if(curr==1)
            return true;
        if(flag == 1 && curr == original)
            return false;
        int sum = getSum(curr);
        return isHappyHelper(sum,original,1);
    }

    private int getSum(int curr) {   // Very inefficient - Beats only 9% submissions! Tip - Avoid String manipulation as far as posible!!!
        String currString = String.valueOf(curr);
        int sum = 0;
        for (int i = 0; i < currString.length(); i++)
            sum += (int) Math.pow(Double.parseDouble(String.valueOf(currString.charAt(i))), 2);
        numSumMap.put(curr,sum);
        return sum;
    }

    private int getSumEfficient(int n){    // Beats 87% Submissions!
        int tmp = 0;
        while (n > 0) {
            tmp += Math.pow((n % 10), 2);
            n /= 10;
        }
        numSumMap.put(n,tmp);
        return tmp;
    }

    public boolean isHappyIterative(int n){
        int curr =n,flag =0;
        while(curr!=1 && (flag!=1 || curr!=n))
        {
            int sum = getSum(curr);
            curr=sum;
            flag=1;
        }
        if(curr ==1)
            return true;
        return false;
    }

    public boolean isHappyUsingSF(int n){
        int fast=n,slow=n;
        do
        {
            fast = getSum(getSum(fast));
            slow = numSumMap.get(slow);
        }
        while(fast!=1 && slow!=fast);
        if(fast == 1)
            return true;
        return false;
    }

}
