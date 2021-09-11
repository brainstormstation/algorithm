package com.msb.datastructure.basic;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class RobotWalkTest {
    private RobotWalk target;

    @Before
    public void setup() {
        this.target = new RobotWalk();
    }

    @Test
    public void testWalkWay() {
        int n = 50;
        int p = 6;
        int m = 2;
        int k = 30;
        int expected = 65132550;
        long start = System.currentTimeMillis();
        int actual = this.target.walkWay(n, m, p, k);
        long end = System.currentTimeMillis();
        System.out.println("The execution time is "+(end - start)+"ms");
        assertEquals(expected, actual);
    }

    @Test
    public void testWalkWayWithCache() {
        int n = 7;
        int p = 5;
        int m = 2;
        int k = 5;
        int expected = 5;
        long start = System.currentTimeMillis();
        int actual = this.target.walkWayWithCache(n, m, p, k);
        long end = System.currentTimeMillis();
        System.out.println("The execution time is "+(end - start)+"ms");
        assertEquals(expected, actual);
    }

    @Test
    public void testWalkWayWithDp() {
        int n = 50;
        int p = 6;
        int m = 2;
        int k = 30;
        int expected = 65132550;
        long start = System.currentTimeMillis();
        int actual = this.target.walkWayWithDp(n, m, p, k);
        long end = System.currentTimeMillis();
        System.out.println("The execution time is "+(end - start)+"ms");
        assertEquals(expected, actual);
    }
}
