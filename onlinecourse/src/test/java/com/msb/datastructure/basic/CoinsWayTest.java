package com.msb.datastructure.basic;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CoinsWayTest {
    public CoinsWay target;

    @Before
    public void setup() {
        target = new CoinsWay();
    }

    @Test
    public void testSolution() {
        int[] coins = new int[] { 1, 5, 10, 50, 100};
        int aim = 200;
        int expected = 1014;
        int actual = this.target.solution(coins, aim);
        assertEquals(expected, actual);
    }

    @Test
    public void testSolutionDp() {
        int[] coins = new int[] { 1, 5, 10, 50, 100};
        int aim = 200;
        int expected = 1014;
        int actual = this.target.solutionDp(coins, aim);
        assertEquals(expected, actual);
    }
}
