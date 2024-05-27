package May.day27;

/**
 * 时间：2024/5/27
 * 问题描述：
 * 给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶。
 * 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
 * 请你计算并返回达到楼梯顶部的最低花费。
 * 切入点/解决思路：
 * 感想：
 */
public class MinCostClimbingStairs {
    public int XXX(int[] cost) {
        /* 特殊处理 */
        if (cost == null || cost.length == 0) return 0;
        if (cost.length == 1) return cost[0];
        /* 使用动态规划完成 */
        int one = cost[0];
        int two = cost[1];
        for (int i = 2; i < cost.length; i++) {
            int tem = Math.min(one, two) + cost[i];
            one = two;
            two = tem;
        }
        return Math.min(one, two);
    }
}
