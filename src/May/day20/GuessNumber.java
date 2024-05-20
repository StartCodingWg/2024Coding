package May.day20;

/**
 * 时间：2024/5/20
 * 问题描述：
 * 猜数字游戏的规则如下：
 * 每轮游戏，我都会从 1 到 n 随机选择一个数字。 请你猜选出的是哪个数字。
 * 如果你猜错了，我会告诉你，你猜测的数字比我选出的数字是大了还是小了。
 * 你可以通过调用一个预先定义好的接口 int guess(int num) 来获取猜测结果，返回值一共有 3 种可能的情况（-1，1 或 0）：
 * -1：我选出的数字比你猜的数字小 pick < num
 * 1：我选出的数字比你猜的数字大 pick > num
 * 0：我选出的数字和你猜的数字一样。恭喜！你猜对了！pick == num
 * 返回我选出的数字。
 * 切入点/解决思路：使用二分法
 * 感想：
 */
public class GuessNumber {
    /**
     * 时间复杂度：O（logn）
     * @param n
     * @return
     */
    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        while (left <= right ) {
            int mid = left + (right - left) / 2;
            if (guess(mid) == 0) return mid;
            else if (guess(mid) > 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    private int guess(int n) {
        return n;
    }

}
