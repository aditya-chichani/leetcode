package com.company.miscellanous;

import java.util.*;

public class MinimumAbsoluteDifference {
    public List<List<Integer>> minimumAbsDifferenceUsingBruteForce(int[] arr) {
        List<Integer> sortedList = new ArrayList<>(arr.length);
        for (int x : arr)
            sortedList.add(x);
        Collections.sort(sortedList, new Comparator<Integer>() {
            @Override
            public int compare(Integer integer, Integer t1) {
                return Math.abs(integer) - Math.abs(t1);
            }
        });
        HashMap<Integer, List<List<Integer>>> diffListMap = new HashMap<>();
        int diff, minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < sortedList.size() - 1; i++) {
            diff = Math.abs(sortedList.get(i) - sortedList.get(i + 1));
            minDiff = Math.min(diff, minDiff);
            if (diffListMap.containsKey(diff)) {
                diffListMap.get(diff).add(new ArrayList<>(List.of(sortedList.get(i), sortedList.get(i + 1))));
            } else {
                List<List<Integer>> ans = new ArrayList<>();
                ans.add(new ArrayList<>(List.of(sortedList.get(i), sortedList.get(i + 1))));
                diffListMap.put(diff, ans);
            }
        }
        Collections.sort(diffListMap.get(minDiff), Comparator.comparingInt(integers -> integers.get(0)));
        return diffListMap.get(minDiff);
    }

}
