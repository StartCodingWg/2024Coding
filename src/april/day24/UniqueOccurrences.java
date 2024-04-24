package april.day24;

/**
 * Author:   wang
 * Date:     2024/4/24 23:02
 * function:
 * 给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
 * 如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
 * idea: hash
 */
public class UniqueOccurrences {
    /**
     * 时间复杂的：O（n）
     * 空间复杂的：O（1）
     * @param arr
     * @return
     */
    public boolean uniqueOccurrences(int[] arr) {
        /* 特殊情况处理 */
        if (arr == null || arr.length <= 1) return true;
        /* 计算每个数出现的次数（使用 hash 计算 */
        short[] hash = new short[2001];
        for (int i = 0; i < arr.length; i++) {
            hash[arr[i] + 1000]++;
        }
        /* 判断是否存在重复的数字（使用 hash） */
        boolean[] isRepeat = new boolean[1001];
        for (int i = 0; i < hash.length; i++) {
            // 出现重复的数字
            if (hash[i] > 0 && isRepeat[hash[i]]) return false;
            isRepeat[hash[i]] = true;
        }
        return true;
    }

}
