package May.day10;

import CommonClass.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * ʱ�䣺2024/5/10
 * ����������
 * ����һ���������� ���ڵ� root�������Լ�վ�������Ҳ࣬���մӶ������ײ���˳�򣬷��ش��Ҳ����ܿ����Ľڵ�ֵ��
 * �����/���˼·���������
 * ���룺
 */
public class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        /* ����������� */
        if (root == null) {
            return res;
        }
        /* ������� */
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode treeNode = null;
            for (int i = 0; i < size; i++) {
                treeNode = queue.removeFirst();
                if (treeNode.left!= null) queue.addLast(treeNode.left);
                if (treeNode.right!= null) queue.addLast(treeNode.right);
            }
            res.add(treeNode.val);
        }
        return res;
    }
}
