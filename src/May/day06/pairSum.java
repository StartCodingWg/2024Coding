package May.day06;

/**
 * 时间：2024/5/6
 * 问题描述：
 * 在一个大小为 n 且 n 为 偶数 的链表中，对于 0 <= i <= (n / 2) - 1 的 i ，第 i 个节点（下标从 0 开始）的孪生节点为第 (n-1-i) 个节点 。
 * 比方说，n = 4 那么节点 0 是节点 3 的孪生节点，节点 1 是节点 2 的孪生节点。这是长度为 n = 4 的链表中所有的孪生节点。
 * 孪生和 定义为一个节点和它孪生节点两者值之和。
 * 给你一个长度为偶数的链表的头节点 head ，请你返回链表的 最大孪生和 。
 * 切入点/解决思路：双指针保存每个数，然后二次计算（一次遍历）
 * 感想：
 */
public class pairSum {
    public int pairSum(ListNode head) {
        /* 特殊情况处理 */
        if (head == null || head.next == null) return 0;
        // 找到链表的长度
        int i = 0;
        ListNode tem = head;
        while (tem != null) {
            tem = tem.next;
            i++;
        }
        // 将数据记录在数组中
        int[] valArr = new int[i];
        tem = head;
        for (int j = 0; j < i; j++) {
            valArr[j] = tem.val;
            tem = tem.next;
        }
        // 找到最大的和
        int res = 0;
        for (int j = 0; j < i / 2; j++) {
            res = Math.max(res, valArr[j] + valArr[i - j - 1]);
        }
        return res;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
