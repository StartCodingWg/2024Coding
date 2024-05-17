package May.day17;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * ʱ�䣺2024/5/17
 * ����������
 * �����/���˼·��
 * ���룺
 */
public class SmallestInfiniteSet {

    /**
     * ���汻������������С��������
     * minNumSet ������Ԫ�ؾ�С�� minNum
     */
    private PriorityQueue<Integer> minNumSet;

    /**
     * ��֤ minNumSet �е�Ԫ�ز��ظ�
     */
    private Set<Integer> set;

    /**
     * [minNum, oo] ֮�����������δʹ��
     */
    private int minNum;

    public SmallestInfiniteSet() {
        minNum = 1;
        minNumSet = new PriorityQueue<>(1000, Comparator.comparingInt(o -> o));
        set = new HashSet<>();
    }

    public int popSmallest() {
        if (!minNumSet.isEmpty()) {
            set.remove(minNumSet.peek());
            return minNumSet.poll();
        }
        return minNum++;
    }

    public void addBack(int num) {
        if (num < minNum && !set.contains(num)) {
            minNumSet.offer(num);
            set.add(num);
        }
    }
}
