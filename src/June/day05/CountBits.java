package June.day05;

/**
 * 时间：2024/6/5
 * 问题描述：
 * 切入点/解决思路：
 * 感想：
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
