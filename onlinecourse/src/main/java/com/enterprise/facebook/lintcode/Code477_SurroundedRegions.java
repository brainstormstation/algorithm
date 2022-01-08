package com.enterprise.facebook.lintcode;

import java.util.*;

public class Code477_SurroundedRegions {
    int[] xPath = new int[]{0, 1, -1, 0};
    int[] yPath = new int[]{1, 0, 0, -1};
    class Cord {
        int x; 
        int y;
        public Cord(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public void surroundedRegions(char[][] board) {
        surroundedRegionsWithDFS(board);
    }
    
    public void surroundedRegionsWithDFS(char[][] board) {
        if (board == null || board.length ==0 || board[0].length == 0) {
            return ;
        }

        for (int i=0; i<board.length; i++) {
            for (int j = 0; j<board[0].length; j++) {
                if (!isBoarder(board, i, j)) {
                    continue;
                }

                if (board[i][j] == 'O') {
                    dfs(board, i, j);
                }
            }
        }

        for (int i=0; i<board.length; i++) {
            for ( int j=0; j<board[0].length; j++) {
                if (board[i][j] == '*') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private boolean isBoarder(char[][] board, int i, int j) {
        if (i==0 || j==0 || i == board.length-1 || j == board[0].length -1) {
            return false;
        }
        return true;
    }

    private void dfs(char[][] board, int i, int j) {
        if (i<0 || j<0 || i==board.length || j == board[0].length) {
            return;
        }

        if (board[i][j] != 'O') {
            return;
        }

        board[i][j] = '*';

        dfs(board, i+1, j);
        dfs(board, i, j+1);
        dfs(board, i-1, j);
        dfs(board, i, j-1);

    }


    /*
     * @param board: board a 2D board containing 'X' and 'O'
     * @return: nothing
     */
    public void surroundedRegionsWithBFS(char[][] board) {
        // write your code here
        if (board == null || board.length < 3 || board[0].length < 3) {
            return;
        }
        boolean[][] visit = new boolean[board.length][board[0].length];
        for (int i=1; i<board.length; i++) {
            for (int j=1; j<board[i].length; j++) {
                if (board[i][j] == 'O' && !visit[i][j]) {
                    bfs(i, j, board, visit);
                }
            }
        }
    }

    private void bfs(int i, int j, char[][] board, boolean[][] visit) {
        List<Cord> path = new ArrayList<>();
        Cord cor = new Cord(j, i);
        Queue<Cord> queue = new LinkedList<>();
        queue.offer(cor);
        boolean flag = true;
        while (!queue.isEmpty()) {
            Cord cur = queue.poll();
            path.add(cur);
            visit[cur.y][cur.x] = true;
            board[cur.y][cur.x] = 'X';
            for (int index=0; index<4; index++) {
                int nX = cur.x+xPath[index];
                int nY = cur.y+yPath[index];
                if (visit[nY][nX]) {
                    continue;
                }
                if (board[nY][nX] == 'X') {
                    continue;
                }
                if (nX==0 || nY==0 || nX==board[0].length-1 || nY == board.length-1) {
                    flag = false;
                    break;
                }
                Cord next = new Cord(nX, nY);
                queue.offer(next);
            }
        }

        if (!flag) {
            revertChange(path, board);
        }
    }

    private void revertChange(List<Cord> path, char[][] board) {
        for (Cord c : path) {
            board[c.y][c.x] = 'O';
        }
    }
}
