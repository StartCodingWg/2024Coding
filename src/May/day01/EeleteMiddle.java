package May.day01;

import java.util.List;

/**
 * Author:   wang
 * Date:     2024/5/4 16:00
 * function:
 * 给你一个链表的头节点 head 。删除 链表的 中间节点 ，并返回修改后的链表的头节点 head 。
 * <p>
 * 长度为 n 链表的中间节点是从头数起第 ?n / 2? 个节点（下标从 0 开始），其中 ?x? 表示小于或等于 x 的最大整数。
 * <p>
 * 对于 n = 1、2、3、4 和 5 的情况，中间节点的下标分别是 0、1、1、2 和 2 。
 * 解决思路：使用双指针
 */
public class EeleteMiddle {
    /**
     * 删除链表的中间节点
     *
     * @param head
     * @return
     */
    public ListNode deleteMiddle(ListNode head) {
        /* 特殊情况处理 */
        if (head == null || head.next == null) return null;
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode slow = sentinel;
        ListNode fast = sentinel;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
        return sentinel.next;
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
