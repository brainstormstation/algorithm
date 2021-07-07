package com.msb.datastructure.basic;

import java.util.TreeMap;

public class HashOperations {
    public void runTreeMap() {
        TreeMap<Integer, String> map = new TreeMap<>();
        
        
    }

    public static void main(String... args) {
        int lo = Integer.MAX_VALUE >> 1;
        int hi = Integer.MAX_VALUE;
        int mid = (lo + hi) >>> 1;
        System.out.println(hi);
        System.out.println(lo);
        System.out.println(mid);

        int mid2 = (lo + hi) >>1;
        System.out.println(hi);
        System.out.println(mid2);

        int mid3 = (lo + hi) / 2;
        System.out.println(hi);
        System.out.println(mid3);

    }
    
}
