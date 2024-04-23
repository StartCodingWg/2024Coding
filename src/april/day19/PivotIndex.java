package april.day19;

/**
 * 时间：2024/4/19
 * 问题描述：
 * 给你一个整数数组 nums ，请计算数组的 中心下标 。
 *
 * 数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
 *
 * 如果中心下标位于数组最左端，那么左侧数之和视为 0 ，因为在下标的左侧不存在元素。这一点对于中心下标位于数组最右端同样适用。
 *
 * 如果数组有多个中心下标，应该返回 最靠近左边 的那一个。如果数组不存在中心下标，返回 -1 。
 * 切入点/解决思路：
 * 感想：
 */
public class PivotIndex {
    public int pivotIndex(int[] nums) {
        /* 特殊情况处理 */
        if (nums == null) return -1;
        /* 开始处理 */
        int sum = 0;
        for (int val : nums) sum += val;
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum - nums[i] - leftSum == leftSum) return i;
            leftSum += nums[i];
        }
        return -1;
    }
}
