package com.company.revision.backtracking;

public class GenerateString {
    static void printBinaryStringInefficientSpace(int n, String s) {    // Uses string (immutable object) For each call, a new string is created!
        if (n <= 0) {
            System.out.println(s);
            return;
        }
        printBinaryStringInefficientSpace(n - 1, s + "0");
        printBinaryStringInefficientSpace(n - 1, s + "1");
    }

    static void printK_aryString(int n, int k, char[] arr, int i) // Uses single array - Space optimized
    {
        if (i == n) {
            System.out.println(arr);
            return;
        }
        for (int j = '0'; j < '0' + k; j++) {
            arr[i] = (char) j;
            printK_aryString(n, k, arr, i + 1);
        }
    }

    public static void main(String[] args) {
        // printBinaryStringInefficientSpace(3,"");
        printK_aryString(3, 3, new char[3], 0);
    }
}
