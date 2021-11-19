package com.msb.datastructure.system;

import com.common.entity.TreeNode;

public class BinaryTree_isBalance {
    class Info {
        public boolean isBalance;
        public int height;
        public Info(boolean isBalance, int height) {
            this.isBalance = isBalance;
            this.height = height;
        }
    }
    public boolean isBalance(TreeNode root) {
        Info info = balanceCheck(root);
        return info.isBalance;
    }

    private Info balanceCheck(TreeNode root) {
        if (root == null) {
            return new Info(true, 0);
        }
        Info left = balanceCheck(root.left);
        Info right = balanceCheck(root.right);
        
        if (!left.isBalance || !right.isBalance) {
            return new Info(false, 0);
        }
        if (Math.abs(left.height - right.height)>1) {
            return new Info(false, 0);
        }

        int height = Math.max(left.height, right.height)+1;
        return new Info(true, height);  

    }


    
}
