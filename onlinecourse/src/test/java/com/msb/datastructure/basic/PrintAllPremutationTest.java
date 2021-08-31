package com.msb.datastructure.basic;

import static org.junit.Assert.assertArrayEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class PrintAllPremutationTest {
    private PrintAllPremutation target;

    @Before
    public void setup() {
        this.target = new PrintAllPremutation();
    }

    @Test
    public void testAllPremutation() {
        // arrange
        String test = "abc";
        String[] expecteds = new String[]{"abc", "acb", "bac", "bca", "cba", "cab"};

        // act
        List<String> ans = this.target.allPremutation(test);

        // assert
        assertArrayEquals(expecteds, ans.toArray());
    }

    @Test
    public void testAllPremutationWithDuplicated() {
        // arrange
        String test = "abbc";
        String[] expecteds = new String[]{"abbc", "abcb", "acbb", "babc", "bacb","bbac","bbca","bcba","bcab","cbba","cbab","cabb"};

        // act
        List<String> ans = this.target.allPremutation(test);

        // assert
        assertArrayEquals(expecteds, ans.toArray());
    }

    @Test
    public void testAllPremutationWithDuplicated2() {
        // arrange
        String test = "aaa";
        String[] expecteds = new String[]{"aaa"};

        // act
        List<String> ans = this.target.allPremutation(test);

        // assert
        assertArrayEquals(expecteds, ans.toArray());
    }
}
