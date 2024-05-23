package May.day22;

import java.util.Arrays;

/**
 * 时间：2024/5/22
 * 问题描述：
 * 珂珂喜欢吃香蕉。这里有 n 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 h 小时后回来。
 * 珂珂可以决定她吃香蕉的速度 k （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 k 根。
 * 如果这堆香蕉少于 k 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。
 * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
 * 返回她可以在 h 小时内吃掉所有香蕉的最小速度 k（k 为整数）。
 * 切入点/解决思路：
 * 感想：
 */
public class MinEatingSpeed {
    /**
     * oh my god
     * @param piles
     * @param h
     * @return
     */
    public int minEatingSpeed(int[] piles, int h) {
        /* 特殊情况处理 */
        if (piles == null || piles.length == 0 || piles.length > h) return 0;
        // 将香蕉堆进行排序
        Arrays.sort(piles);
        // 使用二分法，找到第一个使得消耗小时数 >= h 的 k（从 piles 中查找） - 时间复杂度：O(nlogn)
        int left = 0, right = piles.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (getCost(piles, piles[mid], mid) > h) left = mid + 1;
            else right = mid;
        }
        /* 使用二分法，从 [pre, post] 之间找到满足要求的 k */
        int pre = left == 0 ? 1 : piles[left - 1] + 1, post = piles[left];
        while (pre < post) {
            int mid = pre + (post - pre) / 2;
            if (getCost(piles, mid, left) > h) pre = mid + 1;
            else post = mid;
        }
        return pre;
    }

    private int getCost(int[] piles, int val, int beginIndex) {
        int res = beginIndex;
        for (int i = beginIndex; i < piles.length; i++) {
            res += (piles[i] % val == 0 ? piles[i] / val : (piles[i] / val) + 1);
        }
        return res;
    }
}
