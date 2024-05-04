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
        /* 特殊情况处理 */
        if (senate == null || senate.length() == 0) return "";
        /* 使用栈实现 */
        // [0, usedSize) 使用权力的议员，[usedSize, n) 未使用权力的议员
        LinkedList<Character> stack = new LinkedList<>();
        // 以及使用权力的议员
        StringBuilder temp = new StringBuilder(senate);
        while (true) {
            int usedSize = 0;
            // 议员使用权力优先将本轮未使用权力的议员投票出局
            for (char c : temp.toString().toCharArray()) {
                if (usedSize == stack.size() || c == stack.peekLast()) stack.addLast(c);
                else {
                    usedSize++;
                }
            }
            if (usedSize == 0) return stack.peek() == 'R' ? "Radiant" : "Dire";
            /* 重新组合下轮投票顺序 */
            temp = new StringBuilder();
            // 未投票的优先投票
            for (int i = 0; i < (stack.size() - usedSize); i++) {
                temp.append(stack.pollLast());
            }
            // 已投票的按入栈顺序投票
            for (int i = 0; i < usedSize; i++) {
                temp.append(stack.pollFirst());
            }
        }

    }
}
