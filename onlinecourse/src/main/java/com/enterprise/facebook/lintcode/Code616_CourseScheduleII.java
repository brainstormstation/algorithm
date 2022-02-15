package com.enterprise.facebook.lintcode;

import java.util.*;

/**
 * Description
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 * Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.
 * There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.
 */
public class Code616_CourseScheduleII {
    
    /*
     * @param numCourses: a total of n courses
     * @param prerequisites: a list of prerequisite pairs
     * @return: the course order
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // write your code here
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegrees = new int[numCourses];
        for (int[] prerequisite: prerequisites) {
            if (graph.containsKey(prerequisite[1])) {
                graph.get(prerequisite[1]).add(prerequisite[0]);
            } else {
                List<Integer> course = new ArrayList<>();
                course.add(prerequisite[0]);
                graph.put(prerequisite[1], course);
            }
            indegrees[prerequisite[0]]++;
        }

        Queue<Integer> zeroQueue = new LinkedList<>();
        for (int i=0; i<indegrees.length; i++) {
            if (indegrees[i] == 0) {
                zeroQueue.offer(i);
            }
        }
        int[] order = new int[numCourses];
        int index = 0;
        while (!zeroQueue.isEmpty()) {
            Integer courseNode = zeroQueue.poll();
            order[index++] = courseNode;
            if (graph.containsKey(courseNode)) {
                for (Integer prerequisite: graph.get(courseNode)) {
                indegrees[prerequisite]--;
                if (indegrees[prerequisite]==0) {
                    zeroQueue.offer(prerequisite);
                }
            }
            }            
        }
        if (index == numCourses) {
            return order;
        }
        return new int[0];

    }
}
