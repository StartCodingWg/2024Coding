package march.day30;

/**
 * Author:   wang
 * Date:     2024/3/30 22:10
 * function: 给你两个字符串 word1 和 word2 。
 *      请你从 word1 开始，通过交替添加字母来合并字符串。
 *      如果一个字符串比另一个字符串长，就将多出来的字母追加到合并后字符串的末尾。
 */
public class MergeAlternately {
    public String mergeAlternately(String word1, String word2) {
        if (word1 == null) return word2;
        if (word2 == null) return word1;
        StringBuilder sb = new StringBuilder();
        char[] idx1 = word1.toCharArray();
        char[] idx2 = word2.toCharArray();
        int i1 = 0, i2 = 0;
        for (; i1 < idx1.length && i2 < idx2.length; i1++, i2++) {
            sb.append(idx1[i1]).append(idx2[i2]);
        }
        for (; i1 < idx1.length; i1++) {
            sb.append(idx1[i1]);;
        }
        for (; i2 < idx2.length; i2++) {
            sb.append(idx2[i2]);;
        }
        return sb.toString();
    }

}
