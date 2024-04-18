package april.day07;

/**
 * Author:   wang
 * Date:     2024/4/7 22:08
 * function:
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 * 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
 */
public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        /* 特殊情况处理 */
        if (nums == null || nums.length <= 1) return nums;
        /* 使用两个数组保存乘积 */
        // helper1[i] = 0 ~ i-1 的乘积
        int[] helper1 = new int[nums.length];
        helper1[0] = 1;
        // helper2[i] = i + 1 ~ num.length - 1 的乘积
        int[] helper2 = new int[nums.length];
        helper2[nums.length - 1] = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            helper1[i + 1] = helper1[i] * nums[i];
            helper2[nums.length - 2 - i] = helper2[nums.length - 1 - i] * nums[nums.length - 1- i];
        }
        /* 计算 */
        for (int i = 0; i < nums.length; i++) {
            nums[i] = helper1[i] * helper2[i];
        }
        return nums;
    }
}
