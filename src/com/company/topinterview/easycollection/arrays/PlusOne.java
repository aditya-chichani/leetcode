package com.company.topinterview.easycollection.arrays;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int carry=1;
        int[] ans = new int[digits.length];
        int ansDigit;
        for(int i = digits.length-1; i>=0;i--)
        {
            ansDigit = digits[i]+carry;
            if(ansDigit<10)
            {
                ans[i]=ansDigit;
                carry=0;
            }
        }
        if(carry ==1)
        {
            ans = new int[digits.length+1];
            ans[0]=1;
        }
        return ans;
    }
}
