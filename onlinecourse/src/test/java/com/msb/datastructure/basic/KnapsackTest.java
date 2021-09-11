package com.msb.datastructure.basic;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class KnapsackTest {
    private Knapsack target;

    @Before
    public void setup() {
        this.target = new Knapsack();
    }

    @Test
    public void testGetMaxValueProcess1() {
        // arrange
        int[] w = new int[] {2, 4, 3, 10, 6};
        int[] v = new int[] {10, 5, 2, 9, 12};
        int bag = 15;
        int expected = 29;

        // act
        int actual = this.target.getMaxValue(w, v, bag);

        // assert 
        assertEquals(expected, actual);
         
    }

    @Test
    public void testGetMaxValueProcess2() {
        // arrange
        int[] w = new int[] {2, 4, 3, 10, 6};
        int[] v = new int[] {10, 5, 2, 9, 12};
        int bag = 15;
        int expected = 29;

        // act
        int actual = this.target.getMaxValue2(w, v, bag);

        // assert 
        assertEquals(expected, actual);
    }

    @Test
    public void testGetMaxValueDp() {
        // arrange
        int[] w = new int[] {2, 4, 3, 10, 6};
        int[] v = new int[] {10, 5, 2, 9, 12};
        int bag = 15;
        int expected = 29;

        // act
        int actual = this.target.getMaxValueInDp(w, v, bag);

        // assert 
        assertEquals(expected, actual);
    }
    
}
