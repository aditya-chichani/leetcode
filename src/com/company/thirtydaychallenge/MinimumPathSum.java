package com.company.thirtydaychallenge;

import java.util.Arrays;

public class MinimumPathSum {
    public static void main(String[] args) {
        minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}});
    }

    public static int minPathSum(int[][] grid) {  // Did it using DP - O(n) solution
        int m = grid.length;
        int n = grid[0].length;
        int[][] sum = new int[m][n];
        int i = m - 1, j;

        sum[m - 1][n - 1] = grid[m - 1][n - 1];

        for (j = n - 2; j >= 0; j--) {
            sum[m - 1][j] = grid[m - 1][j] + sum[m - 1][j + 1];
        }

        for (i = m - 2; i >= 0; i--) {
            sum[i][n - 1] = grid[i][n - 1] + sum[i + 1][n - 1];
        }

        for (i = m - 2; i >= 0; i--) {
            for (j = n - 2; j >= 0; j--) {
                sum[i][j] = grid[i][j] + Math.min(sum[i][j + 1], sum[i + 1][j]);
            }
        }

        return sum[0][0];
    }

    public static int minPathSumUsingBacktracking(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] sum = new int[m][n];
        for (int i = 0; i < m; i++)
            Arrays.fill(sum[i], -1);
        computeSum(m - 1, n - 1, sum, grid, 0);
        return sum[0][0];
    }

    private static void computeSum(int m, int n, int[][] sum, int[][] grid, int mps) {   // Goes to the same place multiple times - Backtracking solution - not optimal
        if (m < 0 || n < 0 || m >= grid.length || n >= grid[0].length)
            return;
        if (sum[m][n] == -1) {
            sum[m][n] = mps + grid[m][n];
        } else {
            sum[m][n] = Math.min(sum[m][n], mps + grid[m][n]);
        }
        computeSum(m, n - 1, sum, grid, sum[m][n]);
        computeSum(m - 1, n, sum, grid, sum[m][n]);
    }
}
