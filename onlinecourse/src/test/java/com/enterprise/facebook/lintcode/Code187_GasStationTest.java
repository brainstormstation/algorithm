package com.enterprise.facebook.lintcode;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class Code187_GasStationTest {
    private Code187_GasStation target;

    @Before
    public void setup() {
        this.target = new Code187_GasStation();
    }

    @Test
    public void testCanCompleteCircuit() {
        int[] gas = {1, 2, 3, 3};
        int[] cost = {2, 1, 5, 1};
        int actual = this.target.canCompleteCircuit(gas, cost);
        int expected = 3;
        assertEquals(expected, actual);
    }
    
}
