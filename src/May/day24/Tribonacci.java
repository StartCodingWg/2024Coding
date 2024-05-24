package May.day24;

/**
 * 时间：2024/5/24
 * 问题描述：
 * 泰波那契序列 Tn 定义如下：
 * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 * 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
 * 切入点/解决思路：
 * 感想：
 */
public class Tribonacci {
    public int tribonacci(int n) {
        int t0 = 0, t1 = 1, t2 = 1;
        if (n == 0) return t0;
        if (n == 1) return t1;
        if (n == 2) return t2;
        for (int i = 3; i <= n; i++) {
            int t3 = t0 + t1 + t2;
            t0 = t1;
            t1 = t2;
            t2 = t3;
        }
        return t2;
    }
}
