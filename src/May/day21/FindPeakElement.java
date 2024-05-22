package May.day21;

/**
 * 时间：2024/5/21
 * 问题描述：
 * 峰值元素是指其值严格大于左右相邻值的元素。
 * 给你一个整数数组 nums，找到峰值元素并返回其索引。数 组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 * 你可以假设 nums[-1] = nums[n] = -∞ 。
 * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
 * 切入点/解决思路：
 * 感想：
 */
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        /* 特殊情况处理 */
        if (nums == null || nums.length < 2) return 0;
        /* 使用暴力法 */
        for (int i = 0; i < nums.length; i++) {
            boolean isOk = true;
            if (i > 0 && nums[i] < nums[i - 1]) isOk = false;
            if (i < nums.length - 1 && nums[i] < nums[i + 1]) isOk = false;
            if (isOk) return i;
        }
        return -1;
    }

    /**
     * /\ 即可
     * @param nums
     * @return
     */
    public int findPeakElement2(int[] nums) {
        /* 特殊情况处理 */
        if (nums == null || nums.length < 2) return 0;
        /* 使用二分法 */
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int midIndex = left + (right - left) / 2;
            if (midIndex == left) {
                if (nums[right] > nums[left]) left = right;
                else right = left;
                continue;
            }
            if (nums[midIndex - 1] < nums[midIndex]) left = midIndex;
            else right = midIndex;
        }
        return left;
    }

}
