package com.enterprise.facebook.leetcode;

/**
 * Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 */
public class Code130_SurroundedRegions {
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }

        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                if (!isBorder(board, i, j)) {
                    continue;
                }
                if (board[i][j] == 'O') {
                    dfs(board, i, j);
                }
            }
        }

        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                if (board[i][j] == '*') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        if (i<0 || j<0 || i== board.length || j== board[0].length) {
            return;
        }

        if (board[i][j]!= 'O') {
            return;
        }

        board[i][j] = '*';
        dfs(board, i+1, j);
        dfs(board, i, j+1);
        dfs(board, i-1, j);
        dfs(board, i, j-1);
    }

    private boolean isBorder(char[][] board, int i, int j) {
        if (i==0 || j==0 || i==board.length-1 || j==board[0].length-1) {
            return true;
        }
        return false;
    }
}
