package com.msb.basic.startup;

public class SelectSort {
    public void selectSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        int len = arr.length;

        for (int i=0; i<len; i++) {
            int minPos = i;
            for (int j = i+1; j<len; j++) {
                minPos = arr[j] < arr[minPos] ? j: minPos;
            }
            swap(arr, i, minPos);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    
}
