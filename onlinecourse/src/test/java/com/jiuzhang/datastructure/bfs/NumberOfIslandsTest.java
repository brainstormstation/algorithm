package com.lintcode.datastructure.bfs;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class NumberOfIslandsTest {

    private NumberOfIslands target;

    @Before
    public void setup() {
        this.target = new NumberOfIslands();
    }

    @Test
    public void testNumIslands() {
        boolean[][] map = new boolean[][] {{true, true, false, false, true}, 
                                            {false,true, true, false, true},
                                            {true, false,true, false, false},
                                            {true, true, false, false, false}};
                            
        int numbers = this.target.numIslands(map);
        assertEquals(3, numbers);
    }
    
}
