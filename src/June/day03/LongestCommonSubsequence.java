package June.day03;

/**
 * ʱ�䣺2024/6/3
 * ����������
 * ���������ַ��� text1 �� text2�������������ַ������ ���������� �ĳ��ȡ���������� ���������� ������ 0 ��
 * һ���ַ����� ������ ��ָ����һ���µ��ַ�����������ԭ�ַ����ڲ��ı��ַ������˳��������ɾ��ĳЩ�ַ���Ҳ���Բ�ɾ���κ��ַ�������ɵ����ַ�����
 * ���磬"ace" �� "abcde" �������У��� "aec" ���� "abcde" �������С�
 * �����ַ����� ���������� ���������ַ�������ͬӵ�е������С�
 * �����/���˼·��ʹ�ö�̬�滮
 * ���룺
 */
public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text2 == null) return 0;
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 1; i <= text1.length(); i++) {
            char c1 = text1.charAt(i - 1);
            for (int j = 1; j <= text2.length() ; j++) {
                char c2 = text2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
}
