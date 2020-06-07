package com.company.topinterview.mediumcollection.trees;

import com.company.thirtydaychallenge.TreeNode;

public class FloorAndCeilOfBST {
    static TreeNode ans;

    public static TreeNode findFloor(TreeNode root, int key) {
        ans = null;
        findFloorHelper(root, key);
        return ans;
    }

    private static void findFloorHelper(TreeNode root, int key) {
        if (root == null)
            return;

        if (key == root.val) {
            ans = root;
            return;
        }

        if (key < root.val)
            findFloorHelper(root.left, key);
        else {
            ans = root;
            findFloorHelper(root.right, key);
        }
    }

    public static TreeNode findCeil(TreeNode root, int key) {
        ans = null;
        findCeilHelper(root, key);
        return ans;
    }

    private static void findCeilHelper(TreeNode root, int key) {
        if (root == null)
            return;

        if (key == root.val) {
            ans = root;
            return;
        }

        if (key > root.val)
            findCeilHelper(root.right, key);
        else {
            ans = root;
            findCeilHelper(root.left, key);
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.generateBST("[1,2,8,10,12,19]");
        int[] keys = new int[]{0, 1, 5, 20};
        for (int key : keys) {
            System.out.println("Floor for " + key + " is " + findFloor(root, key));
            System.out.println("Ceil for " + key + " is " + findCeil(root, key));
        }
    }
}
