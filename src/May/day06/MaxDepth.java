package May.day06;

import CommonClass.TreeNode;

/**
 * ʱ�䣺2024/5/6
 * ������������������������
 * �����/���˼·��ʹ�õݹ���
 * ���룺
 */
public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
    }

}
