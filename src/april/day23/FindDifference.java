package april.day23;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Author:   wang
 * Date:     2024/4/23 22:35
 * function:
 * 给你两个下标从 0 开始的整数数组 nums1 和 nums2 ，请你返回一个长度为 2 的列表 answer ，其中：
 * answer[0] 是 nums1 中所有 不 存在于 nums2 中的 不同 整数组成的列表。
 * answer[1] 是 nums2 中所有 不 存在于 nums1 中的 不同 整数组成的列表。
 * 注意：列表中的整数可以按 任意 顺序返回。
 * 使用 hash
 */
public class FindDifference {
    /**
     * 时间复杂的：O（4n）
     * 空间复杂度：O（n）
     * @param nums1
     * @param nums2
     * @return
     */
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        int[] hash1 = new int[2001];
        int[] hash2 = new int[2001];
        /* 将数据放在 hash 表中 */
        for (int i = 0; i < nums1.length; i++) {
            hash1[nums1[i] + 1000] = 1;
        }
        for (int i = 0; i < nums2.length; i++) {
            hash2[nums2[i] + 1000] = 1;
        }
        /* 获取结果 */
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> res1 = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            if (hash2[nums1[i] + 1000]++ == 1) res1.add(nums1[i]);
        }
        List<Integer> res2 = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            if (hash1[nums2[i] + 1000]++ == 1) res2.add(nums2[i]);
        }
        res.add(res1);
        res.add(res2);
        return res;
    }

    /**
     * 时间复杂的：O（4n）
     * 空间复杂度：O（n）
     * @param nums1
     * @param nums2
     * @return
     */
    public List<List<Integer>> findDifference2(int[] nums1, int[] nums2) {
        /* 将数据放在 hash 表中 */
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        /* 获取结果 */
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> res1 = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            if (!set2.contains(nums1[i])) res1.add(nums1[i]);
        }
        List<Integer> res2 = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            if (!set1.contains(nums2[i])) res2.add(nums2[i]);
        }
        res.add(res1);
        res.add(res2);
        return res;
    }

}
