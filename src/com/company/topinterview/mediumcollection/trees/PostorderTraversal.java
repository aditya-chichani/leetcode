package com.company.topinterview.mediumcollection.trees;

import com.company.thirtydaychallenge.TreeNode;

import java.util.*;

public class PostorderTraversal {

    public List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> op = new LinkedList<>();
        if (root == null)
            return op;

        Stack<TreeNode> s = new Stack<>();
        TreeNode node = root;
        TreeNode prev = null;
        while (node != null || !s.isEmpty()) {
            if (node != null) {
                s.push(node);
                node = node.left;
            } else {
                node = s.peek();
                if (node.right == null || node.right == prev) // Either curr node is a leaf node or its right subtree is already visited
                {
                    prev = s.pop();
                    op.add(node.val); // Visit curr node

                    if (!s.isEmpty() && s.peek().right != prev)  // The next node to be visited will either be the top's right if it is not visited yet or it will be the top itself
                        node = s.peek().right; // Visit Top's right
                    else node = null;  // Visit top
                } else  // Right subtree is not null and also not visited
                {
                    node = node.right;
                }
            }
        }


        return op;
    }


    public List<Integer> postorderTraversalTrick(TreeNode root) {
        // Do reverse postorder :D instead of LRV do VRL and put output in LIFO manner :D Useful only when you have to print nodes!
        LinkedList<Integer> op = new LinkedList<>();
        if (root == null)
            return op;
        Stack<TreeNode> s = new Stack<>();
        TreeNode node = root;
        while (node != null || !s.isEmpty()) {
            if (node != null) {
                op.addFirst(node.val);
                s.push(node);
                node = node.right;
            } else {
                node = s.pop().left;
            }
        }
        return op;

    }

    public List<Integer> postorderTraversalAdi(TreeNode root) { // Uses Additional visited space
        List<Integer> op = new LinkedList<>();
        if (root == null)
            return op;
        Stack<TreeNode> s = new Stack<>();
        Set<TreeNode> set = new HashSet<>();
        s.push(root);
        while (!s.isEmpty()) {
            TreeNode node = s.peek();
            if (set.contains(node)) {
                s.pop();
                set.remove(node);
                op.add(node.val);
            } else {
                set.add(node);
                if (node.right != null)
                    s.push(node.right);
                if (node.left != null)
                    s.push(node.left);
            }
        }
        return op;
    }
}
