package com.company.miscellanous;

import java.util.Scanner;

public class MedtronicQuestion {
    /* For a given n where n is the number of a digits eg. if n=3 then the space is 100-999
       and given sum Eg: sum=6, find the total count of numbers in the space such that the sum of their digits is equal to the given sum.
       For example: There are 21 numbers between 100-999 such that the sum of the digits of each number is 6.
     */
    static int count;

    static int getCount(int n, int sum) {
        count = 0;
        int lim = sum > 9 ? 9 : sum;  // No point in taking a digit bigger than sum, digit can go upto 9.
        for (int i = 1; i <= lim; i++) // First digit cannot be zero
            getCountHelper(n - 1, sum - i); // Situation after deciding this digit
        return count;
    }

    private static void getCountHelper(int n, int sum) {
        if (sum <= 0) {
            if (sum == 0)  // Our condition is already met - maybe even before reaching last place.
                count++;
            return;
        }
        if (n == 1)   // Last place - You will either meet the condition or not meet it.
        {
            if (sum <= 9)
                count++;
            return;
        }
        int lim = sum > 9 ? 9 : sum;
        for (int i = 0; i <= lim; i++) // Digit at this level
            getCountHelper(n - 1, sum - i);
    }

    private static void findCount(int n, int sum) {
        int prev = 0;
        // in case n = 2 start is 10 and end is (100-1) = 99
        int start = (int) Math.pow(10, n - 1);
        int end = (int) Math.pow(10, n) - 1;

        int count = 0;
        int i = start;

        while (i < end) {

            int cur = 0;
            int temp = i;

            while (temp != 0) {
                cur += temp % 10;
                temp = temp / 10;
            }

            if (cur == sum) {
                if (prev == 0)
                    prev = i;
                System.out.println(i + "   " + (i - prev));
                count++;
                i += 9;
            } else i++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = sc.nextInt();
        findCount(n, sum);
        System.out.println("Count is " + count);
    }
}
