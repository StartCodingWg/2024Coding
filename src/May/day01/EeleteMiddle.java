package May.day01;

import java.util.List;

/**
 * Author:   wang
 * Date:     2024/5/4 16:00
 * function:
 * ����һ�������ͷ�ڵ� head ��ɾ�� ����� �м�ڵ� ���������޸ĺ�������ͷ�ڵ� head ��
 * <p>
 * ����Ϊ n ������м�ڵ��Ǵ�ͷ����� ?n / 2? ���ڵ㣨�±�� 0 ��ʼ�������� ?x? ��ʾС�ڻ���� x �����������
 * <p>
 * ���� n = 1��2��3��4 �� 5 ��������м�ڵ���±�ֱ��� 0��1��1��2 �� 2 ��
 * ���˼·��ʹ��˫ָ��
 */
public class EeleteMiddle {
    /**
     * ɾ��������м�ڵ�
     *
     * @param head
     * @return
     */
    public ListNode deleteMiddle(ListNode head) {
        /* ����������� */
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
