package May.day07;

import CommonClass.TreeNode;

/**
 * ʱ�䣺2024/5/7
 * ����������
 * �����/���˼·��ʹ�ö�����������ʹ��ǰ�����������������������Ҷ�ӽڵ����˳��Ȼ��Ƚ��Ƿ�һ��
 * ���룺
 */
public class LeafSimilar {
    /**
     * ʱ�临�Ӷȣ�O��n��
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
