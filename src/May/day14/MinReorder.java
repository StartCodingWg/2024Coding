package May.day14;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 时间：2024/5/14
 * 问题描述：
 * n 座城市，从 0 到 n-1 编号，其间共有 n-1 条路线。因此，要想在两座不同城市之间旅行只有唯一一条路线可供选择（路线网形成一颗树）。去年，交通运输部决定重新规划路线，以改变交通拥堵的状况。
 * 路线用 connections 表示，其中 connections[i] = [a, b] 表示从城市 a 到 b 的一条有向路线。
 * 今年，城市 0 将会举办一场大型比赛，很多游客都想前往城市 0 。
 * 请你帮助重新规划路线方向，使每个城市都可以访问城市 0 。返回需要变更方向的最小路线数。
 * 题目数据 保证 每个城市在重新规划路线方向后都能到达城市 0
 * 切入点/解决思路：使用广度优先搜索即可
 * 感想：
 */
public class MinReorder {
    /**
     * 需要把它当做无向图，但是需要记录两个点之间的方向
     * 时间复杂度：O（n）
     * 空间复杂度：O（n）
     *
     * @param n
     * @param connections
     * @return
     */
    public int minReorder(int n, int[][] connections) {
        /* 特殊情况处理 */
        if (n < 1 || (n - 1) != connections.length) return -1;
        /* 使用图的广度优先搜索 */
        // 在广度优先搜索时使用
        boolean[] isVisited = new boolean[n];
        // 存放无向图
        LinkedList<Integer>[] map = new LinkedList[n];
        // 记录两个城市之间的方向
        Set<Integer>[] directionMap = new HashSet[n];
        for (int i = 0; i < n; i++) {
            map[i] = new LinkedList<Integer>();
            directionMap[i] = new HashSet<Integer>();
        }
        // 初始数据
        for (int i = 0; i < connections.length; i++) {
            map[connections[i][0]].addLast(connections[i][1]);
            map[connections[i][1]].addLast(connections[i][0]);
            directionMap[connections[i][0]].add(connections[i][1]);
        }
        // 使用广度优先搜索
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.addLast(0);
        isVisited[0] = true;
        AtomicInteger count = new AtomicInteger(0);
        while (!queue.isEmpty()) {
            Integer index = queue.removeFirst();
            map[index].forEach(next -> {
                if (!isVisited[next]) {
                    if (directionMap[index].contains(next)) count.incrementAndGet();
                    queue.addLast(next);
                    isVisited[next] = true;
                }
            });
        }
        return count.get();
    }

    public static void main(String[] args) {
        int[][] test = new int[][]{{0,1},{2,0},{3,2}};
        MinReorder minReorder = new MinReorder();
        System.out.println(minReorder.minReorder(4, test));
    }
}
