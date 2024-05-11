package May.day12;

import CommonClass.TreeNode;

import java.util.LinkedList;

/**
 * 时间：2024/5/12
 * 问题描述：
 * 给你一个二叉树的根节点 root。设根节点位于二叉树的第 1 层，而根节点的子节点位于第 2 层，依此类推。
 * 请返回层内元素之和 最大 的那几层（可能只有一层）的层号，并返回其中 最小 的那个。
 * 切入点/解决思路：使用层序遍历
 * 感想：
 */
public class MaxLevelSum {
    public int maxLevelSum(TreeNode root) {
        /* 特殊情况处理 */
        if (root == null) return 0;
        /* 使用层序遍历 */
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int maxSum = root.val;
        int level = 0;
        int resLevel = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int tem = 0;
            level++;
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.removeFirst();
                tem += treeNode.val;
                if (treeNode.left != null) queue.addLast(treeNode.left);
                if (treeNode.right != null) queue.addLast(treeNode.right);
            }
            if (tem > maxSum) {
                resLevel = level;
                maxSum = tem;
            }
        }
        return resLevel;
    }
}
