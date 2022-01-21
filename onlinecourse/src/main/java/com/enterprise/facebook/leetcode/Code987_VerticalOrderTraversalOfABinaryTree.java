package com.enterprise.facebook.leetcode;

import java.util.*;

import com.common.entity.TreeNode;

public class Code987_VerticalOrderTraversalOfABinaryTree {
    class Pair {
        TreeNode node;
        int col;
        int row;
        public Pair(TreeNode node, int col, int row) {
            this.node = node;
            this.col = col;
            this.row = row;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        int minIdx = 0, maxIdx = 0;
        Map<Integer, List<Pair>> map = new HashMap<>();
        Queue<Pair> queue = new LinkedList<>();
        Pair pRoot = new Pair(root, 0, 0);
        queue.offer(pRoot);
        int row = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                Pair pNode = queue.poll();
                int idx = pNode.col;
                TreeNode node = pNode.node;
                minIdx = Math.min(minIdx, idx);
                maxIdx = Math.max(maxIdx, idx);
                if (map.containsKey(idx)) {
                    map.get(idx).add(pNode);
                } else {
                    List<Pair> record = new ArrayList<>();
                    record.add(pNode);
                    map.put(idx, record);
                }

                if (node.left != null) {
                    queue.offer(new Pair(node.left, idx-1, row+1));
                }

                if (node.right != null) {
                    queue.offer(new Pair(node.right, idx+1, row+1));
                }
            }
            row++;            
        }

        for (int i=minIdx; i<=maxIdx; i++) {
            Collections.sort(map.get(i), (o1, o2) -> {
               if(o1.row == o2.row) {
                   return (o1.node.val - o2.node.val);
               } else {
                   return (o1.row - o2.row);
               }
            });
            List<Integer> list = new ArrayList<>();
            for (Pair p: map.get(i)) {
                list.add(p.node.val);
            }
            result.add(list);
        }
        return result;
    }
}
