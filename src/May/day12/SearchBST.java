package May.day12;

import CommonClass.TreeNode;

/**
 * ʱ�䣺2024/5/12
 * ����������
 * ����������������BST���ĸ��ڵ� root ��һ������ֵ val��
 * ����Ҫ�� BST ���ҵ��ڵ�ֵ���� val �Ľڵ㡣 �����Ըýڵ�Ϊ���������� ����ڵ㲻���ڣ��򷵻� null ��
 * �����/���˼·��ֱ�ӽ������������������
 * ���룺
 */
public class SearchBST {
    /**
     * ʱ�临�Ӷȣ�O��h�� h-���ĸ߶ȣ���������O(n)��nΪ�ڵ���
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBST(TreeNode root, int val) {
        /* �ݹ�������� */
        if (root == null) return null;
        /* �ݹ��� */
        if (root.val == val) return root;
        if (root.val < val) return searchBST(root.right, val);
        else return searchBST(root.left, val);
    }

}
