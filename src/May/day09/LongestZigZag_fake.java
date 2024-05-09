package May.day09;

import CommonClass.TreeNode;

/**
 * 时间：2024/5/9
 * 问题描述：
 * 给你一棵以 root 为根的二叉树，二叉树中的交错路径定义如下：
 * 选择二叉树中 任意 节点和一个方向（左或者右）。
 * 如果前进方向为右，那么移动到当前节点的的右子节点，否则移动到它的左子节点。
 * 改变前进方向：左变右或者右变左。
 * 重复第二步和第三步，直到你在树中无法继续移动。
 * 交错路径的长度定义为：访问过的节点数目 - 1（单个节点的路径长度为 0 ）。
 * 请你返回给定树中最长 交错路径 的长度。
 * 切入点/解决思路：使用后续遍历
 * 感想：
 */
public class LongestZigZag_fake {
    private int res = 0;

    public int longestZigZag(TreeNode root) {
        postOrder(root, 0);
        return res;
    }

    private void postOrder(TreeNode root, int num) {
        /* 递归结束条件 */
        if (root == null) return;
        /* 递归体 */
        if (root.left == null || root.right == null) {
            // 当前节点左右子树至少有一个为空，则表示本次交错长度到达尽头
            if (root.left == null && root.right == null) {
                // 如果左右子树均为空，则当前节点不能算在路径范围内（访问过的节点数量 - 1）
                res = Math.max(res, num);
            } else {
                // 如果左右子树只有一个为空，则当前节点可以算在路径范围内
                res = Math.max(res, num + 1);
            }
            num = 0;
        } else {
            // 当前节点左右子树都不为空，将节点数加一，然后继续深度优先搜索
            num++;
        }
        postOrder(root.left, num);
        postOrder(root.right, num);
    }
}
