package april.day18;

/**
 * 时间：2024/4/18
 * 问题描述：
 * 给你一个二进制数组 nums ，你需要从中删掉一个元素。
 * 请你在删掉元素的结果数组中，返回最长的且只包含 1 的非空子数组的长度。
 * 如果不存在这样的子数组，请返回 0 。
 * 切入点/解决思路：滑动窗口
 * 感想：
 */
public class LongestSubarray {
    public int longestSubarray(int[] nums) {
        /* 特殊情况处理 */
        if (nums == null || nums.length < 1) return 0;
        /* 开始使用滑动窗口 */
        int leftSum = 0;
        int rightSum = 0;
        int res = 0;
        for (int val : nums) {
            if (val == 0) {
                rightSum = leftSum;
                leftSum = 0;
            } else {
                rightSum++;
                leftSum++;
            }
            res = Math.max(rightSum, leftSum);
        }
        if (res == nums.length) res -= 1;
        return res;
    }
}
