package com.msb.datastructure.basic;

import java.util.ArrayList;
import java.util.List;

public class PrintAllPremutation {
    
    public List<String> allPremutation(String str) {
        if (str == null || str.length()==0) {
            return new ArrayList<>();
        }
        List<String> ans = new ArrayList<>();
        process(0, str.toCharArray(), ans);
        return ans;
        
    }

    private List<String> process(int index, char[] str, List<String> ans) {
        if (index == str.length) {
            ans.add(String.valueOf(str));
        }
        boolean[] visit = new boolean[26];
        for (int i = index; i<str.length; i++) {
            if (!visit[str[i]-'a']) {
                visit[str[i]-'a'] = true;
                swap(str, index, i);
                process(index+1, str, ans);
                swap(str, i, index);
            }
        }
        return ans;
    }

    private void swap(char[] str, int i, int j) {
        char tmp = str[i];
        str[i] = str[j];
        str[j] = tmp;
    }
}
