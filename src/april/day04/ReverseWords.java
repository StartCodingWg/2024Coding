package april.day04;

/**
 * 时间：2024/4/4
 * 问题描述：
 * 切入点/解决思路：
 * 给你一个字符串 s ，请你反转字符串中 单词 的顺序。
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
 * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
 * 感想：
 */
public class ReverseWords {
    public String reverseWords(String s) {
        /* 特殊情况处理 */
        if (s == null || "".equals(s) || "".equals(s.trim())) return "";
        /* 使用双指针 */
        StringBuilder sbHead = new StringBuilder();
        StringBuilder sbTail = new StringBuilder();
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            /* 从左到右找到字符串 */
            int vaildIndex = -1;
            while (left <= right && s.charAt(left) == ' ') left++;
            vaildIndex = left;
            while (left <= right && s.charAt(left) != ' ') left++;
            if (vaildIndex <= right) sbTail.insert(0, " " + s.substring(vaildIndex, left));
            /* 从右到左找字符串 */
            vaildIndex = -1;
            while (left <= right && s.charAt(right) == ' ') right--;
            vaildIndex = right;
            while (left <= right && s.charAt(right) != ' ') right--;
            if (vaildIndex >= left) sbHead.append(" ").append(s.substring(right + 1, vaildIndex + 1));
        }
        return (sbHead + sbTail.toString()).trim();
    }
}
