package com.enterprise.facebook.lintcode;

import java.util.List;

/**
 * Description
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 * Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.
 * There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.
 */
public class Code616_CourseScheduleII {
    class ClassNode {
        int val;
        List<ClassNode> prerequists;
        public ClassNode(int val) {
            this.val = val;
        }

        public void add(int requists) {
            ClassNode re = new ClassNode(requists);
            prerequists.add(re);
        }
    }
    /*
     * @param numCourses: a total of n courses
     * @param prerequisites: a list of prerequisite pairs
     * @return: the course order
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // write your code here
        

    }
}
