package com.msb.datastructure.basic;

import java.util.ArrayList;
import java.util.List;

public class PrintAllSubsequence {

    public List<String> subs(String str) {
        if (str == null || str.length() == 0) {
            return new ArrayList<String>();
        }

        List<String> result = new ArrayList<>();
        process(str.toCharArray(), 0, result, "");
        return result;
    }

    public void process(char[] str, int index, List<String> ans, String path) {
        if (index == str.length) {
            ans.add(path);
            return;
        }
        String no = path;
        process(str, index+1, ans, no);
        String yes = path + String.valueOf(str[index]);
        process(str, index+1, ans, yes);
    }
}
