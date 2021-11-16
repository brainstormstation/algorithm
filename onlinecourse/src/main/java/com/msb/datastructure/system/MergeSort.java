package com.msb.datastructure.system;

public class MergeSort {
    public void sort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        mergeSort(arr, 0, arr.length-1);
    }

    public void mergeSort(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = left + (right - left) >> 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid+1, right);
        merge(arr, left, mid, right);
    }

    public void mergeSort1(int[] arr) {
        int step = 1;
        int n = arr.length;
        while (step < n) {

            int left = 0;
            while (left < n) {
                if (step >= (n - left)) {
                    break;
                }
                int mid = left + step -1;
                int right = mid + Math.min(step, n - mid -1);
                merge(arr, left, mid, right);
                left = right +1;
            }
            if (step > n/2) {
                break;
            }
            step <<= 1;
        }
    }

    public void merge(int[] arr, int left, int mid, int right) {
        int[] helper = new int[right - left + 1];
        int p1 = left;
        int p2 = mid+1;
        int i = 0;
        while (p1 <= mid && p2 <= right) {
            helper[i++] = arr[p1] < arr[p2]?arr[p1++]:arr[p2++];
        }
        while (p1<=mid) {
            helper[i++] = arr[p1++];
        }
        while (p2<=right) {
            helper[i++] = arr[p2++];
        }
        for (int j = 0; j<helper.length; j++) {
            arr[left+j] = helper[j];
        }
    }
}
