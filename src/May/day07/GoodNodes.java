package May.day07;

import CommonClass.TreeNode;

/**
 * ʱ�䣺2024/5/7
 * ����������
 * ����һ�ø�Ϊ root �Ķ����������㷵�ض������кýڵ����Ŀ��
 * <p>
 * ���ýڵ㡹X ����Ϊ���Ӹ����ýڵ� X �������Ľڵ��У�û���κνڵ��ֵ���� X ��ֵ��
 * �����/���˼·��
 * ���룺
 */
public class GoodNodes {
    /**
     * ʱ�临�Ӷȣ�O��n��
     * �ռ临�Ӷȣ�O��n��
     *
     * @param root
     * @return
     */
    public int goodNodes(TreeNode root) {
        return preOrder(root, root.val);
    }

    private int preOrder(TreeNode node, int maxValue) {
        int res = 0;
        /* �ݹ�������� */
        if (node == null) return res;
        /* �ݹ��� */
        if (node.val >= maxValue) {
            res++;
            maxValue = node.val;
        }
        res += preOrder(node.left, maxValue);
        res += preOrder(node.right, maxValue);
        return res;
    }
}
