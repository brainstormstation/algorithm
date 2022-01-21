package com.leetcode.datastructure;

/**
 * https://leetcode.com/problems/gas-station/
 * Description
 * There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station to its next (i + 1)th station. You begin the journey with an empty tank at one of the gas stations.
 * Given two integer arrays gas and cost, return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1. If there exists a solution, it is guaranteed to be unique
 */
public class Code134_GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalTank = 0;
        int curTank = 0;
        int start = 0;
        for (int i=0; i<gas.length; i++) {
            curTank += gas[i] - cost[i];
            totalTank += gas[i] - cost[i];
            if (curTank < 0) {
                start = i+1;
                curTank = 0;
            }
        }
        if (totalTank >=0) {
            return start;
        }
        return -1;
    }
}
