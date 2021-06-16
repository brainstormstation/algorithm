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
    
    public int negNum(int num) {
        return add(~num, 1);
    }
}
