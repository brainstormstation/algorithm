package com.datastructure.bfs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class Point {
    int x;
    int y;

    public Point() {
        this.x = 0;
        this.y = 0;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

/**
 * <b>Description</b>
 * <p>
 * Given a knight in a chessboard (a binary matrix with 0 as empty and 1 as barrier) with a source position, find the shortest path to a destination position, return the length of the route.
 * Return -1 if destination cannot be reached.
 * <p>
 * https://www.lintcode.com/problem/611/?_from=ladder&fromId=161
 */
public class KnightShortestPath {    

        private int[] pathX = new int[] {1, 1, -1, -1, 2, 2, -2, -2};
        private int[] pathY = new int[] {2, -2, 2, -2, 1, -1, 1, -1};
        /**
         * @param grid: a chessboard included 0 (false) and 1 (true)
         * @param source: a point
         * @param destination: a point
         * @return: the shortest path 
         */
        public int shortestPath(boolean[][] grid, Point source, Point destination) {
            // write your code here
            if ( grid == null || grid[0] == null || grid.length == 0 || grid[0].length == 0) {
                return -1;
            }

            Queue<Point> queue = new LinkedList<>();
            Map<Integer, Integer> distance = new HashMap<>();
            int m = grid[0].length;
            queue.offer(source);
            distance.put(source.x * m + source.y, 0);

            while (!queue.isEmpty()) {
                Point cur = queue.poll();
                if (cur.x == destination.x && cur.y == destination.y) {
                    return distance.get(cur.x * m + cur.y);
                }
                
                for (int i=0; i<8; i++) {
                    int newX = cur.x + pathX[i];
                    int newY = cur.y + pathY[i];
                    if (!isValid(newX, newY, grid) || distance.containsKey(newX * m + newY)) {
                        continue;
                    }

                    distance.put(newX * m + newY, distance.get(cur.x * m + cur.y) + 1);
                    queue.offer(new Point(newX, newY));
                }
            }
            return -1;
        }

        private boolean isValid(int x, int y, boolean[][] grid) {
            if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) {
                return false;
            }
            return !grid[x][y];
        }
    
}
