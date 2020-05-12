package com.company.thirtydaychallenge;

public class MaxPathSumBinaryTree {
    int max;

    private int maxPathSumHelper(TreeNode root) {
        int l, r, sum, v = root.val;
        if (root.left == null && root.right == null) {
            max = Math.max(max, root.val);
            return root.val;
        }
        if (root.left == null) {
            r = maxPathSumHelper(root.right);
            sum = Math.max(v, r + v);
            max = Math.max(max, Math.max(sum, r));
            return sum;
        }
        if (root.right == null) {
            l = maxPathSumHelper(root.left);
            sum = Math.max(v, l + v);
            max = Math.max(max, Math.max(sum, l));
            return sum;
        }
        l = maxPathSumHelper(root.left);
        r = maxPathSumHelper(root.right);
        sum = Math.max(r + v, Math.max(l + v, v));
        max = Math.max(max, Math.max(sum, Math.max(l, Math.max(r, l + r + v))));
        return sum;
    }
}
