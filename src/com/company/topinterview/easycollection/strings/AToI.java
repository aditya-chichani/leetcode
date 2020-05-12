package com.company.topinterview.easycollection.strings;

public class AToI {
    public static void main(String[] args) {
        System.out.println(myAtoi("     -11009215950h"));
    }

    public static int myAtoi(String s) {
        int sign = 1;
        int p = 0;
        int i = 0;
        int digit;

        //For spaces
        while (i < s.length() && s.charAt(i) == ' ')
            i++;
        //For sign
        if (i < s.length() && s.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (i < s.length() && s.charAt(i) == '+') {
            i++;
        }
        //For strings not starting with spaces or numbers
        if (i < s.length() && !(s.charAt(i) >= '0' && s.charAt(i) <= '9'))
            return 0;

        //Actual computation
        while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            digit = sign * (s.charAt(i) - '0');
            if (p >= 0) {
                if (p > Integer.MAX_VALUE / 10 || (p == Integer.MAX_VALUE / 10) && digit > Integer.MAX_VALUE % 10)
                    return Integer.MAX_VALUE;
                else p = p * 10 + digit;
            } else {
                if (p < Integer.MIN_VALUE / 10 || (p == Integer.MIN_VALUE / 10) && digit < Integer.MIN_VALUE % 10)
                    return Integer.MIN_VALUE;
                else p = p * 10 + digit;
            }
            i++;
        }
        return p;
    }
}
