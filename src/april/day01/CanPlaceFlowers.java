package april.day01;

/**
 * Author:   wang
 * Date:     2024/4/1 21:10
 * function:
 */
public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        /* 特殊处理 */
        if (flowerbed == null || ((flowerbed.length + 1) / 2) < n) return false;
        if (n <= 0) return true;
        /* 判断是否可以放入（使用双指针） */
        int[] tem = new int[flowerbed.length + 4];
        tem[0] = 1;
        tem[tem.length - 1] = 1;
        for (int i = 0; i < flowerbed.length; i++) {
            tem[i + 2] = flowerbed[i];
        }
        int left = 1;
        int right = 1;
        while (right < tem.length && n > 0) {
            if (tem[right] == 1) {
                if (right - left > 2) {
                    n -= ((right - left - 1) / 2);
                }
                left = right + 1;
            }
            right++;
        }
        return n <= 0;
    }
}
