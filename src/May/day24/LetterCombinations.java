package May.day24;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 时间：2024/5/24
 * 问题描述：
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 切入点/解决思路：
 * 感想：
 */
public class LetterCombinations {

    /**
     * 数据到字母的映射
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
     * 使用回溯方法时间复杂度：k^n（ 2 < k < 5）
     *
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        List<String> res = new LinkedList<>();
        /* 特殊情况处理 */
        if (digits == null || digits.length() == 0) return res;
        return helper(digits.toCharArray(), 0);
    }

    private List<String> helper(char[] arrs, int index) {
        /* 递归结束条件 */
        if (index >= arrs.length) return new LinkedList<String>() {{
            add("");
        }};
        /* 递归体 */
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
