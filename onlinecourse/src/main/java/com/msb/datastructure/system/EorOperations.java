package com.msb.datastructure.system;

public class EorOperations {
    
    /**
     * Swap two numbers in the array
     * @param a
     * @param i
     * @param j
     */
    public void swap(int[] a, int i, int j) {
        a[i] ^= a[j];
        a[j] ^= a[i];
        a[i] ^= a[j];
    }

    /**
     * Find the only odd number in the array
     * a^a = 0
     * a^b^c = a^c^b
     * @param a
     */
    public int findOnlyOddNumber(int[] a) {
        int result = 0;
        for (int i=0; i<a.length; i++) {
            result ^= a[i];
        }
        return result;
    }

    /**
     * Get the right 1,
     * ex: 10101000, should return 1000
     * @param a
     * @return
     */
    public int getTheRightOne(int a) {
        return a & (~a+1);
    }

    public int onlyKtimes(int[] arr, int k, int m) {
        int[] t = new int[32];
        for (int num: arr) {
            for (int i=0; i<32; i++) {
                t[i] += ((num >> i) & 1);
            }
        }
        int ans = 0;
        for (int i =0; i<32; i++) {
            if (t[i] % m !=0) {
                ans |= (1<< i);
            }
        }
        return ans;
    }
}
