package com.company.topinterview.mediumcollection.trees;

import com.company.thirtydaychallenge.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class FullBTConstructPreorderAndPostorder {
    static int prestart;

    public static void main(String[] args) {
        TreeNode treeNode = constructFromPrePost(new int[]{1, 2, 4, 5, 3, 6, 7}, new int[]{4, 5, 2, 6, 7, 3, 1});
        System.out.println(treeNode);
    }

    public static TreeNode constructFromPrePost(int[] pre, int[] post) {
        prestart = 0;
        Map<Integer, Integer> nodeIndexMap = new HashMap<>();
        for (int i = 0; i < post.length; i++)
            nodeIndexMap.put(post[i], i);
        return constructFromPrePost(pre, 0, post.length - 1, nodeIndexMap);
    }

    private static TreeNode constructFromPrePost(int[] pre, int poststart, int postend, Map<Integer, Integer> nodeIndexMap) {
        if (poststart > postend)
            return null;
        TreeNode node = new TreeNode(pre[prestart++]);
        if (poststart == postend)
            return node;
        int p = nodeIndexMap.get(pre[prestart]);
        node.left = constructFromPrePost(pre, poststart, p, nodeIndexMap);
        node.right = constructFromPrePost(pre, p + 1, postend - 1, nodeIndexMap);
        return node;
    }
}
