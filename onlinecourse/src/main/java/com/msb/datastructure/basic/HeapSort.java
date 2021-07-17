package com.msb.datastructure.basic;

import com.util.UtilFunc;

public class HeapSort {
    
    public void sort(int[] arr) {
        if ( arr == null || arr.length < 2) {
            return;
        }

        for (int i=0; i < arr.length; i++) {
            heapInsert(arr, i);
        }

        int heapSize = arr.length;
        UtilFunc.swap(arr, 0, --heapSize);
        while (heapSize >0) {
            heapify(arr, 0, heapSize);
            UtilFunc.swap(arr, 0, --heapSize);
        }

    }

    private void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 +1;
        while (left < heapSize) {
            int larger = left + 1 < heapSize && arr[left] < arr[left+1] ? left+1: left;
            larger = arr[larger] > arr[index]? larger: index;
            if (larger == index) {
                break;
            }
            UtilFunc.swap(arr, larger, index);
            index = larger;
            left = index * 2 + 1;
        }
    }

    private void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index-1) / 2]) {
            UtilFunc.swap(arr, index, (index-1) / 2);
            index = (index-1) / 2;
        }
    }
    
}
