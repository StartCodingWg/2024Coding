package May.day17;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * ʱ�䣺2024/5/17
 * ����������
 * ������������ nums ������ k���뷵�������е� k ������Ԫ�ء�
 * ��ע�⣬����Ҫ�ҵ������������ĵ� k ������Ԫ�أ������ǵ� k ����ͬ��Ԫ�ء�
 * �������Ʋ�ʵ��ʱ�临�Ӷ�Ϊ O(n) ���㷨��������⡣
 * �����/���˼·��
 * ���룺
 */
public class FindKthLargest {
    /* ʹ������ */
    public int findKthLargest(int[] nums, int k) {
        /* ����������� */
        if (nums == null || nums.length < k) return -1;
        /* ʹ����С������������ k ���� */
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k, (num1, num2) -> num1 - num2);
        for (int num : nums) {
            if (priorityQueue.size() < k) priorityQueue.offer(num);
            else if (priorityQueue.peek() < num) {
                priorityQueue.poll();
                priorityQueue.offer(num);
            }
        }
        return priorityQueue.peek();
    }
}
