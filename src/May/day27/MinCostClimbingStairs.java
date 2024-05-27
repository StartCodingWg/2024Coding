package May.day27;

/**
 * ʱ�䣺2024/5/27
 * ����������
 * ����һ���������� cost ������ cost[i] �Ǵ�¥�ݵ� i ��̨����������Ҫ֧���ķ��á�һ����֧���˷��ã�����ѡ��������һ����������̨�ס�
 * �����ѡ����±�Ϊ 0 ���±�Ϊ 1 ��̨�׿�ʼ��¥�ݡ�
 * ������㲢���شﵽ¥�ݶ�������ͻ��ѡ�
 * �����/���˼·��
 * ���룺
 */
public class MinCostClimbingStairs {
    public int XXX(int[] cost) {
        /* ���⴦�� */
        if (cost == null || cost.length == 0) return 0;
        if (cost.length == 1) return cost[0];
        /* ʹ�ö�̬�滮��� */
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
