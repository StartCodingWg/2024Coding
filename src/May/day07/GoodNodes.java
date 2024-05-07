package May.day07;

import CommonClass.TreeNode;

/**
 * 时间：2024/5/7
 * 问题描述：
 * 给你一棵根为 root 的二叉树，请你返回二叉树中好节点的数目。
 * <p>
 * 「好节点」X 定义为：从根到该节点 X 所经过的节点中，没有任何节点的值大于 X 的值。
 * 切入点/解决思路：
 * 感想：
 */
public class GoodNodes {
    /**
     * 时间复杂度：O（n）
     * 空间复杂度：O（n）
     *
     * @param root
     * @return
     */
    public int goodNodes(TreeNode root) {
        return preOrder(root, root.val);
    }

    private int preOrder(TreeNode node, int maxValue) {
        int res = 0;
        /* 递归结束条件 */
        if (node == null) return res;
        /* 递归体 */
        if (node.val >= maxValue) {
            res++;
            maxValue = node.val;
        }
        res += preOrder(node.left, maxValue);
        res += preOrder(node.right, maxValue);
        return res;
    }
}
