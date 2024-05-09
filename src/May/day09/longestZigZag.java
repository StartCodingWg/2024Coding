package May.day09;

import CommonClass.TreeNode;

/**
 * 时间：2024/5/9
 * 问题描述：
 * 切入点/解决思路：深度优先搜索
 * 感想：
 */
public class longestZigZag {
    private int res = 0;

    /**
     * 时间复杂度：O（n）
     * @param root
     * @return
     */
    public int longestZigZag(TreeNode root) {
        def(root);
        return res;
    }

    /**
     * 进行交错遍历
     * @param node
     */
    private int[] def(TreeNode node) {
        /* 递归结束条件 */
        if (node == null) return new int[]{0, 0};
        /* 递归体 */
        int[] tempRes = new int[]{def(node.left)[1] + 1, def(node.right)[0] + 1};
        res = Math.max(res, Math.max(tempRes[0], tempRes[1]) - 1);
        return tempRes;
    }
}
