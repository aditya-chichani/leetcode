package com.company.topinterview.mediumcollection.trees;

import com.company.thirtydaychallenge.TreeNode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class MirrorTree {
    // Also known as invert a tree
    // The reverse of inorder(LVR) of a tree will be the inorder of its mirror (RVL)

    public TreeNode invertTree(TreeNode root) {
   /*
    Recursive solution
        if(root==null)
           return root;
      TreeNode l = invertTree(root.right);
      TreeNode r = invertTree(root.left);
      root.left = l;
      root.right = r;
      return root;
    */

        // Iterative soln (Postorder Traversal):
        if (root == null)
            return root;
        Stack<TreeNode> s = new Stack<>();
        Set<TreeNode> visited = new HashSet<>();
        s.push(root);
        while (!s.isEmpty()) {
            TreeNode node = s.peek();
            if (visited.contains(node)) {
                TreeNode tmp = node.left;
                node.left = node.right;
                node.right = tmp;
                s.pop();
                visited.remove(node);
            } else {
                if (node.right != null)
                    s.push(node.right);
                if (node.left != null)
                    s.push(node.left);
                visited.add(node);
            }
        }
        return root;
    }
}
