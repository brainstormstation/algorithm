package com.lintcode.datastructure.dfs;

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

        List<String> result = this.target.wordSearchII(board, words);
    }
    
}
