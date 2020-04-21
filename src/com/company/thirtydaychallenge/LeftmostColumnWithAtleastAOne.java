package com.company.thirtydaychallenge;

import java.util.List;

public class LeftmostColumnWithAtleastAOne {

    static int binarySearch(BinaryMatrix binaryMatrix, int n, int m) {
        int start = 0, end = m - 1, mid;
        while (start < end) {
            mid = start + (end - start) / 2;
            if (binaryMatrix.get(n, mid) == 1)
                end = mid;
            else start = mid + 1;
        }
        return binaryMatrix.get(n, start) == 0 ? Integer.MAX_VALUE : start;
    }

    //O(n+m) soln
    public int leftMostColumnWithOne(BinaryMatrix b) {
        List<Integer> dim = b.dimensions();
        int width = dim.get(0), length = dim.get(1);
        int x = 0, y = length - 1;
        int ans = -1;
        while (x < width && y >= 0) {
            if (b.get(x, y) == 0)
                x++;
            else
                ans = y--;
        }
        return ans;
    }

    // O(nlogm) soln
    public int leftMostColumnWithOneUnoptimized(BinaryMatrix binaryMatrix) {
        List<Integer> dims = binaryMatrix.dimensions();
        int n = dims.get(0);
        int m = dims.get(1);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++)
            ans = Math.min(ans, binarySearch(binaryMatrix, i, m));
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
