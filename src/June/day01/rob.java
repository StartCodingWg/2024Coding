package June.day01;

/**
 * ʱ�䣺2024/6/1
 * ����������
 * ����һ��רҵ��С͵���ƻ�͵���ؽֵķ��ݡ�ÿ�䷿�ڶ�����һ�����ֽ�Ӱ����͵�Ե�Ψһ��Լ���ؾ������ڵķ���װ���໥��ͨ�ķ���ϵͳ������������ڵķ�����ͬһ���ϱ�С͵���룬ϵͳ���Զ�������
 * ����һ������ÿ�����ݴ�Ž��ķǸ��������飬������ ����������װ�õ������ ��һҹ֮���ܹ�͵�Ե�����߽�
 * �����/���˼·��ʹ�ö�̬�滮
 * ���룺
 */
public class rob {
    public int rob(int[] nums) {
        /* ���⴦�� */
        if (nums == null || nums.length == 0) return 0;
        /* ��̬�滮 */
        int first = 0;
        int second = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tem = Math.max( first + nums[i], second);
            first = second;
            second = tem;
        }
        return second;
    }
}
