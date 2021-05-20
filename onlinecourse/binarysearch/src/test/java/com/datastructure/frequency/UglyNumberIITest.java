package com.datastructure.frequency;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class UglyNumberIITest {

    private UglyNumberII target;

    @Before
    public void setup() {
        this.target = new UglyNumberII();
    }

    @Test
    public void testUglyNumber() {
        int n = 5;
        int num = this.target.nthUglyNumber(n);
        assertEquals(5, num);
    }
    
}
