package april.day18;

/**
 * 时间：2024/4/18
 * 问题描述：给定一个二进制数组 nums 和一个整数 k，如果可以翻转最多 k 个 0 ，则返回 数组中连续 1 的最大个数 。
 * 切入点/解决思路：滑动窗口
 * 感想：
 */
public class LongestOnes {
    public int longestOnes(int[] nums, int k) {
        /* 特殊情况处理 */
        if (nums == null) return 0;
        if (nums.length < 1 || nums.length < k) return nums.length;
        /* 使用滑动窗口 */
        int left = 0;
        int right = -1;
        for (int i = 0; i <= k && right < nums.length;) {
            right++;
            if (right < nums.length && nums[right] == 0) i++;
        }
        int maxNum = right;
        while (right < nums.length) {
            /* 收缩一个 0 */
            while (left < right && nums[left] != 0) left++;
            left++;
            /* 扩展一个 0 */
            right++;
            while (right < nums.length && nums[right] != 0) right++;
            maxNum = Math.max(maxNum, right - left);
        }
        return maxNum;
    }
}
