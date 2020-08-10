package com.company.revision.recursion;

public class TowerOfHanoi {
    static int count;

    static void tower(char s, char d, char a, int n) {
        count++;
        if (n == 1) {
            System.out.println("Move disk from Source " + s + " to Destination " + d);
            return;
        }
        tower(s, a, d, n - 1);
        System.out.println("Move disk from Source " + s + " to Destination " + d);
        tower(a, d, s, n - 1);
    }

    public static void main(String[] args) {
        count = 0;
        tower('A', 'B', 'C', 3);
        System.out.println(count);
    }
}
