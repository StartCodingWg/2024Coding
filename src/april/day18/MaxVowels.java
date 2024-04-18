package april.day18;

import java.util.HashSet;
import java.util.Set;

/**
 * 时间：2024/4/18
 * 问题描述：给你字符串 s 和整数 k 。
 * 请返回字符串 s 中长度为 k 的单个子字符串中可能包含的最大元音字母数。
 * 英文中的 元音字母 为（a, e, i, o, u）。
 * 切入点/解决思路：滑动窗口
 * 感想：
 */
public class MaxVowels {
    public int maxVowels(String s, int k) {
        /* 特殊情况处理 */
        if (s == null || s.length() < 1 || s.length() < k) return 0;
        /* 使用滑动窗口 */
        Set<Character> set = new HashSet<Character>(){{add('a');add('e');add('i');add('o');add('u');}};
        char[] chars = s.toCharArray();
        // 最大的元音字母数
        int maxRes = 0;
        // 窗口中的元音字母数
        int res = 0;
        for (int i = 0; i < k; i++) {
            if (set.contains(chars[i])) res++;
        }
        maxRes = res;
        for (int i = k; i < chars.length; i++) {
            /* 每次移动一次滑动窗口 */
            if (set.contains(chars[i - k])) res--;
            if (set.contains(chars[i])) res++;
            maxRes = Math.max(maxRes, res);
        }
        return maxRes;
    }
}
