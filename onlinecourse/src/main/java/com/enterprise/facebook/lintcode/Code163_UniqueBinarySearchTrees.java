package com.enterprise.facebook.lintcode;

public class Code163_UniqueBinarySearchTrees {
    /**
     * @param n: An integer
     * @return: An integer
     */
    public int numTrees(int n) {
        // write your code here
        long a = 1;
        long b = a;
        for (int i=1; i<=n; i++) {
            b = a * (4*i-2)/(i+1);
            a = b;
        }
        return (int)a;
    }

    private int getSub(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n < 2) {
            return 1;
        }
        int left = 0, right = 0;
        for (int i=1; i<=n; i++) {
            left += getSub(i);
            right += getSub(n-i);
        }
        return left * right;
    }
}
