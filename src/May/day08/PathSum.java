package May.day08;

import CommonClass.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 时间：2024/5/8
 * 问题描述：
 * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * 切入点/解决思路：利用树的前序遍历解决问题
 * 感想：
 */
public class PathSum {
    /**
     * 时间复杂度：最差O（n^2）,最好 O（n）
     * 空间复杂度：最差O（n），最好O（logn）
     * @param root
     * @param targetSum
     * @return
     */
    public int pathSum(TreeNode root, int targetSum) {
        return preOrderTravel(root, targetSum, new LinkedList<>());
    }

    private int preOrderTravel(TreeNode node, int targetSum, LinkedList<Long> deep) {
        /* 递归结束条件 */
        if (node == null) return 0;
        /* 递归体 */
        int cou = node.val == targetSum? 1 : 0;
        long sum = node.val;
        for (long temp : deep) {
            sum += temp;
            if (sum == targetSum) cou++;
        }
        deep.addFirst((long)node.val);
        cou += (preOrderTravel(node.left, targetSum, deep) + preOrderTravel(node.right, targetSum, deep));
        deep.removeFirst();
        return cou;
    }
}
