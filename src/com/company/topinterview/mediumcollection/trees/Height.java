package com.company.topinterview.mediumcollection.trees;

import com.company.thirtydaychallenge.TreeNode;

import java.util.Stack;

public class Height {
    public static void main(String[] args) {
        System.out.println(getHeight(TreeNode.generateTree("[0,-3,-2,-9,-8,null,null,2,null,null,-5,5]")));
    }

    // Iterative and without using BFS
    public static int getHeight(TreeNode root) {
        if (root == null)
            return 0;

        TreeNode curr = root;
        TreeNode prev = null;

        Stack<TreeNode> s = new Stack<>();
        Stack<Integer> h = new Stack<>();

        while (curr != null || !s.isEmpty()) {
            while (curr != null) {
                s.push(curr);
                curr = curr.left;
            }
            curr = s.peek();
            if (curr.right == null || curr.right == prev) // Left and right is done
            {
                if (curr.left == null)
                    h.push(0);
                if (curr.right == null)
                    h.push(0);
                int max;
                max = h.pop();
                max = Math.max(h.pop(), max);
                h.push(max + 1);
                prev = s.pop();
                // Next node to be visited
                if (!s.isEmpty() && s.peek().right != prev)
                    curr = s.peek().right;
                else curr = null;
            } else {     // Right needs to be visited
                curr = curr.right;
            }
        }

        return h.pop();
    }
}
