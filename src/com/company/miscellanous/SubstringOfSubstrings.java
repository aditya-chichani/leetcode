package com.company.miscellanous;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SubstringOfSubstrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] s1 = s.split(" ");
        int n = Integer.parseInt(s1[0]);
        int q = Integer.parseInt(s1[1]);
        String[] inputs = new String[q + 1];
        for (int i = 0; i <= q; i++) {
            inputs[i] = sc.nextLine();
        }
        int[][] countMatrix = new int[n + 1][26];
        computeCountMatrix(inputs[0], countMatrix);

        for (int i = 1; i <= q; i++) {
            String[] s2 = inputs[i].split(" ");
            //substringHelper(inputs[0].substring(Integer.parseInt(s2[0])-1,Integer.parseInt(s2[1])));
            substringOnePassHelper(inputs[0], Integer.parseInt(s2[0]), Integer.parseInt(s2[1]), countMatrix);
        }

    }

    private static void substringOnePassHelper(String s, int start, int end, int[][] countMatrix) {
        if (start == end)
            System.out.println(1);
        else {
            int n = 0;
            countMatrix[start][s.charAt(start - 1) - 'a']--;
            for (int i = 0; i < 26; i++) // Constant time :)
            {
                int count = countMatrix[end][i] - countMatrix[start][i];
                n += ((count * (count + 1)) / 2);
            }
            System.out.println(n);
            countMatrix[start][s.charAt(start - 1) - 'a']++;
        }
    }

    private static void computeCountMatrix(String s, int[][] countMatrix) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            System.arraycopy(countMatrix[i], 0, countMatrix[i + 1], 0, countMatrix[i].length);
            countMatrix[i + 1][c - 'a']++;
        }
    }

    private static void substringHelper(String input) {
        int n = 0;
        Map<Character, Integer> charCountMap = new HashMap<>();
        for (int i = 0; i < input.length(); i++) {
            charCountMap.put(input.charAt(i), charCountMap.getOrDefault(input.charAt(i), 0) + 1);
        }
        for (char c : charCountMap.keySet()) {
            int count = charCountMap.get(c);
            n += ((count * (count + 1)) / 2);
        }
        System.out.println(n);
    }
}

/*
Input:
6 4
abcaab
1 1
2 5
3 6
1 6

Output:
1
5
5
10
*/
