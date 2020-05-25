package com.company.topinterview.mediumcollection.trees;

import com.company.thirtydaychallenge.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class BTConstructPreorderAndInorder {
    int preorderIndex = 0;

    private static TreeNode buildTreeHelperAdi(int[] preorder, int pIndex, int istart, int iend, Map<Integer, Integer> nodePosMap, int[] inorder) {
        if (pIndex >= preorder.length || istart > iend)
            return null;

        if (istart == iend)
            return new TreeNode(inorder[istart]);


        int in = nodePosMap.get(preorder[pIndex]);
        if (in < istart || in > iend)
            return buildTreeHelperAdi(preorder, pIndex + 1, istart, iend, nodePosMap, inorder);


        TreeNode root = new TreeNode(preorder[pIndex]);
        root.left = buildTreeHelperAdi(preorder, pIndex + 1, istart, in - 1, nodePosMap, inorder);
        root.right = buildTreeHelperAdi(preorder, pIndex + 1, in + 1, iend, nodePosMap, inorder);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0)
            return null;
        Map<Integer, Integer> nodePosMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++)
            nodePosMap.put(inorder[i], i);
        //return buildTreeHelperAdi(preorder,0,0,inorder.length-1,nodePosMap,inorder);
        return buildTree(preorder, 0, inorder.length - 1, nodePosMap);
    }

    // Cleaner way :D
    private TreeNode buildTree(int[] preorder, int start, int end, Map<Integer, Integer> nodePosMap) {
        if (start > end)
            return null;
        int point = preorder[preorderIndex++];
        TreeNode node = new TreeNode(point);
        if (start == end)
            return node;
        int inorderIndex = nodePosMap.get(point);
        node.left = buildTree(preorder, start, inorderIndex - 1, nodePosMap);
        node.right = buildTree(preorder, inorderIndex + 1, end, nodePosMap);
        return node;
    }
}
