package com.company.topinterview.mediumcollection.trees;

import com.company.thirtydaychallenge.TreeNode;

public class ConvertSortedArrayToBST {
    public static void main(String[] args) {
        int[] nums = new int[]{-10, -3, 0, 5, 9};
        System.out.println(0 >> 1);
        TreeNode treeNode = new ConvertSortedArrayToBST().sortedArrayToBST(nums);
        System.out.println(treeNode);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }


    private TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if (start > end)
            return null;
        int mid = start + ((end - start) >> 1);
        TreeNode curr = new TreeNode(nums[mid]);
        curr.left = sortedArrayToBST(nums, start, mid - 1);
        curr.right = sortedArrayToBST(nums, mid + 1, end);
        return curr;
    }
}
