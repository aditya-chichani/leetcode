package com.company.topinterview.easycollection.others;

import java.util.Stack;

public class ValidParantheses {
    public static void main(String[] args) {
        System.out.println(new ValidParantheses().isValid("()"));
    }

    public boolean isValid(String s) {
        Stack<String> opStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '}' && (opStack.isEmpty() || !opStack.pop().equals("{")))
                return false;
            if (c == ')' && (opStack.isEmpty() || !opStack.pop().equals("(")))
                return false;
            if (c == ']' && (opStack.isEmpty() || !opStack.pop().equals("[")))
                return false;
            if (c == ')' || c == ']' || c == '}')
                opStack.push(c + "");
        }
        return opStack.isEmpty();
    }
}
