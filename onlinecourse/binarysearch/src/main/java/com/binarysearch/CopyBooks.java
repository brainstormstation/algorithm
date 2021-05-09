package com.binarysearch;

/**
 * Given n books and the i-th book has pages[i] pages. There are k persons to copy these books.
 * These books list in a row and each person can claim a continous range of books. 
 * For example, one copier can copy the books from i-th to j-th continously, but he can not copy the 1st book, 2nd book and 4th book (without 3rd book).
 * They start copying books at the same time and they all cost 1 minute to copy 1 page of a book. 
 * What's the best strategy to assign books so that the slowest copier can finish at earliest time?
 * Return the shortest time that the slowest copier spends.
 */
public class CopyBooks {
    /**
     * @param pages: an array of integers
     * @param k:     an integer
     * @return: an integer
     */
    public int copyBooks(int[] pages, int k) {
        if (pages == null || pages.length == 0) {
            return 0;
        }

        if (k == 0) {
            return -1;
        }

        int start = 0;
        int end  = getSum(pages);

        while (start + 1 < end) {
            int mid = start + ( end - start) / 2;
            if (getNumberOfCopiers(pages, mid) <= k) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (getNumberOfCopiers(pages, start) == k) {
            return start;
        }

        return end;
    }

    private int getSum(int[] pages) {
        int sum = 0;
        for (int i = 0; i < pages.length; i++) {
            sum += pages[i];
        }
        return sum;
    }

    private int getNumberOfCopiers(int[] pages, int limit) {
        int copiers = 0;
        int lastCopied = limit;

        for (int page : pages) {
            if (page > limit) {
                return Integer.MAX_VALUE;
            }
            if (lastCopied + page > limit) {
                copiers++;
                lastCopied = 0;
            }
            lastCopied += page;
        }
        return copiers;
    }
}
