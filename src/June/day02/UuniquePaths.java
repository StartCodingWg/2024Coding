package June.day02;

/**
 * ʱ�䣺2024/6/2
 * ����������
 * һ��������λ��һ�� m x n ��������Ͻ� ����ʼ������ͼ�б��Ϊ ��Start�� ����
 * ������ÿ��ֻ�����»��������ƶ�һ������������ͼ�ﵽ��������½ǣ�����ͼ�б��Ϊ ��Finish�� ����
 * ���ܹ��ж�������ͬ��·����
 * �����/���˼·��ʹ�ö�̬�滮������Ϊ��
 * dp[i][j] = dp[i-1][j] + dp[i][j-1]
 * ��ʼ������dp[0][j] = 1, dp[i][0] = 1, 0<=i<=m, 0<=j<=n
 * ���룺
 */
public class UuniquePaths {
    /**
     * ʱ�临�Ӷȣ�O��n*m��
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        /* ����������� */
        if (m == 0 || n == 0) return 0;
        /* ʹ�ö�̬�滮 */
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
