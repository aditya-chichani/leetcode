package com.company.topinterview.mediumcollection.backtracking;

// Incomplete soln
public class RemoveKDigits {
    static String ans;

    private static void removeKdigitsHelper(String s, int k, int in) {
        if (k == 0) {
            s = stripZeroes(s);
            if (s.length() < ans.length() || (s.length() == ans.length() && ans.compareTo(s) > 0)) {
                ans = s;
            }
            return;
        }

        if (in >= s.length())
            return;

        StringBuffer sb = new StringBuffer(s);
        removeKdigitsHelper(sb.deleteCharAt(in).toString(), k - 1, in);
        removeKdigitsHelper(s, k, in + 1);
    }

    private static String stripZeroes(String s) {
        int i = 0;
        while (i < s.length() && s.charAt(i) == '0')
            i++;
        if (i == s.length())
            return "0";
        return s.substring(i);
    }

    public String removeKdigits(String num, int k) {
        if (k == 0 || num.equals("0"))
            return num;

        int n = num.length();

        if (k == n)
            return "0";

        ans = stripZeroes(num.substring(k, n));
        removeKdigitsHelper(num, k, 0);
        return ans;
    }
}
