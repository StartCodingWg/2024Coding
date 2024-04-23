package april.day23;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Author:   wang
 * Date:     2024/4/23 22:35
 * function:
 * ���������±�� 0 ��ʼ���������� nums1 �� nums2 �����㷵��һ������Ϊ 2 ���б� answer �����У�
 * answer[0] �� nums1 ������ �� ������ nums2 �е� ��ͬ ������ɵ��б�
 * answer[1] �� nums2 ������ �� ������ nums1 �е� ��ͬ ������ɵ��б�
 * ע�⣺�б��е��������԰� ���� ˳�򷵻ء�
 * ʹ�� hash
 */
public class FindDifference {
    /**
     * ʱ�临�ӵģ�O��4n��
     * �ռ临�Ӷȣ�O��n��
     * @param nums1
     * @param nums2
     * @return
     */
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        int[] hash1 = new int[2001];
        int[] hash2 = new int[2001];
        /* �����ݷ��� hash ���� */
        for (int i = 0; i < nums1.length; i++) {
            hash1[nums1[i] + 1000] = 1;
        }
        for (int i = 0; i < nums2.length; i++) {
            hash2[nums2[i] + 1000] = 1;
        }
        /* ��ȡ��� */
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
     * ʱ�临�ӵģ�O��4n��
     * �ռ临�Ӷȣ�O��n��
     * @param nums1
     * @param nums2
     * @return
     */
    public List<List<Integer>> findDifference2(int[] nums1, int[] nums2) {
        /* �����ݷ��� hash ���� */
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        /* ��ȡ��� */
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
