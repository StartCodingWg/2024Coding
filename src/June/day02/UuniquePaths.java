package June.day02;

/**
 * 时间：2024/6/2
 * 问题描述：
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * 问总共有多少条不同的路径？
 * 切入点/解决思路：使用动态规划，方程为：
 * dp[i][j] = dp[i-1][j] + dp[i][j-1]
 * 初始条件：dp[0][j] = 1, dp[i][0] = 1, 0<=i<=m, 0<=j<=n
 * 感想：
 */
public class UuniquePaths {
    /**
     * 时间复杂度：O（n*m）
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        /* 特殊情况处理 */
        if (m == 0 || n == 0) return 0;
        /* 使用动态规划 */
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        dp[0][0] = 0;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

}
