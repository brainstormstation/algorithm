package com.msb.datastructure.basic;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TrieTreeTest {
    private TrieTree target;

    @Before
    public void setup() {
        this.target = new TrieTree();
    }

    @Test
    public void testInsert() {
        String word = "test";
        this.target.insert(word);
    }

    @Test
    public void testSearch() {
        String word1 = "test";
        String word2 = "welcome";
        String word3 = "week";
        this.target.insert(word1);
        this.target.insert(word2);
        this.target.insert(word3);
        this.target.insert(word1);
        int result = this.target.search("test");
        assertEquals(2, result);
    }

    @Test
    public void testPrefixNumber() {
        String word1 = "test";
        String word2 = "welcome";
        String word3 = "week";
        String word4 = "we";
        this.target.insert(word1);
        this.target.insert(word2);
        this.target.insert(word3);
        this.target.insert(word4);
        int result = this.target.prefixNumber("we");
        assertEquals(3, result);
    }

    @Test
    public void testDelete() {
        String word1 = "test";
        String word2 = "welcome";
        String word3 = "week";
        String word4 = "we";
        this.target.insert(word1);
        this.target.insert(word2);
        this.target.insert(word3);
        this.target.insert(word4);
        this.target.delete(word2);
        int result = this.target.search(word2);
        assertEquals(0, result);
    }
    
}
