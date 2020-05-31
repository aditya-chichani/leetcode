package com.company.topinterview.mediumcollection.trees;

import com.company.thirtydaychallenge.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class InorderPredecessorAndSuccessor {
    static TreeNode p, q, prev;

    public static List<TreeNode> findInorderPredecessorAndSuccessor(TreeNode root, TreeNode node) {
        p = q = prev = null;
        inorder(root, node);
        List<TreeNode> ans = new ArrayList<>(2);
        ans.add(p);
        ans.add(q);
        return ans;
    }

    private static void inorder(TreeNode root, TreeNode node) {
        if (root == null || q != null)
            return;
        inorder(root.left, node);
        if (root.val == node.val) {
            p = prev;
        } else if (prev != null && prev.val == node.val) {
            q = root;
            return;
        }
        prev = root;
        inorder(root.right, node);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.generateTree("1,2,3,4,5,6,7");
        List<TreeNode> ans = findInorderPredecessorAndSuccessor(root, new TreeNode(4));
        System.out.println(ans);
    }
}
