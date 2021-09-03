package com.msb.datastructure.basic;

public class ConvertToLetterString {

    public int convertToLetterString(String str) {
        if (str == null || str.length() == 0 || str.equals("0")) {
            return 0;
        }

        if (str.length() < 2) {
            return 1;
        }

        return process1(0, str.toCharArray());
    }

    /**
     * 暴力递归的方式
     * @return
     */
    private int process1(int i, char[] arr) {
        if (i == arr.length) {
            return 1;
        }
        int res = 0;
        switch(arr[i]) {
            case '0': return 0;
            case '1':
                res = process1(i+1, arr);
                if (i+1 < arr.length) {
                    res += process1(i+2, arr);
                }
                return res;
            case '2':
                res = process1(i+1, arr);
                if (i+1 < arr.length && arr[i+1]>'0' && arr[i+1]<='6') {
                    res += process1(i+2, arr);
                }
                return res;
            default:
                return process1(i+1, arr);
        }
    }
    
}
