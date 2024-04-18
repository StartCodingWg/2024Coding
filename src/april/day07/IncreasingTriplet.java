package april.day07;

/**
 * Author:   wang
 * Date:     2024/4/7 22:20
 * function:
 * ����һ���������� nums ���ж�����������Ƿ���ڳ���Ϊ 3 �ĵ��������С�
 * ���������������Ԫ���±� (i, j, k) ������ i < j < k ��ʹ�� nums[i] < nums[j] < nums[k] ������ true �����򣬷��� false ��
 */
public class IncreasingTriplet {
    public boolean increasingTriplet(int[] nums) {
        /* ����������� */
        if (nums == null || nums.length < 3) return false;
        /* �ж��Ƿ������������Ԫ�� */
        // ��¼��С��������
        Integer[] threeGuys = new Integer[3];
        for (int i = 0; i < nums.length; i++) {
            if (threeGuys[0] == null || threeGuys[0] >= nums[i]) {
                threeGuys[0] = nums[i];
            } else if (threeGuys[1] == null || threeGuys[1] >= nums[i]) {
                threeGuys[1] = nums[i];
            } else {
                return true;
            }
        }
        return false;
    }
}
