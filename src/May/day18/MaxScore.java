package May.day18;

import java.lang.management.MemoryType;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 时间：2024/5/18
 * 问题描述：
 * 给你两个下标从 0 开始的整数数组 nums1 和 nums2 ，两者长度都是 n ，再给你一个正整数 k 。你必须从 nums1 中选一个长度为 k 的 子序列 对应的下标。
 * 对于选择的下标 i0 ，i1 ，...， ik - 1 ，你的 分数 定义如下：
 * nums1 中下标对应元素求和，乘以 nums2 中下标对应元素的 最小值 。
 * 用公式表示： (nums1[i0] + nums1[i1] +...+ nums1[ik - 1]) * min(nums2[i0] , nums2[i1], ... ,nums2[ik - 1]) 。
 * 请你返回 最大 可能的分数。
 * 一个数组的 子序列 下标是集合 {0, 1, ..., n-1} 中删除若干元素得到的剩余集合，也可以不删除任何元素。
 * 切入点/解决思路：使用贪心算法
 * 感想：hard（不看题目归类，很难的啦）
 */
public class MaxScore {

    /**
     * @param nums1
     * @param nums2
     * @param k
     * @return
     */
    public long maxScore(int[] nums1, int[] nums2, int k) {
        /* 特殊情况处理 */
        if (nums1 == null || nums2 == null || nums2.length != nums1.length || k > nums1.length || k == 0) return 0;
        /* 使用优先级队列处理 */
        PriorityQueue<Integer> minMulti = new PriorityQueue<>(k);
        long sumTotal = 0;
        // 提前将 k 个有效的内容方优先级队列中
        Set<Integer> indexSet = new HashSet<>();
        int begin = 0;
        while (indexSet.size() < k && begin < nums1.length) {
            if (nums2[begin] != 0) {
                minMulti.offer(nums2[begin]);
                sumTotal += nums1[begin];
                indexSet.add(begin);
            }
            begin++;
        }
        if (begin == nums1.length) return indexSet.size() == k ? sumTotal * minMulti.peek() : 0;
        // 开始计算
        for (int i = begin; i < nums1.length; i++) {
            if (nums2[i] == 0) continue;
            int replaceIndex = -1;
            long maxTotalScore = 0;
            // 选出需要替换的元素
            for (Integer integer : indexSet) {
                long newTotalSocre = getNewTotalSocre(sumTotal, minMulti, nums1, nums2, integer, i);
                if (newTotalSocre > maxTotalScore) {
                    maxTotalScore = newTotalSocre;
                    replaceIndex = integer;
                }
            }
            /* 更新数据 */
            if (maxTotalScore > (sumTotal * minMulti.peek())) {
                sumTotal = sumTotal - nums1[replaceIndex] + nums1[i];
                minMulti.remove(nums2[replaceIndex]);
                minMulti.add(nums2[i]);
                indexSet.remove(replaceIndex);
                indexSet.add(i);
            }
        }
        return sumTotal * minMulti.peek();
    }

    private long getNewTotalSocre(long sumTotal, PriorityQueue<Integer> minMulti, int[] nums1, int[] nums2, int replaceIndex, int index) {
        // 不用计算，一定小于的情况
        if (nums1[index] <= nums1[replaceIndex] && nums2[index] <= nums2[replaceIndex]) return 0;
        // 计算新分数
        sumTotal = sumTotal - nums1[replaceIndex] + nums1[index];
        int newMulti = Math.min(minMulti.peek(), nums2[index]);
        // 如果待移除的元素会影响到最小乘数，且新增元素对应的乘数大于最小乘数
        if (nums2[index] > minMulti.peek()
                && minMulti.peek() == nums2[replaceIndex] ) {
            minMulti.poll();
            newMulti = minMulti.size() == 0 ? nums2[index] : Math.min(minMulti.peek(), nums2[index]);
            minMulti.offer(nums2[replaceIndex]);
        }
        return sumTotal * newMulti;
    }

    public static void main(String[] args) {
        int[] nums1 = {79,76,41,28,41,66,44,30,25};
        int[] nums2 = {25,0,69,67,55,0,9,77,26};
        int k = 7;
        MaxScore maxScore = new MaxScore();
        System.out.println(maxScore.maxScore(nums1, nums2, k));
    }
}