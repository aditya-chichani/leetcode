package com.company.miscellanous;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            System.out.println(i + "  " + Math.log((double) i / 10.0f));
        }

        Set<String> set = new HashSet<>();
        ArrayList<String> strings = new ArrayList<>(set);
        System.out.println(strings.size());
        String[] my = new String[]{"()()()()", "(()())()", "(()(()))", "()()(())", "(((())))", "(())()()", "()((()))", "()(())()", "()(()())", "(()()())", "((()()))", "((()))()", "((())())"};
        for (String s : my) {
            if (!set.add(s))
                System.out.println("Duplicate " + s);
        }
        String[] yours = new String[]{"(((())))", "((()()))", "((())())", "((()))()", "(()(()))", "(()()())", "(()())()", "(())(())", "(())()()", "()((()))", "()(()())", "()(())()", "()()(())", "()()()()"};

        for (String s : yours) {
            if (set.add(s)) {
                System.out.println("Put this " + s);
            }
        }
        System.out.println(my.length - yours.length);
    }
}
