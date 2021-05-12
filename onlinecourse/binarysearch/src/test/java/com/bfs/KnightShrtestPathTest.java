package com.bfs;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class KnightShrtestPathTest {

    private KnightShortestPath target;

    @Before
    public void setup() {
        this.target = new KnightShortestPath();
    }

    @Test
    public void testShortestPath() {
        boolean[][] map = new boolean[][] {{false, false, false}, {false, false, false}, {false, false, false}};
        com.bfs.Point source = new com.bfs.Point(2, 0);
        com.bfs.Point des = new com.bfs.Point(2, 2);
        int dis = this.target.shortestPath(map, source, des);
        assertEquals(2, dis);
    }
    
}
