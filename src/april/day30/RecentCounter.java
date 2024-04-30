package april.day30;

import java.util.LinkedList;

/**
 * 时间：2024/4/30
 * 问题描述：
 * 写一个 RecentCounter 类来计算特定时间范围内最近的请求。
 * 请你实现 RecentCounter 类：
 * RecentCounter() 初始化计数器，请求数为 0 。
 * int ping(int t) 在时间 t 添加一个新请求，其中 t 表示以毫秒为单位的某个时间，并返回过去 3000 毫秒内发生的所有请求数（包括新请求）。确切地说，返回在 [t-3000, t] 内发生的请求数。
 * 保证 每次对 ping 的调用都使用比之前更大的 t 值。
 * 切入点/解决思路：使用队列
 * 感想：
 */
public class RecentCounter {
    /**
     * 队列存储每次请求的毫秒数
     */
    private LinkedList<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        queue.add(t);
        while (queue.peekFirst() < (t - 3000)) queue.pollFirst();
        return queue.size();
    }

}
