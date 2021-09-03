package com.msb.datastructure.basic;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ConvertToLetterStringTest {
    private ConvertToLetterString target;

    @Before
    public void setup() {
        this.target = new ConvertToLetterString();
    }

    @Test
    public void testConvertToLetterString1() {
        // arrange
        String test = "123";
        int expect = 3;
        
        // act
        int ans = this.target.convertToLetterString(test);

        // assert
        assertEquals("The answer is incorrect.", expect, ans);
    }

}
