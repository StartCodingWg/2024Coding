package april.day02;

import java.util.HashSet;
import java.util.Set;

/**
 * Author:   wang
 * Date:     2024/4/2 23:12
 * function: ����һ���ַ��� s ������ת�ַ����е�����Ԫ����ĸ�������ؽ���ַ�����
 * Ԫ����ĸ���� 'a'��'e'��'i'��'o'��'u'���ҿ����Դ�Сд������ʽ���ֲ�ֹһ�Ρ�
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
     * ʹ��˫ָ��
     */
    public String reverseVowels(String s) {
        if (s == null || s.length() <= 1) return s;
        /* ˫ָ�� */
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
        /* ���ؽ�� */
        return new String(charArray);
    }

}
