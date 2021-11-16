package com.msb.datastructure.system;

public class SmallSum {
    public int getSmallSum(int[] arr) {
        int ans = process(arr, 0, arr.length-1);
        return ans;
    }

    private int process(int[] arr, int left, int right) {
        if (left == right) {
            return 0;
        }

        int mid = left + ((right - left) >> 1);
        return process(arr, left, mid) + process(arr, mid+1, right) + merge(arr, left, mid, right);

    }

    private int merge(int[] arr, int left, int mid, int right) {
        int[] helper = new int[right -left +1];
        int p1 = left;
        int p2 = mid+1;
        int index = 0;
        int ans = 0;
        while (p1 <= mid && p2 <= right) {
            ans += arr[p1] < arr[p2]? (right - p2 +1) * arr[p1]:0;
            helper[index++] = arr[p1] < arr[p2]? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            helper[index++] = arr[p1++];
        }
        while (p2 <= right) {
            helper[index++] = arr[p2++];
        }
        for (int i=0; i<helper.length; i++) {
            arr[left+i] = helper[i];
        }
        return ans;
    }
    
}
