package com.enterprise.facebook.leetcode;

public class Code79_WordSearch {
    public boolean exist(char[][] board, String word) {
        for (int i=0; i<board.length; i++) {
            for (int j = 0; j<board[0].length; j++) {
                if (dfs(i, j, board, 0, word, new boolean[board.length][board[0].length])) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, char[][] board, int path, String word, boolean[][] visit) {
        if (path == word.length()) {
            return true;
        }

        if (i<0||j<0||i==board.length || j==board[0].length|| visit[i][j] || board[i][j] !=  word.charAt(path)) {
            return false;
        }

        board[i][j] = '*';
        boolean ret = dfs(i, j+1, board, path+1, word, visit) || 
                      dfs(i+1, j, board, path+1, word, visit) || 
                      dfs(i-1, j, board, path+1, word, visit) || 
                      dfs(i, j-1, board, path+1, word, visit);
        if (ret) {
            return true;
        }
        visit[i][j] = false;
        return false;
    }
}
