package com.company.topinterview.mediumcollection.backtracking;

public class WordSearch {
    public static void main(String[] args) {
        char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(exist(board, "ABCESEEEFS"));
    }

    public static boolean exist(char[][] board, String word) {

        boolean[][] visited;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    visited = new boolean[board.length][board[0].length];
                    if (existHelper(board, word, i, j, 0, visited))
                        return true;
                }
            }
        }
        return false;
    }

    private static boolean existHelper(char[][] board, String word, int i, int j, int index, boolean[][] visited) {
        if (index >= word.length())
            return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || board[i][j] != word.charAt(index))
            return false;
        visited[i][j] = true;
        return existHelper(board, word, i - 1, j, index + 1, getCopy(visited)) || existHelper(board, word, i + 1, j, index + 1, getCopy(visited)) ||
                existHelper(board, word, i, j + 1, index + 1, getCopy(visited)) || existHelper(board, word, i, j - 1, index + 1, getCopy(visited));
    }

    private static boolean[][] getCopy(boolean[][] visited) {
        boolean[][] tmp = new boolean[visited.length][visited[0].length];
        for (int i = 0; i < visited.length; i++)
            tmp[i] = visited[i].clone();
        return tmp;
    }

}
