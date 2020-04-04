package com.company.topinterview.easycollection.dynamicprogramming;

import java.util.HashMap;

public class ClimbStairsSolution {
    static int count =0;
    HashMap<Integer,Integer> numStepMap = new HashMap<>();
    public static void main(String[] args) {
        System.out.println(new ClimbStairsSolution().climbStairs(44));
    }

    public int climbStairs(int n) {
        if(n==0)
            return 0;
        numStepMap.put(0,1);
        return climbStairsDPHelper(n);
    }

    public int climbStairsDPHelper(int n){
        if(numStepMap.containsKey(n))
            return numStepMap.get(n);
        if(n<0)
            return 0;
        int steps = climbStairsDPHelper(n-1)+climbStairsDPHelper(n-2);
        numStepMap.put(n,steps);
        return steps;
    }

    public static int climbStairsUsingBacktracking(int n) {   // Causes TLE
        if(n==0)
            return 0;
        climbStairsHelper(n);
        return count;
    }

    public static void climbStairsHelper(int n){
        if(n==0)
        {
            count++;
            return;
        }
        if(n<0)
            return;
        climbStairsHelper(n-1);
        climbStairsHelper(n-2);
    }
}
