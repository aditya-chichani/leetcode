package com.company.topinterview.mediumcollection.trees;

import com.company.thirtydaychallenge.TreeNode;

public class LowestCommonAncestor {
    static TreeNode ans;
    static int count;

    private static boolean lowestCommonAncestorHelper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return false;
        int left, mid = 0, right = 0;
        if (root == p || root == q) {

            mid = 1;
            count++;
            if (count == 2)    // If second node found no need to traverse its subtrees and also the second node will never be the LCA!
                return true;
        }
        left = lowestCommonAncestorHelper(root.left, p, q) ? 1 : 0;
        if (count != 2)  // The currently unvisited subtree of an ancestor should be visited only if both p nd q have not been found yet
            right = lowestCommonAncestorHelper(root.right, p, q) ? 1 : 0;
        if (left + right + mid == 2) // Will be true only for the LCA and not any other ancestor!
            ans = root;
        return (left + right + mid > 0);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ans = null;
        count = 0;
        lowestCommonAncestorHelper(root, p, q);
        return ans;
    }
}
