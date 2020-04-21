package com.company.thirtydaychallenge;

public class ConstructBSTFromPreorder {
    static void insertInBST(TreeNode root, int data) {
        if (data < root.val) {
            if (root.left == null) {
                root.left = new TreeNode(data);
                return;
            }
            insertInBST(root.left, data);
        } else {
            if (root.right == null) {
                root.right = new TreeNode(data);
                return;
            }
            insertInBST(root.right, data);
        }

    }

    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder.length == 0)
            return null;
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 1; i < preorder.length; i++)
            insertInBST(root, preorder[i]);
        return root;
    }
}
