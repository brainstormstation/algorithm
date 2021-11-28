package com.enterprise.facebook;

import java.util.*;
import java.util.Map.Entry;

public class Code1570_DotProductOfTwoSparseVectors {
    public class SparseVector
    {
        HashMap<Integer, Integer> map; 
        SparseVector(int[] nums) {
            map = new HashMap<>();
            for (int i=0; i<nums.length; i++) {
                if (nums[i]!=0) {
                    map.put(i, nums[i]);
                }
            }
        }
        
        // Return the dotProduct of two sparse vectors
        public int dotProduct(SparseVector vec) {
            int res = 0;
            for (Entry e : vec.map.entrySet()) {
                if (map.containsKey(e.getKey())) {
                    res += map.get(e.getKey()) * (int)e.getValue();
                }
            }
            return res;
        }
    }
    
}
