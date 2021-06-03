package com.msb.basic.startup;

import com.util.UtilFunc;

public class BubbleSort {
    public void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        int len = arr.length;
        for (int i=len-1; i>=0; i--) {
            for (int j=1; j<= i; j++) {
                if (arr[j-1]>arr[j]) {
                    UtilFunc.swap(arr, j-1, j);
                }
            }
        }
    }    
}
