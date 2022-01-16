package com.enterprise.facebook.lintcode;

/**
 * Description
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), 
 * design an algorithm to find the maximum profit.
 */
public class Code149_BestTimeToBuyAndSellStock {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here
        int maxProfile = 0;
        int lowPoint = -1;
        for (int p : prices) {
            if (lowPoint == -1) {
                lowPoint = p;
                continue;
            }
            int profit = p - lowPoint;
            maxProfile = Math.max(maxProfile, profit);
            lowPoint = Math.min(lowPoint, p);
        }
        return maxProfile;
    }
}
