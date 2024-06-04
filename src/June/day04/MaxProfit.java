package June.day04;

/**
 * ʱ�䣺2024/6/4
 * ����������
 * ����һ���������� prices������ prices[i]��ʾ�� i ��Ĺ�Ʊ�۸� ������ fee �����˽��׹�Ʊ���������á�
 * ��������޴ε���ɽ��ף�������ÿ�ʽ��׶���Ҫ�������ѡ�������Ѿ�������һ����Ʊ����������֮ǰ��Ͳ����ټ��������Ʊ�ˡ�
 * ���ػ����������ֵ��
 * ע�⣺�����һ�ʽ���ָ������в�������Ʊ���������̣�ÿ�ʽ�����ֻ��ҪΪ֧��һ�������ѡ�
 * �����/���˼·���ٱ�֤�����ͬʱ������������
 * ���룺
 */
public class MaxProfit {
    public int maxProfit(int[] prices, int fee) {
        /* ����������� */
        if (prices == null || prices.length < 2) return 0;
        /* ʹ�� dp ��ɱ��� */
        int totalProfit = 0;
        int profit = 0;
        int loss = 0;
        int index = 1;
        while (index < prices.length) {
            if (prices[index] > prices[index - 1]) {
                /* ����һ���������� */
                profit = 0;
                while (index < prices.length) {
                    if (prices[index] > prices[index - 1]) {
                        profit += prices[index] - prices[index - 1];
                        index++;
                    } else {
                        /* �ж��������µ��Ƿ�ᵼ����ʧ���������ѣ�����ᵼ�£����ʾ��Ҫ���ϴε���ߵ�����  */
                        loss = 0;
                        while (index < prices.length && prices[index] <= prices[index - 1] && loss <= fee) {
                            loss += prices[index - 1] - prices[index];
                            index++;
                        }
                        if (!(loss > fee || index == prices.length || profit < loss)) {
                            /* �������е�ǰ��Ʊ */
                            profit -= loss;
                        } else break;
                    }
                }
                if (loss > fee || index == prices.length) {
                    /* ��Ҫ�����ù�Ʊ */
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
