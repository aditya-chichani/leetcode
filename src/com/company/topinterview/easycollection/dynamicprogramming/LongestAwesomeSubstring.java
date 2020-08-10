package com.company.topinterview.easycollection.dynamicprogramming;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LongestAwesomeSubstring {
    public static void main(String[] args) {
        String content = "";
        try {
            content =
                    new String(
                            Files.readAllBytes(
                                    Paths.get(
                                            "C:\\Users\\adity\\Downloads\\Programming\\leetcode\\src\\com\\company\\topinterview\\easycollection\\dynamicprogramming\\test.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        long start = System.currentTimeMillis();
        System.out.println(new LongestAwesomeSubstring().longestAwesome(content));
        long end = System.currentTimeMillis();
        long elapsedTime = end - start;
        System.out.println("Time taken in seconds: " + (elapsedTime / 1000));
    }

    public int longestAwesome(String s) {
        int n = s.length();
        int[][] countMatrix = new int[n + 1][10];
        computeCountMatrix(s, countMatrix);
        int max = 1;
        for (int i = 0; i < countMatrix.length; i++) {
            for (int j = i + 1; j < countMatrix.length; j++) {
                max = Math.max(max, cal(i, j, countMatrix));
            }
        }
        return max;
    }

    private int cal(int start, int end, int[][] count) {
        int isOdd = 0;
        for (int i = 0; i < 10 && isOdd < 2; i++) {
            if ((count[end][i] - count[start][i]) % 2 == 1) {
                isOdd++;
            }
        }
        return isOdd < 2 ? (end - start) : 1;
    }

    private void computeCountMatrix(String s, int[][] countMatrix) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            System.arraycopy(countMatrix[i], 0, countMatrix[i + 1], 0, countMatrix[i].length);
            countMatrix[i + 1][c - '0']++;
        }
    }
}
