package com.lintcode.datastructure.dp;

/**
 * <b>Description</b>
 * <p>
 * Given a knight in a chessboard n * m (a binary matrix with 0 as empty and 1 as barrier). 
 * the knight initialze position is (0, 0) and he wants to reach position (n - 1, m - 1), Knight can only be from left to right. 
 * Find the shortest path to the destination position, 
 * return the length of the route. Return -1 if knight can not reached.
 * <p>
 * https://www.lintcode.com/problem/630/?_from=collection&fromId=161
 */
public class KnightShortestPathII {
    /**
     * @param grid: a chessboard included 0 and 1
     * @return: the shortest path
     */
    public int shortestPath2(boolean[][] grid) {
        // write your code here
        int n = grid.length;
        if (n==0) {
            return -1;
        }
        int m = grid[0].length;
        if (m == 0) {
            return -1;
        }

        int[][] f = new int[n][m];
        for (int i=0; i<n; ++i) {
            for (int j = 0; j<m; ++j) {
                f[i][j] = Integer.MAX_VALUE;
            }
        }

        f[0][0] = 0;
        for (int j=1; j<m; ++j) {
            for (int i=0; i<n; ++i) {
                if (!grid[i][j]) {
                    if (i>=1 && j >=2 && f[i-1][j-2] != Integer.MAX_VALUE) {
                        f[i][j] = Math.min(f[i][j], f[i-1][j-2]+1);
                    }
                    if (i+1<n && j>=2 && f[i+1][j-2] != Integer.MAX_VALUE) {
                        f[i][j] = Math.min(f[i][j], f[i+1][j-2]+1);
                    }
                    if (i>=2 && j>=1 && f[i-2][j-1] != Integer.MAX_VALUE) {
                        f[i][j] = Math.min(f[i][j], f[i-2][j-1]+1);
                    }
                    if (i+2<n && j>=1 && f[i+2][j-1] != Integer.MAX_VALUE) {
                        f[i][j] = Math.min(f[i][j], f[i+2][j-1]+1);
                    }
                }
            }
        }
        if (f[n-1][m-1]== Integer.MAX_VALUE) {
            return -1;
        }
        return f[n-1][m-1];
    }
}
