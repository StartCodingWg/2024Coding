package May.day12;

import CommonClass.TreeNode;
import sun.reflect.generics.tree.Tree;

/**
 * 时间：2024/5/12
 * 问题描述：
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 * 一般来说，删除节点可分为两个步骤：
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 * 切入点/解决思路：
 * 感想：
 */
public class DeleteNode {
    public TreeNode deleteNode(TreeNode root, int key) {
        /* 递归结束条件 */
        if (root == null) return null;
        /* 递归体（目的找到 target） */
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
            return root;
        }
        if (key > root.val) {
            root.right = deleteNode(root.right, key);
            return root;
        }
        /* 找到指定节点 */
        if (root.left != null) {
            /* 优先将节点左子树最后一个节点替换为当前节点 */
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
            /* 否则取右子树值最小的节点替换到当前节点中 */
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
            /* 否则直接删除当前节点 */
            return null;
        }
        return root;
    }
}
