package com.twopointers;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TwoSumIIITest {
    private TwoSumIII target;

    @Before
    public void setup() {
        this.target = new TwoSumIII();
    }

    @Test
    public void testFind() {
        this.target.add(2);
        this.target.add(4);
        this.target.add(6);
        assertTrue("The answer is incorrect", this.target.find(10));
    }
}
