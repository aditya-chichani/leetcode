package com.company.topinterview.mediumcollection.trees;

import com.company.thirtydaychallenge.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class BTConstructPostorderAndInorder {
    static int p;
    static Map<Integer, Integer> nodeIndexMap;

    private static TreeNode buildTree(int[] postorder, int start, int end) {
        if (start > end)
            return null;
        TreeNode node = new TreeNode(postorder[p--]);
        if (start == end)
            return node;
        int i = nodeIndexMap.get(postorder[p + 1]);
        node.right = buildTree(postorder, i + 1, end);
        node.left = buildTree(postorder, start, i - 1);
        return node;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        nodeIndexMap = new HashMap<>();
        p = postorder.length - 1;
        for (int i = 0; i < inorder.length; i++)
            nodeIndexMap.put(inorder[i], i);
        return buildTree(postorder, 0, inorder.length - 1);
    }
}
