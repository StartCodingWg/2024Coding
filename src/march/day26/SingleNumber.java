package march.day26;

/**
 * Author:   wang
 * Date:     2024/3/26 22:39
 * function: 给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        /* 特殊情况处理 */
        if (nums == null || nums.length == 0) return -1;
        if (nums.length == 1) return nums[0];
        /* 直接处理，使用异或 */
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }
}
