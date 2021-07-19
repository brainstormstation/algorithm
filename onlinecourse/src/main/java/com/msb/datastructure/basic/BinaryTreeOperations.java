package com.msb.datastructure.basic;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.lintcode.common.entity.TreeNode;
import com.msb.basic.startup.IsBinarySearchTree;

public class BinaryTreeOperations {
    public void preOrder(TreeNode root) {
        System.out.println("Start pre order");
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                root = stack.pop();
                System.out.println(root.val);
                if (root.right != null) {
                    stack.push(root.left);
                }
                if (root.left != null) {
                    stack.push(root.right);
                }
            }
        }
    }

    public void levelOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
        
    }

    public int[] findMaxLevel(TreeNode node) {
        if (node == null) {
            return new int[]{0,0};
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        int curLevel = 0;
        int levelNode = 0;
        int maxLevelNode = Integer.MIN_VALUE;
        int maxLevel = 0;
        TreeNode curEnd = node;
        TreeNode nextEnd = new TreeNode(0);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.left != null) {
                nextEnd = cur.left;
                queue.offer(cur.left);                
            }
            if (cur.right != null) {
                nextEnd = cur.right;
                queue.offer(cur.right);
            }
            levelNode++;
            if (curEnd == cur) {
                curEnd = nextEnd;
                if (levelNode > maxLevelNode) {
                    maxLevelNode = levelNode;
                    maxLevel = curLevel;
                }

                levelNode = 0;
                curLevel++;                
            }
        }
        return new int[] {maxLevel, maxLevelNode};
    }
    
    public Queue<Integer> preSerial(TreeNode node) {
        Queue<Integer> res = new LinkedList<>();
        pres(res, node);
        return res;
    }

    public TreeNode buildFromPres(Queue<Integer> queue) {
        if (queue == null || queue.size() == 0) {
            return null;
        }
        TreeNode node = bPres(queue);
        return node;
    }

    private TreeNode bPres(Queue<Integer> queue) {
        Integer value  = queue.poll();
        if (value == null) {
            return null;
        }
        TreeNode node = new TreeNode(value);
        node.left = bPres(queue);
        node.right = bPres(queue);
        return node;
    }

    private void pres(Queue<Integer> queue, TreeNode node) {
        if (node == null) {
            queue.offer(null);
        } else {
            queue.offer(node.val);
            pres(queue, node.left);
            pres(queue, node.right);
        }

    }

    public Queue<Integer> levelSerial(TreeNode node) {
        Queue<Integer> res = new LinkedList<>();
        if (node == null) {
            res.offer(null);
        } else {
            res.add(node.val);
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(node);
            while (!queue.isEmpty()) {
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    res.add(cur.left.val);
                    queue.add(cur.left);
                } else {
                    res.add(null);
                }
                if (cur.right != null) {
                    res.add(cur.right.val);
                    queue.add(cur.right);
                } else {
                    res.add(null);
                }
            }
        }
        return res;
    }

    class TreeInfo {
        boolean isBalance;
        int height;
        public TreeInfo(boolean isBalance, int height) {
            this.isBalance = isBalance;
            this.height = height;
        }
    }
    public boolean isBalanceTree(TreeNode node) {
        if (node == null) {
            return true;
        }
        TreeInfo info = process(node);
        return info.isBalance;
    }

    private TreeInfo process(TreeNode node) {
        if (node == null) {
            return new TreeInfo(true, 0);
        }
        TreeInfo leftInfo = process(node.left);
        TreeInfo rightInfo = process(node.right);
        boolean isBalance = true;
        if (!leftInfo.isBalance || !rightInfo.isBalance || Math.abs(leftInfo.height - rightInfo.height) > 1) {
            isBalance = false;
        }
        
        int height = Math.max(leftInfo.height, rightInfo.height)+ 1;
        return new TreeInfo(isBalance, height);
    }

    class MaxDistanceInfo {
        int height;
        int maxDistance;
        public MaxDistanceInfo(int height, int maxDistance) {
            this.height = height;
            this.maxDistance = maxDistance;
        }
    }
    public int getMaxDistance(TreeNode node) {
        if (node == null) {
            return 0;
        }
        MaxDistanceInfo info = processMaxDistance(node);
        return info.maxDistance;
    }

    private MaxDistanceInfo processMaxDistance(TreeNode node) {
        if (node == null) {
            return new MaxDistanceInfo(0, 0);
        }
        MaxDistanceInfo leftInfo = processMaxDistance(node.left);
        MaxDistanceInfo rightInfo = processMaxDistance(node.right);

        int height = Math.max(leftInfo.height, rightInfo.height)+1;
        int maxDistance = Math.max(Math.max(leftInfo.maxDistance, rightInfo.maxDistance), leftInfo.height + rightInfo.height + 1);
        return new MaxDistanceInfo(height, maxDistance);

    }

    class FullBSTInfo {
        int nodes;
        int height;
        public FullBSTInfo(int nodes, int height) {
            this.nodes = nodes;
            this.height = height;
        }
    }

    public boolean isFullBST(TreeNode node) {
        if (node == null) {
            return true;
        }

        FullBSTInfo info = fullBSTProcess(node);

        return (1 << info.height) == info.nodes;
    }

    private FullBSTInfo fullBSTProcess(TreeNode node) {
        if (node == null) {
            return new FullBSTInfo(0, 0);
        }
        FullBSTInfo left = fullBSTProcess(node.left);
        FullBSTInfo right = fullBSTProcess(node.right);

        int height = Math.max(left.height, right.height)+1;
        int nodes = left.nodes + right.nodes +1;
        return new FullBSTInfo(nodes, height);
    }

    public boolean isCompleteBinaryTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leaf = false;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if ((node.left == null && node.right != null) || leaf && (node.left!= null || node.right != null)) {
                return false;
            }
            if (node.left == null || node.right == null) {
                leaf = true;
            }
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return true;
    }
}
