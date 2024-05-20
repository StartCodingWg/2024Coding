package May.day20;

import java.util.Arrays;

/**
 * 时间：2024/5/20
 * 问题描述：
 * 给你两个正整数数组 spells 和 potions ，长度分别为 n 和 m ，其中 spells[i] 表示第 i 个咒语的能量强度，potions[j] 表示第 j 瓶药水的能量强度。
 * 同时给你一个整数 success 。一个咒语和药水的能量强度 相乘 如果 大于等于 success ，那么它们视为一对 成功 的组合。
 * 请你返回一个长度为 n 的整数数组 pairs，其中 pairs[i] 是能跟第 i 个咒语成功组合的 药水 数目。
 * 切入点/解决思路：
 * 感想：
 */
public class SuccessfulPairs {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        /* 特殊情况处理 */
        if (spells == null || potions == null || potions.length == 0 || spells.length == 0) return new int[0];
        /* 先排序然后使用二分法 */
        int[] res = new int[spells.length];
//        sortArray(potions, 0, potions.length - 1);
        Arrays.sort(potions);
        for (int i = 0; i < spells.length; i++) {
            res[i] = getIndex(potions, ((success - 1) / spells[i]) + 1);
        }
        return res;
    }

    /**
     * 时间复杂度：O（nlogn）
     *
     * @param potions
     * @param left
     * @param right
     */
    private void sortArray(int[] potions, int left, int right) {
        /* 递归结束条件 */
        if (left >= right) return;
        /* 递归体 */
        int pre = left;
        int post = right;
        while (pre < post) {
            /* 将大于 baseValue 的值左移 */
            while (pre < post && potions[post] > potions[pre]) post--;
            int tem = potions[pre];
            potions[pre] = potions[post];
            potions[post] = tem;
            /* 将小于 baseValue 的值右移 */
            while (pre < post && potions[pre] <= potions[post]) pre++;
            tem = potions[pre];
            potions[pre] = potions[post];
            potions[post] = tem;
        }
        sortArray(potions, left, pre - 1);
        sortArray(potions, post + 1, right);
    }

    /**
     * 使用桶排序
     * 时间复杂度：O（nlogn）
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
