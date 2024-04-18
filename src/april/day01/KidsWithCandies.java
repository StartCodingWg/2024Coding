package april.day01;

import java.util.LinkedList;
import java.util.List;

/**
 * Author:   wang
 * Date:     2024/4/1 21:05
 * function: ����һ������ candies ��һ������ extraCandies ������ candies[i] ����� i ������ӵ�е��ǹ���Ŀ��
 *
 * ��ÿһ�����ӣ�����Ƿ����һ�ַ������������ extraCandies ���ǹ������������֮�󣬴˺����� ��� ���ǹ���ע�⣬�����ж������ͬʱӵ�� ��� ���ǹ���Ŀ��
 *
 */
public class KidsWithCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> res = new LinkedList<>();
        /* ���⴦�� */
        if (candies == null) return res;
        /* ��ȡ����ǹ��� */
        int max = candies[0];
        for (int i = 1; i < candies.length; i++) {
            max = Math.max(max, candies[i]);
        }
        /* �ж�ÿ�������Ƿ��ܹ���Ϊӵ���ǹ������ĺ��� */
        for (int i = 0; i < candies.length; i++) {
            res.add(candies[i] + extraCandies >= max ? true : false);
        }
        return res;
    }
}
