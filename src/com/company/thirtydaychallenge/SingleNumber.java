package com.company.thirtydaychallenge;

import java.util.HashSet;

public class SingleNumber {

    public static void main(String[] args) {
	// write your code here
    int a[] ={4,2,1,2,1};
        System.out.println(singleNumber(a));
    }

    public static int singleNumber(int[] nums) {
        HashSet<Integer> numMap = new HashSet();
        for(int num: nums)
        {
            if(!numMap.add(num))
                numMap.remove(num);
        }
        return numMap.iterator().next();
    }
}
