package May.day09;

import CommonClass.TreeNode;

/**
 * ʱ�䣺2024/5/9
 * ��������������һ��������, �ҵ�����������ָ���ڵ�������������
 * �����/���˼·��
 * ���룺
 */
public class LowestCommonAncestor {
    private TreeNode result;

    /**
     * ʹ�������������
     * ʱ�临�Ӷȣ�O(n)
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
