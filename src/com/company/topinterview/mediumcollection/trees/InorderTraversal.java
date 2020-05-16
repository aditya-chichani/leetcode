package com.company.topinterview.mediumcollection.trees;

import com.company.thirtydaychallenge.TreeNode;

import java.util.*;

public class InorderTraversal {

    public List<Integer> inorderTraversalOptimal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }


    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null)
            return Collections.EMPTY_LIST;

        // Uses the fact that you need to visit only left part before the root node.

        Stack<TreeNode> s = new Stack<>();
        TreeNode node = root;
        List<Integer> op = new ArrayList<>();

        while (node != null || !s.isEmpty()) {
            if (node != null) {
                s.push(node);
                node = node.left;
            } else {
                node = s.pop();
                op.add(node.val);
                node = node.right;
            }
        }
        return op;
    }

    public List<Integer> inorderTraversalIterativeAdi(TreeNode root) {
        if (root == null)
            return Collections.EMPTY_LIST;

        Set<TreeNode> set = new HashSet<>();
        Stack<TreeNode> s = new Stack<>();
        List<Integer> op = new LinkedList<>();
        s.push(root);

        while (!s.isEmpty()) {
            TreeNode top = s.peek();
            if (top.left == null || set.contains(top.left)) {
                s.pop();
                op.add(top.val);
                set.add(top);
                if (top.right != null)
                    s.push(top.right);
            } else s.push(top.left);
        }
        return op;

    }
}


