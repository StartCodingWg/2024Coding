package May.day17;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 时间：2024/5/17
 * 问题描述：
 * 切入点/解决思路：
 * 感想：
 */
public class SmallestInfiniteSet {

    /**
     * 保存被新增进来的最小整数集合
     * minNumSet 中所有元素均小于 minNum
     */
    private PriorityQueue<Integer> minNumSet;

    /**
     * 保证 minNumSet 中的元素不重复
     */
    private Set<Integer> set;

    /**
     * [minNum, oo] 之间的正整数均未使用
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
