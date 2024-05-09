package May.day09;

import CommonClass.TreeNode;

/**
 * ʱ�䣺2024/5/9
 * ����������
 * ����һ���� root Ϊ���Ķ��������������еĽ���·���������£�
 * ѡ��������� ���� �ڵ��һ������������ң���
 * ���ǰ������Ϊ�ң���ô�ƶ�����ǰ�ڵ�ĵ����ӽڵ㣬�����ƶ����������ӽڵ㡣
 * �ı�ǰ����������һ����ұ���
 * �ظ��ڶ����͵�������ֱ�����������޷������ƶ���
 * ����·���ĳ��ȶ���Ϊ�����ʹ��Ľڵ���Ŀ - 1�������ڵ��·������Ϊ 0 ����
 * ���㷵�ظ�������� ����·�� �ĳ��ȡ�
 * �����/���˼·��ʹ�ú�������
 * ���룺
 */
public class LongestZigZag_fake {
    private int res = 0;

    public int longestZigZag(TreeNode root) {
        postOrder(root, 0);
        return res;
    }

    private void postOrder(TreeNode root, int num) {
        /* �ݹ�������� */
        if (root == null) return;
        /* �ݹ��� */
        if (root.left == null || root.right == null) {
            // ��ǰ�ڵ���������������һ��Ϊ�գ����ʾ���ν����ȵ��ﾡͷ
            if (root.left == null && root.right == null) {
                // �������������Ϊ�գ���ǰ�ڵ㲻������·����Χ�ڣ����ʹ��Ľڵ����� - 1��
                res = Math.max(res, num);
            } else {
                // �����������ֻ��һ��Ϊ�գ���ǰ�ڵ��������·����Χ��
                res = Math.max(res, num + 1);
            }
            num = 0;
        } else {
            // ��ǰ�ڵ�������������Ϊ�գ����ڵ�����һ��Ȼ����������������
            num++;
        }
        postOrder(root.left, num);
        postOrder(root.right, num);
    }
}
