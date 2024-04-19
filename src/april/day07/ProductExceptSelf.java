package april.day07;

/**
 * Author:   wang
 * Date:     2024/4/7 22:08
 * function:
 * ����һ���������� nums������ ���� answer ������ answer[i] ���� nums �г� nums[i] ֮�������Ԫ�صĳ˻� ��
 * ��Ŀ���� ��֤ ���� nums֮������Ԫ�ص�ȫ��ǰ׺Ԫ�غͺ�׺�ĳ˻�����  32 λ ������Χ�ڡ�
 * �� ��Ҫʹ�ó��������� O(n) ʱ�临�Ӷ�����ɴ��⡣
 */
public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        /* ����������� */
        if (nums == null || nums.length <= 1) return nums;
        /* ʹ���������鱣��˻� */
        // helper1[i] = 0 ~ i-1 �ĳ˻�
        int[] helper1 = new int[nums.length];
        helper1[0] = 1;
        // helper2[i] = i + 1 ~ num.length - 1 �ĳ˻�
        int[] helper2 = new int[nums.length];
        helper2[nums.length - 1] = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            helper1[i + 1] = helper1[i] * nums[i];
            helper2[nums.length - 2 - i] = helper2[nums.length - 1 - i] * nums[nums.length - 1- i];
        }
        /* ���� */
        for (int i = 0; i < nums.length; i++) {
            nums[i] = helper1[i] * helper2[i];
        }
        return nums;
    }
}
