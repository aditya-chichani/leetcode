package com.company.topinterview.mediumcollection.arraysandstrings;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        List<List<Integer>> lists = new ThreeSum().threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(lists);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Map<Integer, Integer> numCountMap = new HashMap<>();
        Map<Integer, Set<Integer>> tripletMap = new HashMap<>();
        List<List<Integer>> ans = new LinkedList<>();
        if (nums.length < 3)
            return ans;

        for (int num : nums)
            numCountMap.put(num, numCountMap.getOrDefault(num, 0) + 1);

        for (int i = 0; i < nums.length - 1; i++) {
            numCountMap.put(nums[i], numCountMap.get(nums[i]) - 1);
            for (int j = i + 1; j < nums.length; j++) {
                numCountMap.put(nums[j], numCountMap.get(nums[j]) - 1);
                int c = (nums[i] + nums[j]) * -1;
                if (numCountMap.getOrDefault(c, 0) > 0) // Triplet Found
                {
                    List<Integer> tmp = new ArrayList<>(3);
                    tmp.add(nums[i]);
                    tmp.add(nums[j]);
                    tmp.add(c);
                    Collections.sort(tmp);
                    if (tripletMap.containsKey(tmp.get(0))) {
                        if (!tripletMap.get(tmp.get(0)).contains(tmp.get(1))) {
                            ans.add(tmp);
                            tripletMap.get(tmp.get(0)).add(tmp.get(1));
                        }
                    } else {
                        ans.add(tmp);
                        Set<Integer> s = new HashSet<>();
                        s.add(tmp.get(1));
                        tripletMap.put(tmp.get(0), s);
                    }
                }
                numCountMap.put(nums[j], numCountMap.get(nums[j]) + 1);
            }
            numCountMap.put(nums[i], numCountMap.get(nums[i]) + 1);
        }
        return ans;
    }
}
