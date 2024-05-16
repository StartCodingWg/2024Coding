package May.day15;

import java.util.LinkedList;

/**
 * 时间：2024/5/16
 * 问题描述：
 * 给你一个 m x n 的迷宫矩阵 maze （下标从 0 开始），矩阵中有空格子（用 '.' 表示）和墙（用 '+' 表示）。同时给你迷宫的入口 entrance ，用 entrance = [entrancerow, entrancecol] 表示你一开始所在格子的行和列。
 * 每一步操作，你可以往 上，下，左 或者 右 移动一个格子。你不能进入墙所在的格子，你也不能离开迷宫。你的目标是找到离 entrance 最近 的出口。出口 的含义是 maze 边界 上的 空格子。entrance 格子 不算 出口。
 * 请你返回从 entrance 到最近出口的最短路径的 步数 ，如果不存在这样的路径，请你返回 -1 。
 * 切入点/解决思路：使用图的广度优先搜索
 * 感想：easy
 */
public class NearestExit {
    /**
     * 时间复杂度：O（n * m）
     * @param maze
     * @param entrance
     * @return
     */
    public int nearestExit(char[][] maze, int[] entrance) {
        /* 特殊情况处理 */
        if (maze == null || maze.length == 0 || entrance == null || entrance.length!= 2) return -1;
        /* 开始进行广度优先搜索 */
        boolean[][] isVisited = new boolean[maze.length][maze[0].length];
        LinkedList<int[]> queue = new LinkedList<>();
        int[][] helper = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        isVisited[entrance[0]][entrance[1]] = true;
        queue.add(entrance);
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            step++;
            for (int i = 0; i < size; i++) {
                int[] ints = queue.removeFirst();
                for (int j = 0; j < helper.length; j++) {
                    int x = ints[0] + helper[j][0];
                    int y = ints[1] + helper[j][1];
                    if (x < 0 || y < 0 || x >= maze.length || y >= maze[0].length || maze[x][y] == '+' || isVisited[x][y]) continue;
                    if (x == 0 || y == 0 || x == maze.length - 1 || y == maze[0].length - 1) return step;
                    queue.addLast(new int[]{x, y});
                    isVisited[x][y] = true;
                }
            }
        }
        return -1;
    }
}
