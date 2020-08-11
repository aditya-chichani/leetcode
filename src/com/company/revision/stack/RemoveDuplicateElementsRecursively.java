package com.company.revision.stack;

import java.util.Stack;

public class RemoveDuplicateElementsRecursively {
    public static void main(String[] args) {
        int[] ans = new RemoveDuplicateElementsRecursively().remove(new int[]{1, 5, 6, 8, 8, 8, 0, 1, 1, 0, 6, 5});
        for (int i : ans) System.out.print(i + " ");
    }

    int[] remove(int[] nums) {
        if (nums == null || nums.length == 0)
            return nums;
        Stack<Integer> s = new Stack<>();
        s.push(nums[0]);
        boolean isPopped = false;
        int pop = 0;
        for (int i = 1; i < nums.length; i++) {
            int top = isPopped ? pop : s.peek();

            if (nums[i] == top) {
                if (!isPopped) {
                    isPopped = true;
                    pop = s.pop();
                }
            } else {
                if (!isPopped) {
                    s.push(nums[i]);
                } else {
                    if (s.isEmpty() || nums[i] != s.peek()) {
                        s.push(nums[i]);
                        pop = 0;
                        isPopped = false;
                    } else {
                        pop = s.pop();
                    }
                }
            }
        }
        int[] ans = new int[s.size()];
        int c = s.size() - 1;
        while (!s.isEmpty()) {
            ans[c--] = s.pop();
        }
        return ans;
    }
}
