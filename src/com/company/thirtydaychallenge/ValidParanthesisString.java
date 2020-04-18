package com.company.thirtydaychallenge;

public class ValidParanthesisString {
    public static void main(String[] args) {
        String[] strs = {"(*))", "(*)", "(*()", "()", "(((*"};
        for (String s : strs)
            System.out.println(checkValidString(s));
    }

    public static boolean checkValidString(String s) {
        return checkValidStringHelper(s.toCharArray(), 0, 0);
    }

    private static boolean checkValidStringHelper(char[] s, int i, int count) {
        if (i < s.length) {
            char c = s[i];
            if (c == '(') {
                return checkValidStringHelper(s, i + 1, count + 1);
            } else if (c == ')') {
                if (count == 0)
                    return false;
                return checkValidStringHelper(s, i + 1, count - 1);
            } else {
                s[i] = '(';
                boolean l = checkValidStringHelper(s, i, count);
                s[i] = ')';
                return l || checkValidStringHelper(s, i, count) || checkValidStringHelper(s, i + 1, count);
            }
        }
        return count == 0;
    }
}
