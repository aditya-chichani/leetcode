package com.company.thirtydaychallenge;

import java.util.HashMap;

public class DiameterOfBinaryTree {
    int ans;

    public int diameterOfBinaryTree(TreeNode root){
        ans =1;
        height(root);
        return ans-1;
    }

    private int height(TreeNode root) {
        if(root == null)
            return 0;
        int L = height(root.left);
        int R = height(root.right);
        ans = Math.max(ans,L+R+1); // Update diameter
        return Math.max(L,R)+1;  // Return height
    }


    public int UnOptimizedDiameterOfBinaryTree(TreeNode root) { // Beats just 15% of submissions!
        return Math.max(diameter(root).get(0)-1,0);
    }

    public HashMap<Integer,Integer> diameter(TreeNode root){
        HashMap<Integer,Integer> nodeMap = new HashMap<>();
        if(root == null)
        {
            nodeMap.put(0,0);
            nodeMap.put(1,0);
            return nodeMap;
        }

        HashMap<Integer, Integer> leftNodeMap = diameter(root.left);
        HashMap<Integer, Integer> rightNodeMap = diameter(root.right);

        int diameter = Math.max(Math.max(leftNodeMap.get(0), rightNodeMap.get(0)), leftNodeMap.get(1)+ rightNodeMap.get(1)+1);
        int height = Math.max(leftNodeMap.get(1),rightNodeMap.get(1))+1;
        nodeMap.put(0,diameter);
        nodeMap.put(1,height);
        return nodeMap;
    }
}
