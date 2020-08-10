package com.company.revision.stack;

import java.util.ArrayList;
import java.util.List;

public class FindCelebrity {
    final int[][] matr = new int[][]{{1, 1, 0}, {0, 1, 0}, {1, 1, 1}};
    int n = 3;

    public int findCelebrity() {
        List<Integer> set = new ArrayList<>();
        for (int i = 0; i < n; i++)
            set.add(i);

        for (int i = 0; i < n; i++) {
            List<Integer> tmp = new ArrayList<>();
            for (Integer j : set) {
                if (knows(i, j))
                    tmp.add(j);
            }
            set = tmp;
        }
        // Set will now contain only those people whom everyone knows - Possible celebrity
        int ans;

        // Now checking if the remaining person knows nobody - Definite celebrity
        if (set.size() != 1)
            ans = -1;
        else {
            int count = 0;
            for (int i = 0; i < n; i++)
                if (knows(set.get(0), i))
                    count++;
            if (count > 1)
                ans = -1;
            else ans = set.get(0);
        }
        return ans;
    }

    boolean knows(int a, int b) {
        return matr[a][b] == 1;
    }
}
