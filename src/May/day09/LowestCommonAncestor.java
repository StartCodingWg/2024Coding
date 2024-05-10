package May.day09;

import CommonClass.TreeNode;

/**
 * 时间：2024/5/9
 * 问题描述：给定一个二叉树, 找到该树中两个指定节点的最近公共祖先
 * 切入点/解决思路：
 * 感想：
 */
public class LowestCommonAncestor {
    private TreeNode result;

    /**
     * 使用深度优先搜索
     * 时间复杂度：O(n)
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root, p, q);
        return result;
    }

    public boolean helper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        boolean left = helper(root.left, p, q);
        boolean right = helper(root.right, p, q);
        if ((left && right) || (left || right) && (root == p || root == q)) {
            result = root;
            return false;
        }
        return left || right || (root == p || root == q);
    }
}
