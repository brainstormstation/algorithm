package com.enterprise.facebook.lintcode;

import static org.junit.Assert.assertArrayEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class Code647_FindAllAnagramsInaStringTest {
    private Code647_FindAllAnagramsInaString target;

    @Before
    public void setup() {
        this.target = new Code647_FindAllAnagramsInaString();
    }

    @Test
    public void testFind() {
        String a = "ababa";
        String b = "ab";
        Integer[] expected = {0, 1, 2, 3};
        List<Integer> actual = this.target.findAnagrams(a, b);
        assertArrayEquals(expected, actual.toArray());
    }
}
