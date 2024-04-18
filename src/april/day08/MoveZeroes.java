package april.day08;

/**
 * Author:   wang
 * Date:     2024/4/8 22:27
 * function:
 * ����һ������ nums����дһ������������ 0 �ƶ��������ĩβ��ͬʱ���ַ���Ԫ�ص����˳��
 *
 * ��ע�� �������ڲ���������������ԭ�ض�������в�����
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        /* ����������� */
        if (nums == null || nums.length <= 1) return;
        /* ʹ��˫ָ�뿪ʼ�ƶ� */
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                nums[left] = nums[right];
                if (left != right) nums[right] = 0;
                left++;
            }
            right++;
        }
    }
}
