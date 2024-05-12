package May.day12;

import CommonClass.TreeNode;
import sun.reflect.generics.tree.Tree;

/**
 * ʱ�䣺2024/5/12
 * ����������
 * ����һ�������������ĸ��ڵ� root ��һ��ֵ key��ɾ�������������е� key ��Ӧ�Ľڵ㣬����֤���������������ʲ��䡣���ض������������п��ܱ����£��ĸ��ڵ�����á�
 * һ����˵��ɾ���ڵ�ɷ�Ϊ�������裺
 * �����ҵ���Ҫɾ���Ľڵ㣻
 * ����ҵ��ˣ�ɾ������
 * �����/���˼·��
 * ���룺
 */
public class DeleteNode {
    public TreeNode deleteNode(TreeNode root, int key) {
        /* �ݹ�������� */
        if (root == null) return null;
        /* �ݹ��壨Ŀ���ҵ� target�� */
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
            return root;
        }
        if (key > root.val) {
            root.right = deleteNode(root.right, key);
            return root;
        }
        /* �ҵ�ָ���ڵ� */
        if (root.left != null) {
            /* ���Ƚ��ڵ����������һ���ڵ��滻Ϊ��ǰ�ڵ� */
            if (root.left.right == null) {
                root.val = root.left.val;
                root.left = root.left.left;
            } else {
                TreeNode pre = root.left;
                TreeNode next = root.left.right;
                while (next.right != null) {
                    pre = pre.right;
                    next = next.right;
                }
                root.val = next.val;
                pre.right = next.left;
            }
        } else if (root.right != null) {
            /* ����ȡ������ֵ��С�Ľڵ��滻����ǰ�ڵ��� */
            if (root.right.left == null) {
                root.val = root.right.val;
                root.right = root.right.right;
            } else {
                TreeNode pre = root.right;
                TreeNode next = root.right.left;
                while(next.left != null) {
                    pre = pre.left;
                    next = next.left;
                }
                root.val = next.val;
                pre.left = next.right;
            }
        } else {
            /* ����ֱ��ɾ����ǰ�ڵ� */
            return null;
        }
        return root;
    }
}
