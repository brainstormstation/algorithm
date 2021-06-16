package com.msb.basic.startup;

public class BitMap {
    private long[] bits;

    public BitMap(int max) {
        // (max+64)/64
        bits = new long[(max+64) >> 6];
    }

    public void add(int num) {
        // num / 64 -> 哪一个整数
        // num % 64 -> num & 63 -> 整数在64位中的位置
        // 1L << XX 将num所在位置上标1
        // |= 将原有数组的位置标1
        bits[num >> 6] |= 1L << (num & 63);
    }

    public void delete(int num) {
        bits[num >> 6] &= ~(1L << (num & 63));
    }

    public boolean contains(int num) {
        return (bits[num >> 6] & (1L << (num & 63))) != 0;
    }
}
