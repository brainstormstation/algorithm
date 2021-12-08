package com.enterprise.facebook.lintcode;

import static org.junit.Assert.assertEquals;

import com.testutil.TestUtil;

import org.junit.Before;
import org.junit.Test;

public class Code123_WordSearchTest {
    private Code123_WordSearch target;

    @Before
    public void setup() {
        this.target = new Code123_WordSearch();
    }

    @Test
    public void testExists() {
        char[][] input = TestUtil.ConvertFromStringToChar(new String[]{"ab"});
        String word = "ba";
        boolean actual = this.target.exist(input, word);
        boolean expected = true;
        assertEquals(expected, actual);
    }

    
}
