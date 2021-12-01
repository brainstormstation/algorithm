package com.enterprise.facebook.leetcode;

public class Code50_Pow {
    public double myPow(double x, int n) {
        long ln = n;
        if (ln < 0) {
            x = 1/x;
            ln = -ln;
        }
        return fastPow(x, ln);
    }

    private double fastPow(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        double half = fastPow(x, n/2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
}
