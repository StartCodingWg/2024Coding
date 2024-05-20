package May.day20;

import java.util.Arrays;

/**
 * ʱ�䣺2024/5/20
 * ����������
 * ������������������ spells �� potions �����ȷֱ�Ϊ n �� m ������ spells[i] ��ʾ�� i �����������ǿ�ȣ�potions[j] ��ʾ�� j ƿҩˮ������ǿ�ȡ�
 * ͬʱ����һ������ success ��һ�������ҩˮ������ǿ�� ��� ��� ���ڵ��� success ����ô������Ϊһ�� �ɹ� ����ϡ�
 * ���㷵��һ������Ϊ n ���������� pairs������ pairs[i] ���ܸ��� i ������ɹ���ϵ� ҩˮ ��Ŀ��
 * �����/���˼·��
 * ���룺
 */
public class SuccessfulPairs {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        /* ����������� */
        if (spells == null || potions == null || potions.length == 0 || spells.length == 0) return new int[0];
        /* ������Ȼ��ʹ�ö��ַ� */
        int[] res = new int[spells.length];
//        sortArray(potions, 0, potions.length - 1);
        Arrays.sort(potions);
        for (int i = 0; i < spells.length; i++) {
            res[i] = getIndex(potions, ((success - 1) / spells[i]) + 1);
        }
        return res;
    }

    /**
     * ʱ�临�Ӷȣ�O��nlogn��
     *
     * @param potions
     * @param left
     * @param right
     */
    private void sortArray(int[] potions, int left, int right) {
        /* �ݹ�������� */
        if (left >= right) return;
        /* �ݹ��� */
        int pre = left;
        int post = right;
        while (pre < post) {
            /* ������ baseValue ��ֵ���� */
            while (pre < post && potions[post] > potions[pre]) post--;
            int tem = potions[pre];
            potions[pre] = potions[post];
            potions[post] = tem;
            /* ��С�� baseValue ��ֵ���� */
            while (pre < post && potions[pre] <= potions[post]) pre++;
            tem = potions[pre];
            potions[pre] = potions[post];
            potions[post] = tem;
        }
        sortArray(potions, left, pre - 1);
        sortArray(potions, post + 1, right);
    }

    /**
     * ʹ��Ͱ����
     * ʱ�临�Ӷȣ�O��nlogn��
     *
     * @param potions
     */
    private void sortArray2(int[] potions) {
        int[] bucket = new int[100001];
        for (int i = 0; i < potions.length; i++) {
            bucket[potions[i]]++;
        }
        int index = 0;
        for (int i = 0; i < bucket.length; i++) {
            while (bucket[i] > 0) {
                potions[index++] = i;
                bucket[i]--;
            }
        }
    }


    private int getIndex(int[] position, long val) {
        int left = 0;
        int right = position.length - 1;
        while (left < right) {
            int midIndex = left + (right - left) / 2;
            if (position[midIndex] >= val) {
                right = midIndex;
            } else left = midIndex + 1;
        }
        return position[right] >= val ? position.length - right : 0;
    }

    public static void main(String[] args) {
        int[] spell = new int[]{5, 1, 3};
        int[] position = new int[]{1, 2, 3, 4, 5};
        int succes = 7;
        SuccessfulPairs successfulPairs = new SuccessfulPairs();
        successfulPairs.sortArray2(new int[]{1, 43, 2, 1, 5});
        successfulPairs.successfulPairs(spell, position, succes);
    }
}
