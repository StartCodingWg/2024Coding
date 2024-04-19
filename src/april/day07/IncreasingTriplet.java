package april.day07;

/**
 * Author:   wang
 * Date:     2024/4/7 22:20
 * function:
 * 给你一个整数数组 nums ，判断这个数组中是否存在长度为 3 的递增子序列。
 * 如果存在这样的三元组下标 (i, j, k) 且满足 i < j < k ，使得 nums[i] < nums[j] < nums[k] ，返回 true ；否则，返回 false 。
 */
public class IncreasingTriplet {
    public boolean increasingTriplet(int[] nums) {
        /* 特殊情况处理 */
        if (nums == null || nums.length < 3) return false;
        /* 判断是否存在这样的三元组 */
        // 记录最小的三个数
        Integer[] threeGuys = new Integer[3];
        for (int i = 0; i < nums.length; i++) {
            if (threeGuys[0] == null || threeGuys[0] >= nums[i]) {
                threeGuys[0] = nums[i];
            } else if (threeGuys[1] == null || threeGuys[1] >= nums[i]) {
                threeGuys[1] = nums[i];
            } else {
                return true;
            }
        }
        return false;
    }
}
