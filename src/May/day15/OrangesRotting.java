package May.day15;

import java.util.LinkedList;

/**
 * 时间：2024/5/16
 * 问题描述：
 * 在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一：
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * 每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。
 * 返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。
 * 切入点/解决思路：
 * 感想：
 */
public class OrangesRotting {
    public int orangesRotting(int[][] grid) {
        /* 特殊情况处理 */
        if (grid == null) return 0;
        /* 使用广度优先搜索 */
        boolean[][] isVisited = new boolean[grid.length][grid[0].length];
        LinkedList<int[]> queue = new LinkedList<>();
        int[][] helper = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int totalFresh = 0;
        // 将已经腐烂的橘子加入到队列中，并且统计总共有多少个新鲜橘子
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) queue.addLast(new int[]{i, j});
                else if (grid[i][j] == 1) totalFresh++;
            }
        }
        // 开始广度优先搜索
        int minutes = 0;
        while (!queue.isEmpty()) {
            if (totalFresh == 0) return minutes;
            /* 进行扩散 */
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cell = queue.removeFirst();
                for (int j = 0; j < helper.length; j++) {
                    int x = cell[0] + helper[j][0];
                    int y = cell[1] + helper[j][1];
                    // 把未加入队列的新鲜橘子加入到队列中
                    if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length
                            || isVisited[x][y]
                            || grid[x][y] != 1) continue;
                    isVisited[x][y] = true;
                    queue.addLast(new int[]{x, y});
                    totalFresh--;
                }
            }
            minutes++;
        }
        return totalFresh == 0 ? minutes : -1;
    }
}
