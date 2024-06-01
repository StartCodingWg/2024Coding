package June.day01;

/**
 * 时间：2024/6/1
 * 问题描述：
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 * 切入点/解决思路：使用动态规划
 * 感想：
 */
public class rob {
    public int rob(int[] nums) {
        /* 特殊处理 */
        if (nums == null || nums.length == 0) return 0;
        /* 动态规划 */
        int first = 0;
        int second = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tem = Math.max( first + nums[i], second);
            first = second;
            second = tem;
        }
        return second;
    }
}
