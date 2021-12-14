package com.enterprise.facebook.lintcode;

public class Code187_GasStation {
    /**
     * @param gas: An array of integers
     * @param cost: An array of integers
     * @return: An integer
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // write your code here
        for (int i=0; i<gas.length; i++) {
            if (gas[i] < cost[i]) {
                continue;
            }

            boolean ret = check(gas, cost, i);
            if (ret) {
                return i;
            }
        }
        return -1;
    }

    private boolean check(int[] gas, int[] cost, int start) {
        int curGas = 0;
        int curCost = 0;
        for (int i=0; i<gas.length; i++) {
            int cur = start+i >= gas.length? (start+i-gas.length) : (start+i);
            curGas += gas[cur];
            curCost += cost[cur];
            if (curCost > curGas) {
                return false;
            }
        }
        return true;
    }
}
