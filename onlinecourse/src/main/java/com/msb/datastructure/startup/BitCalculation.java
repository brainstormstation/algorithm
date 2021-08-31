package com.msb.datastructure.startup;

public class BitCalculation {
    public int add(int a, int b) {
        int sum = a;
        while (b != 0) {
            sum = a ^ b; //无进位相加信息
            b = (a & b) << 1; // 进位信息
            a = sum; 
        }
        return sum;
    }

    public int minus(int a, int b) {
        // a - b => a +(-b) => a+ (~b+1)
        return add(a, negNum(b));
    }

    public int multi(int a, int b) {
        int res = 0;
        while (b != 0) {
            if ((b & 1) != 0) {
                res = add(a, res);
            }
            a <<= 1;
            b >>>= 1; // 不带符号右移
        }
        return res;
    }
    
    private boolean isNeg(int a) {
        return a < 0;
    }

    private int div(int a, int b) {
        int x = isNeg(a) ? negNum(a) : a;
        int y = isNeg(b) ? negNum(b) : b;
        int res = 0;
        for (int i=30; i>=0; i = minus(i, 1)) {
            if ((x >> i) >= y) {
                res |= (1 << i);
                x = minus(x, y << i);
            }
        }
        return isNeg(a) ^ isNeg(b) ? negNum(res) : res;

    }

    public int divide(int a, int b) {
        if (a == Integer.MIN_VALUE && b == Integer.MIN_VALUE) {
            return 1;
        } else if (b == Integer.MIN_VALUE) {
            return 0;
        } else if (a == Integer.MIN_VALUE) {
            if (b == negNum(1)) {
                return Integer.MAX_VALUE;
            } else {
                // a / b
                // (a+1) / b = c
                // a - (b * c) = d
                // d / b = e
                // c + e
                int c = div(add(a, 1), b);
                return add (c, div(minus(a, multi(c, b)), b));
            }
        } else {
            return div(a, b);
        }
    }
    public int negNum(int num) {
        return add(~num, 1);
    }
}
