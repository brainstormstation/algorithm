package com.msb.datastructure.basic;

/**
 * 用一个数组表示给定的一堆牌，A和B只能从牌堆的最左侧或者最右侧拿一张牌，
 * 假设A，B都绝顶聪明，问最后赢的人的分数是多少。
 * @param arr
 * @return
 */
public class CardsInLine {
    public int win(int[] arr) {
        return Math.max(f(arr, 0, arr.length-1), s(arr, 0, arr.length-1));
    }

    private int f(int[] arr, int l, int r) {
        if (l == r) {
            return arr[l];
        }

        return Math.max(
            arr[l] + s(arr, l+1, r), 
            arr[r] + s(arr, l, r-1));
    }

    private int s(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }

        return Math.min(
            f(arr, l+1, r),
            f(arr, l, r-1));
    }
}
