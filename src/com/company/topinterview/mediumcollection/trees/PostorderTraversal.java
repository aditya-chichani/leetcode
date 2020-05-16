package com.company.topinterview.mediumcollection.trees;

import com.company.thirtydaychallenge.TreeNode;

import java.util.*;

public class PostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        // Do reverse postorder :D instead of LRV do VRL and put output in LIFO manner :D
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

    public List<Integer> postorderTraversalAdi(TreeNode root) {
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
