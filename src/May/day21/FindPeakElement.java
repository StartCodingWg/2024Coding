package May.day21;

/**
 * ʱ�䣺2024/5/21
 * ����������
 * ��ֵԪ����ָ��ֵ�ϸ������������ֵ��Ԫ�ء�
 * ����һ���������� nums���ҵ���ֵԪ�ز��������������� ����ܰ��������ֵ������������£����� �κ�һ����ֵ ����λ�ü��ɡ�
 * ����Լ��� nums[-1] = nums[n] = -�� ��
 * �����ʵ��ʱ�临�Ӷ�Ϊ O(log n) ���㷨����������⡣
 * �����/���˼·��
 * ���룺
 */
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        /* ����������� */
        if (nums == null || nums.length < 2) return 0;
        /* ʹ�ñ����� */
        for (int i = 0; i < nums.length; i++) {
            boolean isOk = true;
            if (i > 0 && nums[i] < nums[i - 1]) isOk = false;
            if (i < nums.length - 1 && nums[i] < nums[i + 1]) isOk = false;
            if (isOk) return i;
        }
        return -1;
    }

    /**
     * /\ ����
     * @param nums
     * @return
     */
    public int findPeakElement2(int[] nums) {
        /* ����������� */
        if (nums == null || nums.length < 2) return 0;
        /* ʹ�ö��ַ� */
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int midIndex = left + (right - left) / 2;
            if (midIndex == left) {
                if (nums[right] > nums[left]) left = right;
                else right = left;
                continue;
            }
            if (nums[midIndex - 1] < nums[midIndex]) left = midIndex;
            else right = midIndex;
        }
        return left;
    }

}
