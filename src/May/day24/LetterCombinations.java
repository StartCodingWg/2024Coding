package May.day24;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * ʱ�䣺2024/5/24
 * ����������
 * ����һ������������ 2-9 ���ַ����������������ܱ�ʾ����ĸ��ϡ��𰸿��԰� ����˳�� ���ء�
 * �������ֵ���ĸ��ӳ�����£���绰������ͬ����ע�� 1 ����Ӧ�κ���ĸ��
 * �����/���˼·��
 * ���룺
 */
public class LetterCombinations {

    /**
     * ���ݵ���ĸ��ӳ��
     */
    Map<Character, List<Character>> numToChar = new HashMap<Character, List<Character>>() {{
        put('2', new LinkedList<Character>() {{
            add('a');
            add('b');
            add('c');
        }});
        put('3', new LinkedList<Character>() {{
            add('d');
            add('e');
            add('f');
        }});
        put('4', new LinkedList<Character>() {{
            add('g');
            add('h');
            add('i');
        }});
        put('5', new LinkedList<Character>() {{
            add('j');
            add('k');
            add('l');
        }});
        put('6', new LinkedList<Character>() {{
            add('m');
            add('n');
            add('o');
        }});
        put('7', new LinkedList<Character>() {{
            add('p');
            add('q');
            add('r');
            add('s');
        }});
        put('8', new LinkedList<Character>() {{
            add('t');
            add('u');
            add('v');
        }});
        put('9', new LinkedList<Character>() {{
            add('w');
            add('x');
            add('y');
            add('z');
        }});
    }};

    /**
     * ʹ�û��ݷ���ʱ�临�Ӷȣ�k^n�� 2 < k < 5��
     *
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        List<String> res = new LinkedList<>();
        /* ����������� */
        if (digits == null || digits.length() == 0) return res;
        return helper(digits.toCharArray(), 0);
    }

    private List<String> helper(char[] arrs, int index) {
        /* �ݹ�������� */
        if (index >= arrs.length) return new LinkedList<String>() {{
            add("");
        }};
        /* �ݹ��� */
        List<String> helper = helper(arrs, index + 1);
        List<String> res = new LinkedList<String>();
        numToChar.get(arrs[index]);
        for (int i = 0; i < numToChar.get(arrs[index]).size(); i++) {
            Character character = numToChar.get(arrs[index]).get(i);
            for (String s : helper) {
                res.add(character + s);
            }
        }
        return res;
    }
}
