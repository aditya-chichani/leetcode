package com.company.topinterview.mediumcollection.backtracking;

import java.util.*;

public class Permutations {
    static List<List<Integer>> ans;

    public static List<List<Integer>> permute(int[] nums) {
        ans = new LinkedList<>();
        if (nums == null || nums.length < 2)
            return ans;
        Set<Integer> input = new LinkedHashSet<>();
        List<Integer> output = new ArrayList<>();
        for (int x : nums)
            input.add(x);
        permuteHelper(input, output);
        return ans;
    }

    private static void permuteHelper(Set<Integer> i, List<Integer> o) {
        if (i.size() == 0)
            ans.add(o);
        else {
            for (Integer x : i) {
                LinkedHashSet<Integer> t1 = new LinkedHashSet<>(i);
                List<Integer> t2 = new ArrayList<>(o);
                t1.remove(x);
                t2.add(x);
                permuteHelper(t1, t2);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1, 2, 3}));
    }
}
