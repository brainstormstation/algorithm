package com.enterprise.facebook.lintcode;

public class Code408_AddBinary {
    public String addBinary(String a, String b) {
        int alen = a.length()-1;
        int blen = b.length()-1;
        int sum = 0;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (alen >=0 || blen >=0) {
            if (alen >=0) {
                sum+=a.charAt(alen--)-'0';
            }
            if (blen >=0) {
                sum+=b.charAt(blen--)-'0';
            }
            sum+=carry;
            carry = (sum/2);
            sb.append(sum%2);
        }
        if (carry != 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
