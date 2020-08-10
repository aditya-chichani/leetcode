package com.company.revision.stack;

import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums2.length;
        int[] nge = new int[n];
        HashMap<Integer, Integer> numPosMap = new HashMap<>();
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < n; i++) {
            nge[i] = -1;
            numPosMap.put(nums2[i], i);
            while (!s.isEmpty() && nums2[s.peek()] < nums2[i]) {
                nge[s.pop()] = nums2[i];
            }
            s.push(i);
        }
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++)
            ans[i] = nge[numPosMap.get(nums1[i])];
        return ans;
    }
}
