package com.msb.datastructure.basic;

public class NQueen {
    /**
     * 提供一个n * n 的棋盘上，在每一行摆放一个皇后，可以有多少种方式。
     * @param n
     * @return 
     */
    public int solutions(int n) {
        if (n == 1) {
            return 1;
        }

        return process1(0, new int[n], n);
    }

    public int solutions2(int n) {
        if (n == 1) {
            return 1;
        }
        int limit = n == 32? -1: (1 << n)-1;
        return process2(limit, 0, 0, 0);
    }

    private int process1(int index, int[] record, int n) {
        if (index == n) {
            return 1;
        }
        int res = 0;
        for (int i=0; i<n; i++) {
            if (isValid(index, i, record)) {
                record[index] = i;
                res += process1(index+1, record, n);
            }
        }
        return res;
    }

    private boolean isValid(int row, int col, int[] record) {
        for (int i=0; i<row; i++) {
            if (record[i] == col || Math.abs(row - i) ==  Math.abs(record[i] - col)) {
                return false;
            }
        }
        return true;
    }

    private int process2(int limit, int collimit, int rightlimit, int leftlimit) {
        if (collimit == limit) {
            return 1;
        }

        int pos = limit & ( ~ (collimit | rightlimit | leftlimit));
        int rightPos = 0;
        int res = 0;
        while (pos != 0) {
            rightPos = pos & (~pos + 1);
            pos = pos - rightPos;

            res += process2(limit, collimit | rightPos, (rightlimit | rightPos ) >>> 1, (leftlimit | rightPos) << 1);
        }
        return res;
    }


}
