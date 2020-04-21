package com.company.thirtydaychallenge;

import java.util.ArrayList;
import java.util.List;

public class BinaryMatrix {
    int[][] mat = new int[][]{{0, 0, 0, 1}, {0, 0, 1, 1}, {0, 1, 1, 1}};

    public List<Integer> dimensions() {
        List<Integer> dim = new ArrayList<>();
        dim.add(3);
        dim.add(4);
        return dim;
    }

    public int get(int x, int y) {
        return mat[x][y];
    }
}
