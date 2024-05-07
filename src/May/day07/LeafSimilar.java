package May.day07;

import CommonClass.TreeNode;

/**
 * 时间：2024/5/7
 * 问题描述：
 * 切入点/解决思路：使用对两个二叉树使用前序遍历，保留两个二叉树的叶子节点遍历顺序，然后比较是否一致
 * 感想：
 */
public class LeafSimilar {
    /**
     * 时间复杂度：O（n）
     * @param root1
     * @param root2
     * @return
     */
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        preOrder(root1, sb1);
        preOrder(root2, sb2);
        return sb1.toString().equals(sb2.toString());
    }

    private void preOrder(TreeNode node, StringBuilder sb) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            sb.append(node.val + ',');
            return;
        }
        preOrder(node.left, sb);
        preOrder(node.right, sb);
    }

}
