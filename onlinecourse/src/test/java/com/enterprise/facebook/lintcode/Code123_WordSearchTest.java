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

    @Test
    public void testMethod() {
        char[][] input= TestUtil.ConvertFromStringToChar(new String[]{"ABCE","SFCS","ADEE"});
        String word = "ABCCED";
        boolean actual = this.exist(input, word);
        boolean expected = true;
        assertEquals(expected, actual);
    }


    public boolean exist(char[][] board, String word) {
        // write your code here
        return dfs(board, 0, 0, word, 0, new boolean[board.length][board[0].length]);
    }

    private boolean dfs(char[][] board, int col, int row, String word, int index, boolean [][] visit) {
        if (index == word.length()) {
            return true;
        }
        if (col < 0 || col == board[0].length || row < 0 || row == board.length || visit[row][col]) {
            return false;
        }
        visit[row][col] = true;
        if (board[row][col]!=word.charAt(index)) {
            return dfs(board, col+1, row, word, index, visit) || dfs(board, col-1, row, word, index, visit)
            || dfs(board, col, row+1, word, index, visit) || dfs(board, col, row-1, word, index, visit);
        } 

        return dfs(board, col+1, row, word, index+1, visit) || dfs(board, col-1, row, word, index+1, visit)
        || dfs(board, col, row+1, word, index+1, visit) || dfs(board, col, row-1, word, index+1, visit);
    }

    
}
