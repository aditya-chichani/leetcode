package com.company.thirtydaychallenge;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LastStoneWeight {

    public static void main(String[] args) {
        System.out.println(getWeight(new int[]{2, 2}));
    }

    public static int getWeight(int[] stones) {
        int x, y = 0, i;
        List<Integer> st = new LinkedList<Integer>();
        for (int stone : stones)
            st.add(stone);
        st.sort(Collections.reverseOrder());

        while (st.size() > 1) {
            y = st.remove(0);
            x = st.remove(0);
            int diff = y - x;
            if (diff > 0) {
                for (i = 0; i < st.size() && st.get(i) > diff; i++) ;
                st.add(i, diff);
            }
        }
        if (st.size() == 1)
            return st.get(0);
        return 0;
    }
}
