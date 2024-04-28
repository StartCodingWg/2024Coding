package april.day27;

/**
 * Author:   wang
 * Date:     2024/4/27 23:11
 * function:
 * 给你一个包含若干星号 * 的字符串 s 。
 *
 * 在一步操作中，你可以：
 *
 * 选中 s 中的一个星号。
 * 移除星号 左侧 最近的那个 非星号 字符，并移除该星号自身。
 * 返回移除 所有 星号之后的字符串。
 * 直接使用数组即可，简单
 */
public class RemoveStars {
    public String removeStars(String s) {
        /* 特殊情况处理 */
        if (s == null || s.length() < 2) return s;
        /* 直接处理 */
        char[] res = s.toCharArray();
        // 双指针
        int vaildIdx = 0;
        for (int i = 1; i < res.length; i++) {
            if (res[i] == '*') {
                vaildIdx--;
            } else {
                res[++vaildIdx] = res[i];
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= vaildIdx; i++) {
            sb.append(res[i]);
        }
        return sb.toString();
    }

}
