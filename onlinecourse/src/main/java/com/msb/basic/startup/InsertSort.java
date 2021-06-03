package com.msb.basic.startup;

import com.util.UtilFunc;

public class InsertSort {
    public void insertSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        int len = arr.length;
        for (int i = 1; i < len; i++) {
            int insertPos = i;
            while (insertPos-1>=0 && arr[insertPos-1]>arr[insertPos]) {
                UtilFunc.swap(arr, insertPos-1, insertPos);
                insertPos--;
            }
        }
    }

    public void insertSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        int len = arr.length;
        for (int i = 1; i < len; i++) {
            for (int pre = i-1; pre>=0 && arr[pre]>arr[pre+1];pre--) {
                UtilFunc.swap(arr, pre+1, pre);
            }
        }
    }
}
