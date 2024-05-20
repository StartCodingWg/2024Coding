package May.day18;

import java.lang.management.MemoryType;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * ʱ�䣺2024/5/18
 * ����������
 * ���������±�� 0 ��ʼ���������� nums1 �� nums2 �����߳��ȶ��� n ���ٸ���һ�������� k �������� nums1 ��ѡһ������Ϊ k �� ������ ��Ӧ���±ꡣ
 * ����ѡ����±� i0 ��i1 ��...�� ik - 1 ����� ���� �������£�
 * nums1 ���±��ӦԪ����ͣ����� nums2 ���±��ӦԪ�ص� ��Сֵ ��
 * �ù�ʽ��ʾ�� (nums1[i0] + nums1[i1] +...+ nums1[ik - 1]) * min(nums2[i0] , nums2[i1], ... ,nums2[ik - 1]) ��
 * ���㷵�� ��� ���ܵķ�����
 * һ������� ������ �±��Ǽ��� {0, 1, ..., n-1} ��ɾ������Ԫ�صõ���ʣ�༯�ϣ�Ҳ���Բ�ɾ���κ�Ԫ�ء�
 * �����/���˼·��ʹ��̰���㷨
 * ���룺hard��������Ŀ���࣬���ѵ�����
 */
public class MaxScore {

    /**
     * @param nums1
     * @param nums2
     * @param k
     * @return
     */
    public long maxScore(int[] nums1, int[] nums2, int k) {
        /* ����������� */
        if (nums1 == null || nums2 == null || nums2.length != nums1.length || k > nums1.length || k == 0) return 0;
        /* ʹ�����ȼ����д��� */
        PriorityQueue<Integer> minMulti = new PriorityQueue<>(k);
        long sumTotal = 0;
        // ��ǰ�� k ����Ч�����ݷ����ȼ�������
        Set<Integer> indexSet = new HashSet<>();
        int begin = 0;
        while (indexSet.size() < k && begin < nums1.length) {
            if (nums2[begin] != 0) {
                minMulti.offer(nums2[begin]);
                sumTotal += nums1[begin];
                indexSet.add(begin);
            }
            begin++;
        }
        if (begin == nums1.length) return indexSet.size() == k ? sumTotal * minMulti.peek() : 0;
        // ��ʼ����
        for (int i = begin; i < nums1.length; i++) {
            if (nums2[i] == 0) continue;
            int replaceIndex = -1;
            long maxTotalScore = 0;
            // ѡ����Ҫ�滻��Ԫ��
            for (Integer integer : indexSet) {
                long newTotalSocre = getNewTotalSocre(sumTotal, minMulti, nums1, nums2, integer, i);
                if (newTotalSocre > maxTotalScore) {
                    maxTotalScore = newTotalSocre;
                    replaceIndex = integer;
                }
            }
            /* �������� */
            if (maxTotalScore > (sumTotal * minMulti.peek())) {
                sumTotal = sumTotal - nums1[replaceIndex] + nums1[i];
                minMulti.remove(nums2[replaceIndex]);
                minMulti.add(nums2[i]);
                indexSet.remove(replaceIndex);
                indexSet.add(i);
            }
        }
        return sumTotal * minMulti.peek();
    }

    private long getNewTotalSocre(long sumTotal, PriorityQueue<Integer> minMulti, int[] nums1, int[] nums2, int replaceIndex, int index) {
        // ���ü��㣬һ��С�ڵ����
        if (nums1[index] <= nums1[replaceIndex] && nums2[index] <= nums2[replaceIndex]) return 0;
        // �����·���
        sumTotal = sumTotal - nums1[replaceIndex] + nums1[index];
        int newMulti = Math.min(minMulti.peek(), nums2[index]);
        // ������Ƴ���Ԫ�ػ�Ӱ�쵽��С������������Ԫ�ض�Ӧ�ĳ���������С����
        if (nums2[index] > minMulti.peek()
                && minMulti.peek() == nums2[replaceIndex] ) {
            minMulti.poll();
            newMulti = minMulti.size() == 0 ? nums2[index] : Math.min(minMulti.peek(), nums2[index]);
            minMulti.offer(nums2[replaceIndex]);
        }
        return sumTotal * newMulti;
    }

    public static void main(String[] args) {
        int[] nums1 = {79,76,41,28,41,66,44,30,25};
        int[] nums2 = {25,0,69,67,55,0,9,77,26};
        int k = 7;
        MaxScore maxScore = new MaxScore();
        System.out.println(maxScore.maxScore(nums1, nums2, k));
    }
}