package com.company.miscellanous;

public class GenerateSquares {
    public static void main(String[] args) {
        int i = 1;
        int count = 0;
        while (true) {
            if (i * i < 100000) {
                System.out.print(i * i + ",");
                i++;
                count++;
            } else break;
        }
        System.out.println("Count is " + count);
    }
}


