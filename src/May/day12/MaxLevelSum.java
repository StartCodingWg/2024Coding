package May.day12;

import CommonClass.TreeNode;

import java.util.LinkedList;

/**
 * ʱ�䣺2024/5/12
 * ����������
 * ����һ���������ĸ��ڵ� root������ڵ�λ�ڶ������ĵ� 1 �㣬�����ڵ���ӽڵ�λ�ڵ� 2 �㣬�������ơ�
 * �뷵�ز���Ԫ��֮�� ��� ���Ǽ��㣨����ֻ��һ�㣩�Ĳ�ţ����������� ��С ���Ǹ���
 * �����/���˼·��ʹ�ò������
 * ���룺
 */
public class MaxLevelSum {
    public int maxLevelSum(TreeNode root) {
        /* ����������� */
        if (root == null) return 0;
        /* ʹ�ò������ */
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int maxSum = root.val;
        int level = 0;
        int resLevel = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int tem = 0;
            level++;
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.removeFirst();
                tem += treeNode.val;
                if (treeNode.left != null) queue.addLast(treeNode.left);
                if (treeNode.right != null) queue.addLast(treeNode.right);
            }
            if (tem > maxSum) {
                resLevel = level;
                maxSum = tem;
            }
        }
        return resLevel;
    }
}
