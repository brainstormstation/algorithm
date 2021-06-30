package com.testutil;
public class TestUtil {
    public static void printArr(int[] arr) {
        for (int i: arr) {
            System.out.print(i);
            System.out.print(" ");
        }
    }

    public static int[] generateRandomArray(int size, int maxValue) {
        int[] arr = new int[(int)((size+1) * Math.random())];
        for (int i=0; i<arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int)(maxValue * Math.random());
        }
        return arr;
    }
}
