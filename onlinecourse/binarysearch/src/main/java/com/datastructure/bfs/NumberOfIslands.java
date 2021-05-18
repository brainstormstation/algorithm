package com.datastructure.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <b>Description</b>
 * <p>
 * Given a boolean 2D matrix, 0 is represented as the sea, 1 is represented as the island. If two 1 is adjacent, we consider them in the same island. We only consider up/down/left/right adjacent.
 * Find the number of islands.
 * <p>
 * https://www.lintcode.com/problem/433/?_from=ladder&fromId=161
 */
public class NumberOfIslands {
    int[] pathX = {0, -1, 1, 0};
    int[] pathY = {1, 0, 0, -1};
    class Coordinate {
        int x;
        int y;
        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    /**
     * @param grid: a boolean 2D matrix
     * @return: an integer
     */
    public int numIslands(boolean[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int count = 0;
        boolean[][] visit = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] && !visit[i][j]) {
                    bfs(grid, i, j, visit);
                    count++;
                }
            }
        }
        return count;
    }

    private void bfs(boolean[][] grid, int x, int y, boolean[][] visit) {
        Coordinate start = new Coordinate(x, y);
        Queue<Coordinate> queue = new LinkedList<>();
        queue.offer(start);
        visit[x][y] = true;
        while (!queue.isEmpty()) {
            Coordinate curr = queue.poll();
            for (int i = 0; i < 4; i++) {
                int newX = curr.x + pathX[i];
                int newY = curr.y + pathY[i];
                if (!isValid(grid, newX, newY, visit)) {
                    continue;
                }
                Coordinate next = new Coordinate(newX, newY);
                queue.offer(next);
                visit[newX][newY] = true;
            }
        }
    }

    private boolean isValid(boolean[][] grid, int x, int y, boolean[][] visit) {
        if (x < 0 || y < 0 || x == grid.length || y == grid[0].length) {
            return false;
        }

        if (visit[x][y]) {
            return false;
        }

        return grid[x][y];
    }
}
