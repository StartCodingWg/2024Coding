package June.day04;

/**
 * 时间：2024/6/4
 * 问题描述：
 * 给定一个整数数组 prices，其中 prices[i]表示第 i 天的股票价格 ；整数 fee 代表了交易股票的手续费用。
 * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 * 返回获得利润的最大值。
 * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
 * 切入点/解决思路：再保证利润的同时减少卖出次数
 * 感想：
 */
public class MaxProfit {
    public int maxProfit(int[] prices, int fee) {
        /* 特殊情况处理 */
        if (prices == null || prices.length < 2) return 0;
        /* 使用 dp 完成本题 */
        int totalProfit = 0;
        int profit = 0;
        int loss = 0;
        int index = 1;
        while (index < prices.length) {
            if (prices[index] > prices[index - 1]) {
                /* 进行一次迈入卖出 */
                profit = 0;
                while (index < prices.length) {
                    if (prices[index] > prices[index - 1]) {
                        profit += prices[index] - prices[index - 1];
                        index++;
                    } else {
                        /* 判断连续的下跌是否会导致损失大于手续费，如果会导致，则表示需要在上次的最高点卖出  */
                        loss = 0;
                        while (index < prices.length && prices[index] <= prices[index - 1] && loss <= fee) {
                            loss += prices[index - 1] - prices[index];
                            index++;
                        }
                        if (!(loss > fee || index == prices.length || profit < loss)) {
                            /* 继续持有当前股票 */
                            profit -= loss;
                        } else break;
                    }
                }
                if (loss > fee || index == prices.length) {
                    /* 需要卖出该股票 */
                    totalProfit += Math.max(0, profit - fee);
                }
            } else index++;
        }
        return totalProfit;
    }

    public int maxProfit2(int[] prices, int fee) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[prices.length - 1][0];
    }
}
