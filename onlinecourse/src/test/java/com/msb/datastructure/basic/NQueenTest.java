package com.msb.datastructure.basic;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class NQueenTest {
    public NQueen target;

    @Before
    public void setup() {
        this.target = new NQueen();
    }

    @Test
    public void testSolution() {
        // Arrange
        int n = 14;
        int expected = 365596;

        // Act
        long start = System.currentTimeMillis();
        System.out.println("Start at "+start);
        int actual = this.target.solutions(n);
        long end = System.currentTimeMillis();
        System.out.println("Completed at "+ end);
        // Assert
        assertEquals(expected, actual);
        System.out.println(end - start+"ms");

    }

    @Test
    public void testSolution2() {
        // Arrange
        int n = 14;
        int expected = 365596;

        // Act
        long start = System.currentTimeMillis();
        System.out.println("Start at "+start);
        int actual = this.target.solutions2(n);
        long end = System.currentTimeMillis();
        System.out.println("Completed at "+ end);
        // Assert
        assertEquals(expected, actual);
        System.out.println(end - start+"ms");

    }
}
