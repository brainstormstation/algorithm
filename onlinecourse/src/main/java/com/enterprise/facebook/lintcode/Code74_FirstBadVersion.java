package com.enterprise.facebook.lintcode;

import com.util.UtilFunc;

/**
 * https://www.lintcode.com/problem/74
 * Description
 * The code base version is an integer start from 1 to n. 
 * One day, someone committed a bad version in the code case, so it caused this version and the following versions are all failed in the unit tests. 
 * Find the first bad version.
 * You can call isBadVersion to help you determine which version is the first bad one. The details interface can be found in the code's annotation part.
 */
public class Code74_FirstBadVersion {
    
/**
 * public class SVNRepo {
 *     public static boolean isBadVersion(int k);
 * }
 * you can use SVNRepo.isBadVersion(k) to judge whether 
 * the kth code version is bad or not.
*/
    /**
     * @param n: An integer
     * @return: An integer which is the first bad version.
     */
    public int findFirstBadVersion(int n) {
        // write your code here
        if (n == 1) {
            return n;
        }
        int start = 0;
        int end = n;
        while(start+1<end) {
            int mid = start+(end-start)/2;
            if (SVNRepo.isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }

        return SVNRepo.isBadVersion(start)? start:end;
    }
}
