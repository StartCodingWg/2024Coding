package May.day05;

/**
 * Author:   wang
 * Date:     2024/5/5 15:09
 * function:
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode tail = head;
        ListNode realHead = tail;
        while (tail.next!= null) {
            ListNode tem = tail.next;
            tail.next = tail.next.next;
            tem.next = realHead;
            realHead = tem;
        }
        return realHead;
    }

}