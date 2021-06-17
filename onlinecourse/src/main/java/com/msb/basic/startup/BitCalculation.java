package com.msb.basic.startup;

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
    
    public int negNum(int num) {
        return add(~num, 1);
    }
}
