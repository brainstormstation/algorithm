package com.msb.datastructure.basic;

/**
 * 一堆硬币组合成一个数值的方法有多少种
 */
public class CoinsWay {
    
    public int solution(int[] c, int aim) {

        if (c == null || c.length == 0) {
            return -1;
        }

        return process1(c, 0, aim);
    }

    public int solutionDp(int[] c, int aim) {
        return dpWay(c, aim);
    }

    public int process1(int[] c, int index, int rest) {
        if (index == c.length) {
            return rest == 0? 1: 0;
        }
        int way = 0;
        for (int nums=0; nums*c[index] <= rest; nums++) {
            way += process1(c, index+1, rest-nums*c[index]);
        }
        return way;
    }
    
    public int dpWay(int[] c, int aim) {
        int[][] dp = new int[c.length+1][aim+1];
        dp[c.length][0] = 1;

        for (int i=c.length-1; i>=0; i--) {
            for (int j = 0; j < (aim+1); j++) {
                dp[i][j] = dp[i+1][j];
                if (j - c[i] >=0) {
                    dp[i][j] += dp[i][j-c[i]];
                }
                /*
                for (int num = 0; num * c[i] <= j; num++) {
                    dp[i][j] += dp[i+1][j-num*c[i]];
                }*/
            }
        }
        return dp[0][aim];
    }
}
