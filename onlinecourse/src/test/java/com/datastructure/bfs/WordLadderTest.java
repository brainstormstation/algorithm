package com.datastructure.bfs;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;

import com.datastructure.bfs.WordLadder;

import org.junit.Before;
import org.junit.Test;

public class WordLadderTest {
    private WordLadder target;

    @Before
    public void setup() {
        this.target = new WordLadder();
    }

    @Test
    public void testWordLadder() {
        String start = "hit";
        String end = "cog";
        HashSet<String> dict = new HashSet<String>();
        dict.add("hot");
        dict.add("dot");
        dict.add("dog");
        dict.add("lot");
        dict.add("log");
        int len = this.target.ladderLength(start, end, dict);
        assertEquals(5, len);
    }
}
