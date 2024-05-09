package May.day09;

import CommonClass.TreeNode;

/**
 * ʱ�䣺2024/5/9
 * ����������
 * �����/���˼·�������������
 * ���룺
 */
public class longestZigZag {
    private int res = 0;

    /**
     * ʱ�临�Ӷȣ�O��n��
     * @param root
     * @return
     */
    public int longestZigZag(TreeNode root) {
        def(root);
        return res;
    }

    /**
     * ���н������
     * @param node
     */
    private int[] def(TreeNode node) {
        /* �ݹ�������� */
        if (node == null) return new int[]{0, 0};
        /* �ݹ��� */
        int[] tempRes = new int[]{def(node.left)[1] + 1, def(node.right)[0] + 1};
        res = Math.max(res, Math.max(tempRes[0], tempRes[1]) - 1);
        return tempRes;
    }
}
