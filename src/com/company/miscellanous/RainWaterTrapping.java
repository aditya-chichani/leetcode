package com.company.miscellanous;

import java.util.Stack;

public class RainWaterTrapping {
    static int sum;
    static Stack<Integer> s;
    static int count;

    public static int trap(int[] height) {
        s = new Stack<>();
        int i = 0;
        while (i < height.length && height[i] == 0)
            i++;
        s.push(i);
        i++;
        sum = 0;
        count = 0;
        for (; i < height.length; i++) {
            if (height[i] != 0) {
                process(i, 0, height);
                s.push(i);
                count++;
            }
        }
        System.out.println(height.length + "    " + count);
        return sum;
    }

    private static void process(int r, int p, int[] height) {
        if (s.isEmpty())
            return;
        int l = s.peek();
        sum += ((r - l - 1) * (Math.min(height[r], height[l]) - p));
        if (height[r] >= height[l]) {
            s.pop();
            count++;
        }
        if (height[r] > height[l])
            process(r, height[l], height);
    }

    public static void main(String[] args) {
        System.out.println(RainWaterTrapping.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
