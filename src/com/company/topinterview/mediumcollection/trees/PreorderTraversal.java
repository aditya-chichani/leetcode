package com.company.topinterview.mediumcollection.trees;

import com.company.thirtydaychallenge.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal {

    public List<Integer> preorderTraversalAdi1(TreeNode root) {

        List<Integer> op = new ArrayList<>();
        if (root == null)
            return op;
        Stack<TreeNode> s = new Stack<>();
        s.push(root);

        while (!s.isEmpty()) {
            TreeNode node = s.pop();
            op.add(node.val);
            if (node.right != null)
                s.push(node.right);
            if (node.left != null)
                s.push(node.left);
        }

        return op;

    }

    public List<Integer> preorderTraversalAdi2(TreeNode root) {
        List<Integer> op = new ArrayList<>();
        if (root == null)
            return op;
        TreeNode node = root;
        Stack<TreeNode> s = new Stack<>();
        while (node != null || !s.isEmpty()) {
            if (node != null) {
                op.add(node.val);
                if (node.right != null)
                    s.push(node.right);
                node = node.left;
            } else node = s.pop();
        }
        return op;
    }


    public List<Integer> preorderTraversalSuperSimilarToInorder(TreeNode root) {
        if (root == null)
            return Collections.EMPTY_LIST;

        Stack<TreeNode> s = new Stack<>();
        TreeNode node = root;
        List<java.lang.Integer> op = new ArrayList<>();

        while (node != null || !s.isEmpty()) {
            if (node != null) {
                s.push(node);
                op.add(node.val); //Preorder :D
                node = node.left;
            } else {
                node = s.pop();
                //op.add(node.val); // Inorder
                node = node.right;
            }
        }
        return op;
    }
}
