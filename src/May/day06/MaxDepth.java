package May.day06;

import CommonClass.TreeNode;

/**
 * 时间：2024/5/6
 * 问题描述：二叉树的最大深度
 * 切入点/解决思路：使用递归解决
 * 感想：
 */
public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
    }

}
