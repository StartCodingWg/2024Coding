package april.day18;

/**
 * 时间：2024/4/18
 * 问题描述：给你一个由 n 个元素组成的整数数组 nums 和一个整数 k 。
 * 请你找出平均数最大且 长度为 k 的连续子数组，并输出该最大平均数。
 * 任何误差小于 10-5 的答案都将被视为正确答案。
 * 切入点/解决思路：
 * 感想：
 */
public class FindMaxAverage {
    public double findMaxAverage(int[] nums, int k) {
        /* 特殊情况处理 */
        if (nums == null || nums.length < 1 || nums.length < k) return 0;
        /* 使用滑动窗口 */
        int left = 0;
        int right= 0;
        double max = 0;
        double maxAvgVal = - Integer.MAX_VALUE;
        while (right < nums.length) {
            max += nums[right];
            if ((right - left + 1) == k) {
                maxAvgVal = Math.max(maxAvgVal, max / k);
                max -= nums[left];
                left++;
            }
            right++;
        }
        return maxAvgVal;
    }
}
