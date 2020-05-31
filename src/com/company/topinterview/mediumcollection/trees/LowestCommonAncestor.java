package com.company.topinterview.mediumcollection.trees;

import com.company.thirtydaychallenge.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

import static com.company.thirtydaychallenge.TreeNode.generateTree;

public class LowestCommonAncestor {
    static TreeNode ans;
    static int count;
    Queue<TreeNode> pQueue;
    Queue<TreeNode> qQueue;

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

    public static void main(String[] args) {
        LowestCommonAncestor l = new LowestCommonAncestor();
        TreeNode root = generateTree("[3,5,1,6,2,0,8,null,null,7,4]");
        TreeNode ans = l.lowestCommonAncestorPath(root, new TreeNode(3), new TreeNode(5));
        System.out.println(ans.val);
    }

    public TreeNode lowestCommonAncestorRecursive(TreeNode root, TreeNode p, TreeNode q) {
        ans = null;
        count = 0;
        lowestCommonAncestorHelper(root, p, q);
        return ans;
    }

    public TreeNode lowestCommonAncestorPath(TreeNode root, TreeNode p, TreeNode q) {
        lowestCommonAncestorPathHelper(root, p, q, new LinkedList<TreeNode>());
        TreeNode ans = null;
        while (!pQueue.isEmpty() && !qQueue.isEmpty() && pQueue.peek() == qQueue.peek()) {
            ans = pQueue.poll();
            qQueue.poll();
        }
        return ans;
    }

    private void lowestCommonAncestorPathHelper(TreeNode root, TreeNode p, TreeNode q, LinkedList<TreeNode> treeNodes) {
        if (root == null)
            return;
        treeNodes.addLast(root);
        if (root.val == p.val) {
            pQueue = (Queue<TreeNode>) treeNodes.clone();
        }
        if (root.val == q.val) {
            qQueue = (Queue<TreeNode>) treeNodes.clone();
        }
        lowestCommonAncestorPathHelper(root.left, p, q, treeNodes);
        lowestCommonAncestorPathHelper(root.right, p, q, treeNodes);
        treeNodes.pollLast();
    }
}
