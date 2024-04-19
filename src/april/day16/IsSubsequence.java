package april.day16;

/**
 * Author:   wang
 * Date:     2024/4/16 23:39
 * function: 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 *
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。
 * （例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 */
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        /* 特殊情况处理 */
        if (s == null || s.length() == 0) return true;
        if (t == null || t.length() < s.length()) return false;
        /* 开始判断 */
        char[] cArrS = s.toCharArray();
        char[] cArrT = t.toCharArray();
        int idx1 = 0;
        int idx2 = 0;
        while (idx1 < cArrS.length && idx2 < cArrT.length) {
            while (idx2 < cArrT.length && cArrS[idx1] != cArrT[idx2]) idx2++;
            if (idx2 < cArrT.length && cArrS[idx1] == cArrT[idx2]) idx1++;
            idx2++;
        }
        return idx1 == cArrS.length;
    }
}
