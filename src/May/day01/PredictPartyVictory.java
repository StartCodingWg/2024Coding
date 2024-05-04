package May.day01;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Author:   wang
 * Date:     2024/5/4 15:15
 * function:
 */
public class PredictPartyVictory {
    public String predictPartyVictory(String senate) {
        /* ����������� */
        if (senate == null || senate.length() == 0) return "";
        /* ʹ��ջʵ�� */
        // [0, usedSize) ʹ��Ȩ������Ա��[usedSize, n) δʹ��Ȩ������Ա
        LinkedList<Character> stack = new LinkedList<>();
        // �Լ�ʹ��Ȩ������Ա
        StringBuilder temp = new StringBuilder(senate);
        while (true) {
            int usedSize = 0;
            // ��Աʹ��Ȩ�����Ƚ�����δʹ��Ȩ������ԱͶƱ����
            for (char c : temp.toString().toCharArray()) {
                if (usedSize == stack.size() || c == stack.peekLast()) stack.addLast(c);
                else {
                    usedSize++;
                }
            }
            if (usedSize == 0) return stack.peek() == 'R' ? "Radiant" : "Dire";
            /* �����������ͶƱ˳�� */
            temp = new StringBuilder();
            // δͶƱ������ͶƱ
            for (int i = 0; i < (stack.size() - usedSize); i++) {
                temp.append(stack.pollLast());
            }
            // ��ͶƱ�İ���ջ˳��ͶƱ
            for (int i = 0; i < usedSize; i++) {
                temp.append(stack.pollFirst());
            }
        }

    }
}
