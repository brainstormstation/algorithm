package com.enterprise.facebook.lintcode;

import static org.junit.Assert.assertTrue;

import com.testutil.TestUtil;

import org.junit.Before;
import org.junit.Test;

public class Code477_SurroundedRegionsTest {
    private Code477_SurroundedRegions target;

    @Before
    public void setup() {
        this.target = new Code477_SurroundedRegions();
    }

    @Test
    public void testSurroundedRegions() {
        String[] inputStr = new String[] {"XXXX","XOOX","XXOX","XOXX"};
        char[][] input = TestUtil.ConvertFromStringToChar(inputStr);
        this.target.surroundedRegions(input);
        assertTrue(true);
    }
}