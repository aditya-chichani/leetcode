package com.company.miscellanous;

import java.util.Scanner;

public class LargestNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        int t = sc.nextInt();
        String[] inputs = new String[t];
        for (int i = 0; i < t; i++) {
            inputs[i] = sc1.nextLine();
        }
        for (String s : inputs) {
            String[] s1 = s.split(" ");
            largestNumberHelper(Integer.parseInt(s1[0]), Integer.parseInt(s1[1]), Integer.parseInt(s1[2]));
        }
    }

    private static void largestNumberHelper(int a, int b, int c) {
        if (b >= a || b > c)
            System.out.println(-1);
        else {
            int t = 0;
            while (a * t + b <= c)
                t++;
            System.out.println(a * (t - 1) + b);
        }
    }
}

