package com.msb.datastructure.basic;

/**
 * 在一个N格的数组中，机器人在M格，需要走到P格去，
 * 在限定的步数K下，有多少种方式可以走。
 * 在0位置只能往右，
 * 在N位置只能往左，
 * 在中间位置可以任意往左往右。
 */
public class RobotWalk {

    public int walkWay(int n, int m, int p, int k) {
        if (k == 0) {
            return m == p? 1 : 0;
        }

        if (m == 1) {
            return walkWay(n, m+1, p, k-1);
        }

        if (m == n-1) {
            return walkWay(n, m-1, p, k-1);
        }

        return walkWay(n, m-1, p, k-1) + walkWay(n, m+1, p, k-1);
    }

    public int walkWayWithCache(int n, int m, int p, int k) {
        int[][] cache = new int[n+1][k+1];
        for (int i = 0; i< n+1; i++) {
            for (int j = 0; j < k+1; j++) {
                cache[i][j] = -1;
            }
        }
        int result = process(n, m, p, k, cache);
        return result;
    }

    public int walkWayWithDp(int n, int m, int p,int k) {
        int[][] dp = new int[n+1][k+1];
        for (int i = 0; i< n+1; i++) {
            for (int j = 0; j < k+1; j++) {
                dp[i][j] = 0;
            }
        }
        dp[p][0] = 1;
        for (int i = 1; i<k+1; i++) {
            for (int j = 1; j<n+1; j++) {
                if (j==1) {
                    dp[j][i] = dp[j+1][i-1];
                }
                else if (j == n) {
                    dp[j][i] = dp[j-1][i-1];
                }
                else {
                    dp[j][i] = dp[j-1][i-1]+dp[j+1][i-1];
                }
            }
        }
        return dp[m][k];
    }

    private int process(int n, int m, int p, int k, int[][] cache) {
        if (cache[m][k] != -1) {
            return cache[m][k];
        }

        if (k == 0) {
            cache[m][k] = m == p? 1 : 0;
            return cache[m][k];
        }

        if (m == 1) {
            cache[m][k] = process(n, m+1, p, k-1, cache);
            return cache[m][k];
        }

        if (m == n-1) {
            cache[m][k] = process(n, m-1, p, k-1, cache);
            return cache[m][k];
        }

        cache[m][k] = process(n, m-1, p, k-1, cache) + process(n, m+1, p, k-1, cache);
        return cache[m][k];
    }
}
