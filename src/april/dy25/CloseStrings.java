package april.dy25;

/**
 * Author:   wang
 * Date:     2024/4/25 22:19
 * function:
 * 如果可以使用以下操作从一个字符串得到另一个字符串，则认为两个字符串 接近 ：
 *
 * 操作 1：交换任意两个 现有 字符。
 * 例如，abcde -> aecdb
 * 操作 2：将一个 现有 字符的每次出现转换为另一个 现有 字符，并对另一个字符执行相同的操作。
 * 例如，aacabb -> bbcbaa（所有 a 转化为 b ，而所有的 b 转换为 a ）
 * 你可以根据需要对任意一个字符串多次使用这两种操作。
 *
 * 给你两个字符串，word1 和 word2 。如果 word1 和 word2 接近 ，就返回 true ；否则，返回 false 。
 * 实现：使用 hash，本质就是判断两个字符串中字符的种类是否一致，以及字符出现的次数是否一致（不考虑字符出现的种类）
 *
 */
public class CloseStrings {
    /***
     * 时间复杂度：O（n）
     * 空间复杂的：O（n）
     * @param word1
     * @param word2
     * @return
     */
    public boolean closeStrings(String word1, String word2) {
        /* 特殊情况 */
        if (word1 == word2) return true;
        if (word1 == null || word2 == null) return false;
        if (word1.length() != word2.length()) return false;
        /* 计算两个字符串中每个字符串出现的次数 */
        char[] charArray1 = word1.toCharArray();
        char[] charArray2 = word2.toCharArray();

        int[] word1Count = new int[26];
        int[] word2Count = new int[26];
        for (int i = 0; i < word1.length(); i++) {
            word1Count[charArray1[i] - 'a']++;
            word2Count[charArray2[i] - 'a']++;
        }
        /* 判断两个字符串的字符种类是否一致 */
        int[] time = new int[100001];
        for (int i = 0; i < word1Count.length; i++) {
            if ((word1Count[i] == 0 && word2Count[i] != 0) ||
                    (word1Count[i] != 0 && word2Count[i] == 0))
                return false;
            else time[word1Count[i]]++;
        }
        /* 判断出现的次数是否一样 */
        for (int i = 0; i < word2Count.length; i++) {
            time[word2Count[i]]--;
            if (time[word2Count[i]] < 0) return false;

        }
        return true;
    }
}
