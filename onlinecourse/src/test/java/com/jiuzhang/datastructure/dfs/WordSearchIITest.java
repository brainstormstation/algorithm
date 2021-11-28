package com.jiuzhang.datastructure.dfs;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class WordSearchIITest {

    private WordSearchII target;

    @Before
    public void setup() {
        this.target = new WordSearchII();
    }

    @Test
    public void testWordSearchII() {
        char[][] board = {
            {'d','o','a','f'},
            {'a','g','a','i'},
            {'d','c','a','n'}};
        
        List<String> words = new ArrayList<>();
        words.add("dog");
        words.add("dad");
        words.add("dgdg");
        words.add("can");
        words.add("again");

        this.target.wordSearchII(board, words);
        assertTrue(true);

    }
    
}
