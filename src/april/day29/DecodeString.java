package april.day29;

import java.util.LinkedList;

/**
 * 时间：2024/4/29
 * 问题描述：
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 * 切入点/解决思路：使用栈
 * 感想：
 */
public class DecodeString {
    /**
     * 时间复杂度：O（m） m 解密后字符串的长度
     * 空间复杂度：O（m）m 解密后字符的长度
     * @param s
     * @return
     */
    public String decodeString(String s) {
        /* 特殊情况处理 */
        if (s == null || s.length() < 2) return s;
        /* 使用栈完成该题 */
        // 用于存储字符串
        LinkedList<String> stack1 = new LinkedList<>();
        // 用于存储重复次数
        LinkedList<Integer> stack2 = new LinkedList<>();
        char[] chars = s.toCharArray();
        int index = 0;
        while (index < chars.length){
            if (chars[index] == '[') {
                stack1.add("[");
                index++;
            } else if ( chars[index] >= '0' && chars[index] <= '9') {
                /* 存入重复次数 */
                StringBuilder sb = new StringBuilder();
                while (index < chars.length && (chars[index] >= '0' && chars[index] <= '9')) sb.append(chars[index++]);
                stack2.add(Integer.parseInt(sb.toString()));
            } else if (chars[index] >= 'a' && chars[index] <= 'z'){
                /* 存入需要重复的字符串 */
                StringBuilder sb = new StringBuilder();
                while (index < chars.length && (chars[index] >= 'a' && chars[index] <= 'z')) sb.append(chars[index++]);
                stack1.add(sb.toString());
            } else {
                /* 碰到 ] 开始进行解码 */
                String tem = "";
                while (!"[".equals(stack1.peekLast())) tem = stack1.pollLast() + tem;
                StringBuilder sb = new StringBuilder();
                int repeatTimes = stack2.pollLast();
                for (int i = 0; i < repeatTimes; i++) {
                    sb.append(tem);
                }
                stack1.pollLast();
                stack1.add(sb.toString());
                index++;
            }
        }
        /* 获取结果 */
        String tem = "";
        while (!stack1.isEmpty()) {
            tem = stack1.pollLast() + tem;
        }
        return tem;
    }
}
