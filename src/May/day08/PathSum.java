package May.day08;

import CommonClass.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * ʱ�䣺2024/5/8
 * ����������
 * ����һ���������ĸ��ڵ� root ����һ������ targetSum ����ö�������ڵ�ֵ֮�͵��� targetSum �� ·�� ����Ŀ��
 * ·�� ����Ҫ�Ӹ��ڵ㿪ʼ��Ҳ����Ҫ��Ҷ�ӽڵ����������·��������������µģ�ֻ�ܴӸ��ڵ㵽�ӽڵ㣩��
 * �����/���˼·����������ǰ������������
 * ���룺
 */
public class PathSum {
    /**
     * ʱ�临�Ӷȣ����O��n^2��,��� O��n��
     * �ռ临�Ӷȣ����O��n�������O��logn��
     * @param root
     * @param targetSum
     * @return
     */
    public int pathSum(TreeNode root, int targetSum) {
        return preOrderTravel(root, targetSum, new LinkedList<>());
    }

    private int preOrderTravel(TreeNode node, int targetSum, LinkedList<Long> deep) {
        /* �ݹ�������� */
        if (node == null) return 0;
        /* �ݹ��� */
        int cou = node.val == targetSum? 1 : 0;
        long sum = node.val;
        for (long temp : deep) {
            sum += temp;
            if (sum == targetSum) cou++;
        }
        deep.addFirst((long)node.val);
        cou += (preOrderTravel(node.left, targetSum, deep) + preOrderTravel(node.right, targetSum, deep));
        deep.removeFirst();
        return cou;
    }
}
