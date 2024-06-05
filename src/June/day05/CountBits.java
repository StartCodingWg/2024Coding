package June.day05;

/**
 * ʱ�䣺2024/6/5
 * ����������
 * �����/���˼·��
 * ���룺
 */
public class CountBits {
    public int[] countBits(int n) {
        int[] res = new int[n+1];
        for (int i = 0; i <= n; i++) {
            res[i] = getNumOne(i);
        }
        return res;
    }

    private int getNumOne(int n) {
        int res = 0;
        while (n > 0) {
            res += n & 1;
            n = n >>> 1;
        }
        return res;
    }
}
