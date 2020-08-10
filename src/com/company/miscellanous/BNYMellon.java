package com.company.miscellanous;

import java.util.HashMap;

public class BNYMellon {
    static HashMap<Character, Character> charMap = new HashMap<>() {{
        put('a', 't');
        put('t', 'a');
        put('c', 'g');
        put('g', 'c');
    }};

    static String mergeTwoStrings(String s1, String s2) {
        int i = 0;
        StringBuffer ans = new StringBuffer();
        while (i < s1.length() && i < s2.length()) {
            ans.append(s1.charAt(i));
            ans.append(s2.charAt(i));
            i++;
        }
        while (i < s1.length()) {
            ans.append(s1.charAt(i++));
        }
        while (i < s2.length()) {
            ans.append(s2.charAt(i++));
        }
        return ans.toString();
    }

    static String getDNAStrand(String s) {

        StringBuffer ans = new StringBuffer();
        for (int i = s.length() - 1; i >= 0; i--) {
            ans.append(charMap.get(s.charAt(i)));
        }
        return ans.toString();
    }

    static int getPalindrome(String s) {
        // toeot, abb, abc, toee, na m an, toe eot
        return 0;
    }
}
