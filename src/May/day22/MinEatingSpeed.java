package May.day22;

import java.util.Arrays;

/**
 * ʱ�䣺2024/5/22
 * ����������
 * ����ϲ�����㽶�������� n ���㽶���� i ������ piles[i] ���㽶�������Ѿ��뿪�ˣ����� h Сʱ�������
 * ������Ծ��������㽶���ٶ� k ����λ����/Сʱ����ÿ��Сʱ��������ѡ��һ���㽶�����гԵ� k ����
 * �������㽶���� k ���������Ե���ѵ������㽶��Ȼ����һСʱ�ڲ����ٳԸ�����㽶��
 * ����ϲ�������ԣ�����Ȼ���ھ�������ǰ�Ե����е��㽶��
 * ������������ h Сʱ�ڳԵ������㽶����С�ٶ� k��k Ϊ��������
 * �����/���˼·��
 * ���룺
 */
public class MinEatingSpeed {
    /**
     * oh my god
     * @param piles
     * @param h
     * @return
     */
    public int minEatingSpeed(int[] piles, int h) {
        /* ����������� */
        if (piles == null || piles.length == 0 || piles.length > h) return 0;
        // ���㽶�ѽ�������
        Arrays.sort(piles);
        // ʹ�ö��ַ����ҵ���һ��ʹ������Сʱ�� >= h �� k���� piles �в��ң� - ʱ�临�Ӷȣ�O(nlogn)
        int left = 0, right = piles.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (getCost(piles, piles[mid], mid) > h) left = mid + 1;
            else right = mid;
        }
        /* ʹ�ö��ַ����� [pre, post] ֮���ҵ�����Ҫ��� k */
        int pre = left == 0 ? 1 : piles[left - 1] + 1, post = piles[left];
        while (pre < post) {
            int mid = pre + (post - pre) / 2;
            if (getCost(piles, mid, left) > h) pre = mid + 1;
            else post = mid;
        }
        return pre;
    }

    private int getCost(int[] piles, int val, int beginIndex) {
        int res = beginIndex;
        for (int i = beginIndex; i < piles.length; i++) {
            res += (piles[i] % val == 0 ? piles[i] / val : (piles[i] / val) + 1);
        }
        return res;
    }
}
