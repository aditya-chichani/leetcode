package com.company.topinterview.easycollection.strings;

public class AToI {
    public static void main(String[] args) {
        System.out.println(myAtoi("-6147483648"));
    }

    public static int myAtoi(String s) {
        int sign = 1;
        int num = 0;
        long p = 0;
        int i = 0, power = 0;
        int start;
        while (i < s.length() && s.charAt(i) == ' ')
            i++;

        if (i < s.length() && s.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (i < s.length() && s.charAt(i) == '+')
            i++;

        start = i;

        while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9')
            i++;

        i--;

        while (i >= start) {
            p += (s.charAt(i) - '0') * (int) Math.pow(10, power);
            num = (int) p;
            if (num != p)
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            power++;
            i--;
        }
        return num * sign;
    }
}
