package april.day17;

import java.util.HashMap;
import java.util.Map;

/**
 * ʱ�䣺2024/4/17
 * ��������������һ���������� nums ��һ������ k ��
 * ÿһ�������У�����Ҫ��������ѡ����Ϊ k ���������������������Ƴ����顣
 * ��������Զ�����ִ�е�����������
 * �����/���˼·��
 *  ���ʾ����ҵ������к�Ϊ  K ��Ԫ�ض�����ʹ�� hash���ÿռ任ʱ��
 * ���룺
 */
public class MaxOperations {
    public int maxOperations(int[] nums, int k) {
        /* ����������� */
        if (nums == null || nums.length < 2) return 0;
        /* ��¼ k - num[i] */
        Map<Integer, Integer> valNum = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer num = valNum.getOrDefault(nums[i], 0) + 1;
            valNum.put(nums[i], num);
        }
        /* ���� */
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            if (valNum.containsKey(nums[i]) && valNum.containsKey(k - nums[i])) {
                if (nums[i] == (k - nums[i]) && valNum.get(nums[i]) <= 1) {
                    continue;
                }
                int time1 = valNum.get(nums[i]) - 1;
                valNum.put(nums[i], time1);
                if (time1 == 0) valNum.remove(nums[i]);
                int time2 = valNum.get(k - nums[i]) - 1;
                valNum.put(k - nums[i], valNum.get(k - nums[i]) - 1);
                if (time2 == 0) valNum.remove(k - nums[i]);
                total++;
            }
        }
        return total;
    }
}
