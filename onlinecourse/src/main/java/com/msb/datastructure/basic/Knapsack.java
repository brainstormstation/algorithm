package com.msb.datastructure.basic;

/**
 * w is weight, v is value, to with in the weight of the bag, how to get the max value of the product.
 */
public class Knapsack {
    public int getMaxValue(int[] w, int[] v, int bag) {
        return process1(w, v, 0, 0, bag);
    }

    public int getMaxValue2(int[] w, int[] v, int bag) {
        return process2(w, v, 0, bag);
    }

    public int getMaxValueInDp(int[] w, int[] v, int bag) {
        return dpWay2(w, v, bag);
    }

    private int process1(int[] w, int[] v, int index, int hasW, int bag) {
        if (hasW > bag) {
            return -1;
        }

        if (index == w.length) {
            return 0;
        }

        int p1 = process1(w, v, index+1, hasW, bag);
        int p2Next = process1(w, v, index+1, hasW+w[index], bag);
        int p2 = Integer.MIN_VALUE;
        if (p2Next != -1) {
            p2 = p2Next + v[index];
        }
        return Math.max(p1, p2);
    }

    private int process2(int[] w, int[] v, int index, int rest) {
        if (rest < 0) {
            return -1;
        }

        if (index == w.length) {
            return 0;
        }

        int p1 = process2(w, v, index+1, rest);

        int p2 = Integer.MIN_VALUE;
        int p2Next = process2(w, v, index+1, rest-w[index]);
        if (p2Next != -1) {
            p2 = p2Next + v[index];
        }
        return Math.max(p1, p2);
    }

    private int dpWay2(int[] w, int[] v, int bag) {
        int[][] dp = new int[w.length+1][bag+1];
        for (int i= w.length-1; i >=0; i--) {
            for(int j=0; j < bag+1; j++) {
                int p1 = dp[i+1][j];
                int p2 = -1;
                if (j-w[i] >=0 ) {
                    int p2Next = dp[i+1][j-w[i]];
                    p2 = p2Next + v[i];
                }
                dp[i][j] = Math.max(p1, p2);
            }
        }
        return dp[0][bag];
        
    }
}
