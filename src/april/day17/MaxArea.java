package april.day17;

/**
 * ʱ�䣺2024/4/17
 * ����������
 * �����/���˼·��
 * ���룺
 */
public class MaxArea {
    public int maxArea(int[] height) {
        /* ����������� */
        if (height == null || height.length < 2) return 0;
        /* ��ʼ���㣺ʹ��̰���㷨 */
        int left = 0;
        int right = height.length - 1;
        int maxCap = 0;
        while (left < right) {
            maxCap = Math.max((right - left) * (Math.min(height[left], height[right])), maxCap);
            if (height[left] < height[right]) left++;
            else right--;
        }
        return maxCap;
    }
}
