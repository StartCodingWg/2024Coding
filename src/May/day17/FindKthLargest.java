package May.day17;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 时间：2024/5/17
 * 问题描述：
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * 切入点/解决思路：
 * 感想：
 */
public class FindKthLargest {
    /* 使用最大堆 */
    public int findKthLargest(int[] nums, int k) {
        /* 特殊情况处理 */
        if (nums == null || nums.length < k) return -1;
        /* 使用最小堆来保存最大的 k 个数 */
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
