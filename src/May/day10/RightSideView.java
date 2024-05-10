package May.day10;

import CommonClass.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 时间：2024/5/10
 * 问题描述：
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * 切入点/解决思路：层序遍历
 * 感想：
 */
public class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        /* 特殊情况处理 */
        if (root == null) {
            return res;
        }
        /* 层序遍历 */
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
