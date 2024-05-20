package May.day20;

/**
 * ʱ�䣺2024/5/20
 * ����������
 * ��������Ϸ�Ĺ������£�
 * ÿ����Ϸ���Ҷ���� 1 �� n ���ѡ��һ�����֡� �����ѡ�������ĸ����֡�
 * �����´��ˣ��һ�����㣬��²�����ֱ���ѡ���������Ǵ��˻���С�ˡ�
 * �����ͨ������һ��Ԥ�ȶ���õĽӿ� int guess(int num) ����ȡ�²���������ֵһ���� 3 �ֿ��ܵ������-1��1 �� 0����
 * -1����ѡ�������ֱ���µ�����С pick < num
 * 1����ѡ�������ֱ���µ����ִ� pick > num
 * 0����ѡ�������ֺ���µ�����һ������ϲ����¶��ˣ�pick == num
 * ������ѡ�������֡�
 * �����/���˼·��ʹ�ö��ַ�
 * ���룺
 */
public class GuessNumber {
    /**
     * ʱ�临�Ӷȣ�O��logn��
     * @param n
     * @return
     */
    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        while (left <= right ) {
            int mid = left + (right - left) / 2;
            if (guess(mid) == 0) return mid;
            else if (guess(mid) > 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    private int guess(int n) {
        return n;
    }
}
