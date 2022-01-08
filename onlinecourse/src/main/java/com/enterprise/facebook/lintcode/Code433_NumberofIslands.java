package com.enterprise.facebook.lintcode;

public class Code433_NumberofIslands {
    /**
     * @param grid: a boolean 2D matrix
     * @return: an integer
     */
    public int numIslands(boolean[][] grid) {
        // write your code here
        if (grid == null || grid.length ==0) {
            return 0;
        }
        int count = 0;
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j]) {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(boolean[][] grid, int i, int j) {
        if (i<0 || j<0 || i==grid.length || j==grid[0].length) {
            return;
        }
        if (!grid[i][j]) {
            return;
        }
        grid[i][j] = false;
        dfs(grid, i-1, j);
        dfs(grid, i+1, j);
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);
    }
}
