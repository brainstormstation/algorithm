package com.jiuzhang.datastructure.bfs;

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
        Point source = new Point(2, 0);
        Point des = new Point(2, 2);
        int dis = this.target.shortestPath(map, source, des);
        assertEquals(2, dis);
    }
    
}
