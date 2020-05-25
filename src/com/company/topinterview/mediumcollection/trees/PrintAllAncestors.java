package com.company.topinterview.mediumcollection.trees;

import com.company.thirtydaychallenge.TreeNode;

public class PrintAllAncestors {
    public static void main(String[] args) {
        TreeNode root = TreeNode.generateTree("1,2,3,4,5,6,7");
        printAllAncestors(root, 7);
    }

    private static boolean printAllAncestors(TreeNode root, int data) {
        if (root == null)
            return false;
        if (root.val == data) {
            System.out.println(root.val);
            return true;
        }
        if (printAllAncestors(root.left, data) || printAllAncestors(root.right, data)) {
            System.out.println(root.val);
            return true;
        }
        return false;
    }
}
