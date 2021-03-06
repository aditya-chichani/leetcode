package com.company.thirtydaychallenge;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public static TreeNode generateBST(String s) {
        s = s.replace("[", "").replace("]", "").replace("{", "").replace("}", "");
        String[] split = s.split(",");
        List<Integer> nums = new ArrayList<>();
        for (String x : split)
            nums.add(Integer.parseInt(x));
        return sortedArrayListToBST(nums, 0, nums.size() - 1);
    }

    private static TreeNode sortedArrayListToBST(List<Integer> nums, int start, int end) {
        if (start > end)
            return null;
        int mid = start + ((end - start) >> 1);
        TreeNode curr = new TreeNode(nums.get(mid));
        curr.left = sortedArrayListToBST(nums, start, mid - 1);
        curr.right = sortedArrayListToBST(nums, mid + 1, end);
        return curr;
    }

    public static TreeNode generateTree(String s) {
        s = s.replace("[", "");
        s = s.replace("]", "");
        String[] split = s.split(",");
        List<Integer> nodes = new ArrayList<>();

        for (String str : split) {
            if (str.equals("null"))
                nodes.add(null);
            else nodes.add(Integer.parseInt(str));
        }

        return generateTreeHelper(nodes);
    }

    private static TreeNode generateTreeHelper(List<Integer> nodes) {
        //[3,9,20,null,null,15,7]
        if (nodes == null || nodes.size() == 0)
            return null;

        TreeNode root = new TreeNode(nodes.get(0));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int i = 1;

        while (!q.isEmpty() && i < nodes.size()) {
            TreeNode curr = q.poll();
            if (nodes.get(i) != null)
                curr.left = new TreeNode(nodes.get(i));
            i++;

            if (i < nodes.size() && nodes.get(i) != null)
                curr.right = new TreeNode(nodes.get(i));

            i++;

            if (curr.left != null)
                q.offer(curr.left);
            if (curr.right != null)
                q.offer(curr.right);
        }
        return root;
    }

    @Override
    public String toString() {
        return String.valueOf(this.val);
    }
}
