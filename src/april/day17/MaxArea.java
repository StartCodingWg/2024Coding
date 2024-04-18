package april.day17;

/**
 * 时间：2024/4/17
 * 问题描述：
 * 切入点/解决思路：
 * 感想：
 */
public class MaxArea {
    public int maxArea(int[] height) {
        /* 特殊情况处理 */
        if (height == null || height.length < 2) return 0;
        /* 开始计算：使用贪心算法 */
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
