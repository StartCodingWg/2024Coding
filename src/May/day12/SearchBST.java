package May.day12;

import CommonClass.TreeNode;

/**
 * 时间：2024/5/12
 * 问题描述：
 * 给定二叉搜索树（BST）的根节点 root 和一个整数值 val。
 * 你需要在 BST 中找到节点值等于 val 的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 null 。
 * 切入点/解决思路：直接进行深度优先搜索即可
 * 感想：
 */
public class SearchBST {
    /**
     * 时间复杂度：O（h） h-树的高度，最坏情况下是O(n)，n为节点数
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBST(TreeNode root, int val) {
        /* 递归结束条件 */
        if (root == null) return null;
        /* 递归体 */
        if (root.val == val) return root;
        if (root.val < val) return searchBST(root.right, val);
        else return searchBST(root.left, val);
    }

}
