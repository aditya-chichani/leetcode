package com.company.thirtydaychallenge;

import java.util.Stack;

public class BackSpaceCompare {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> sStack = new Stack<>();
        Stack<Character> tStack = new Stack<>();
        populateStack(S, sStack); // O(N)
        populateStack(T, tStack); // O(N)
        while(!sStack.isEmpty() && !tStack.isEmpty()) // Both are Non empty O(N)
        {
            if(sStack.pop()!=tStack.pop())
                return false;
        }
        return  (sStack.isEmpty() && tStack.isEmpty()); // If Both empty, only then return true
    }

    private void populateStack(String S, Stack<Character> stack) {
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c == '#' && !stack.isEmpty())
                stack.pop();
            else {
                if (c != '#')
                    stack.push(c);
            }
        }
    }
}
