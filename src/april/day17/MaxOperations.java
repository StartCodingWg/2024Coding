package april.day17;

import java.util.HashMap;
import java.util.Map;

/**
 * 时间：2024/4/17
 * 问题描述：给你一个整数数组 nums 和一个整数 k 。
 * 每一步操作中，你需要从数组中选出和为 k 的两个整数，并将它们移出数组。
 * 返回你可以对数组执行的最大操作数。
 * 切入点/解决思路：
 *  本质就是找到数组中和为  K 的元素对数，使用 hash，用空间换时间
 * 感想：
 */
public class MaxOperations {
    public int maxOperations(int[] nums, int k) {
        /* 特殊情况处理 */
        if (nums == null || nums.length < 2) return 0;
        /* 记录 k - num[i] */
        Map<Integer, Integer> valNum = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer num = valNum.getOrDefault(nums[i], 0) + 1;
            valNum.put(nums[i], num);
        }
        /* 查找 */
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            if (valNum.containsKey(nums[i]) && valNum.containsKey(k - nums[i])) {
                if (nums[i] == (k - nums[i]) && valNum.get(nums[i]) <= 1) {
                    continue;
                }
                int time1 = valNum.get(nums[i]) - 1;
                valNum.put(nums[i], time1);
                if (time1 == 0) valNum.remove(nums[i]);
                int time2 = valNum.get(k - nums[i]) - 1;
                valNum.put(k - nums[i], valNum.get(k - nums[i]) - 1);
                if (time2 == 0) valNum.remove(k - nums[i]);
                total++;
            }
        }
        return total;
    }
}
