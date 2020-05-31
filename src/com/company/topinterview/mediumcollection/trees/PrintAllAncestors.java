package com.company.topinterview.mediumcollection.trees;

import com.company.thirtydaychallenge.TreeNode;

import java.util.Stack;

public class PrintAllAncestors {
    static boolean nodeFound;
    public static void main(String[] args) {
        TreeNode root = TreeNode.generateTree("1,2,3,4,5,6,7");
        //printAllAncestors(root, 7);
        nodeFound = false;
        findAllAncestors(root, 7, new Stack<Integer>());
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

    private static void findAllAncestors(TreeNode root, int data, Stack<Integer> s) {
        if (root == null)
            return;
        s.push(root.val);
        if (root.val == data) {
            nodeFound = true;
            while (!s.isEmpty())
                System.out.println(s.pop());
            return;
        }
        findAllAncestors(root.left, data, s);
        if (!nodeFound) {
            findAllAncestors(root.right, data, s);
            if (!nodeFound)
                s.pop();
        }
    }
}
