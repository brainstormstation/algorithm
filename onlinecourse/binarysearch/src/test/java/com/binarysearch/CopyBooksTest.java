package com.binarysearch;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CopyBooksTest {
    private CopyBooks target;

    @Before
    public void setup() {
        this.target = new CopyBooks();
    }

    @Test
    public void testCopyBooks() {
        int[] pages = {3, 2, 4};
        int k = 2;
        int result = this.target.copyBooks(pages, k);
        assertEquals(5, result);
    }
}
