package april.day02;

import java.util.HashSet;
import java.util.Set;

/**
 * Author:   wang
 * Date:     2024/4/2 23:12
 * function: 给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。
 * 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现不止一次。
 */
public class ReverseVowels {

    public static Set<Character> set = new HashSet<>();
    static {
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
    }

    /**
     * 使用双指针
     */
    public String reverseVowels(String s) {
        if (s == null || s.length() <= 1) return s;
        /* 双指针 */
        char[] charArray = s.toCharArray();
        int left  = 0;
        int right = charArray.length - 1;
        while (left < right) {
            while (left < right && !set.contains(charArray[left])) left++;
            while (left < right && !set.contains(charArray[right])) right--;
            char c = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = c;
            left++;
            right--;
        }
        /* 返回结果 */
        return new String(charArray);
    }

}
