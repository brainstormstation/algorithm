package com.leetcode.datastructure;

/**
 * https://leetcode.com/problems/koko-eating-bananas/
 * Description
 * Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.
 * Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
 * Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
 * Return the minimum integer k such that she can eat all the bananas within h hours.
 */
public class Code875_KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int start = 1, end = 1;
        for (int pile: piles) {
            end = Math.max(pile, end);
        }

        while (start < end) {
            int mid = start+(end-start)/2;
            int hour = 0;
            for (int pile: piles) {
                hour+=Math.ceil((double)pile/mid);
            }
            if (hour<=h) {
                end = mid;
            } else {
                start = mid+1;
            }
        }
        return end;
    }
}
