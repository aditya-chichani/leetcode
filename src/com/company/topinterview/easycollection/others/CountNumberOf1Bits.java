package com.company.topinterview.easycollection.others;

public class CountNumberOf1Bits {
    public static void main(String[] args) {

        int n = (int) Math.pow(2, 31);
        System.out.println(Math.pow(2, 31));
        new CountNumberOf1Bits().hammingWeight(-3);
    }

    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count += n & 1;
            n = n >>> 1;
        }
        return count;
    }
}
