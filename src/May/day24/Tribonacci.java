package May.day24;

/**
 * ʱ�䣺2024/5/24
 * ����������
 * ̩���������� Tn �������£�
 * T0 = 0, T1 = 1, T2 = 1, ���� n >= 0 �������� Tn+3 = Tn + Tn+1 + Tn+2
 * �������� n���뷵�ص� n ��̩�������� Tn ��ֵ��
 * �����/���˼·��
 * ���룺
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
