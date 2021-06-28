package com.msb.basic.startup;

public class MergeSort {

    public void mergeSort(int[] a) {
        if (a == null || a.length == 0) {
            return;
        }
        sort(a, 0, a.length-1);
    }

    private void sort(int[] a, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = left + ((right - left) >> 1);
        sort(a, left, mid);
        sort(a, mid+1, right);
        merge(a, left, mid, right);
    }

    public void mergeSort1(int[] a) {
        if (a == null || a.length ==0) {
            return;
        }
        int step = 1;
        int n = a.length;
        while (step < n) {
            int left = 0;
            while (left < n) {
                if (step >= n - left) {
                    break;
                }
                int mid = left + step -1;
                int right = mid + Math.min(step, n - mid -1);
                merge(a, left, mid, right);
                left = right + 1;
            }
            if (step > (n >> 1)) {
                break;
            }
            step <<= 1;
        }
    }

    private void merge(int[] arr, int left, int middle, int right) {
        int[] help = new int[right - left +1];
        int i = 0;
        int p1 = left;
        int p2 = middle+1;
        while (p1 <= middle && p2 <= right) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1<=middle){
            help[i++] = arr[p1++];
        }
        while(p2<=right) {
            help[i++] = arr[p2++];
        }
        for (int a = 0; a < i; a++) {
            arr[left+a] = help[a];
        }
    }

    
    
}
