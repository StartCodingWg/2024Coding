package april.day08;

/**
 * Author:   wang
 * Date:     2024/4/8 22:04
 * function:
 * 给你一个字符数组 chars ，请使用下述算法压缩：
 * 从一个空字符串 s 开始。对于 chars 中的每组 连续重复字符 ：
 * 如果这一组长度为 1 ，则将字符追加到 s 中。
 * 否则，需要向 s 追加字符，后跟这一组的长度。
 * 压缩后得到的字符串 s 不应该直接返回 ，需要转储到字符数组 chars 中。需要注意的是，如果组长度为 10 或 10 以上，则在 chars 数组中会被拆分为多个字符。
 * 请在 修改完输入数组后 ，返回该数组的新长度。
 * 你必须设计并实现一个只使用常量额外空间的算法来解决此问题。
 */
public class Compress {
    public int compress(char[] chars) {
        /* 特殊情况处理 */
        if (chars == null || chars.length <= 0) return 0;
        /* 开始统计：使用双指针 */
        int first = 0;
        int second = 0;
        int res = 0;
        while (second <= chars.length) {
            if (second == chars.length || chars[second] != chars[first]) {
                /* 将组写回 char */
                // 写入字符
                chars[res++] = chars[first];
                // 写入该字符出现的次数
                int num = second - first;
                if (num > 1) {
                    String strNum = String.valueOf(num);
                    for (int i = 0; i < strNum.length(); i++) {
                        chars[res++] = strNum.charAt(i);
                    }
                }
                // 重新定位左指针
                first = second;
            }
            second++;
        }
        return res;
    }
}
