package com.msb.basic.bitoperation;

public class PrintIntBinary {
    public String getBinaryStr(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i=31; i>=0; i--) {
            sb.append((num & (1<<i)) == 0 ? "0":"1");
        }
        return sb.toString();
     }
}
