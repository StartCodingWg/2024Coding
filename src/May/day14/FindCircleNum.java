package May.day14;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 时间：2024/5/14
 * 问题描述：
 * 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。
 * 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
 * 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 isConnected[i][j] = 0 表示二者不直接相连。
 * 返回矩阵中 省份 的数量。
 * 切入点/解决思路：使用深度优先搜索，并记录搜索状态
 * 感想：
 */
public class FindCircleNum {
    /**
     * 时间复杂度：O（n*m）
     * 空间复杂度：O（n*m）
     * @param isConnected
     * @return
     */
    public int findCircleNum(int[][] isConnected) {
        /* 特殊情况处理 */
        if (isConnected == null) return -1;
        /* 使用深度优先搜索 */
        int res = 0;
        int[] cityNos = new int[isConnected.length];
        Arrays.fill(cityNos, 1);
        for (int i = 0; i < isConnected.length; i++) {
            if (cityNos[i] == 1) {
                findCity(isConnected, i, cityNos);
                res++;
            }
        }
        return res;
    }

    private void findCity(int[][] isConnected, int indexX, int[] cityNos) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(indexX);
        // 置为已经访问
        cityNos[indexX] = 0;
        /* 将所有相连接的城市置为已经访问了 */
        while (!queue.isEmpty()) {
            Integer index = queue.removeFirst();
            for (int i = 0; i < isConnected.length; i++) {
               if (isConnected[index][i] == 1 && cityNos[i] == 1) {
                   queue.add(i);
                   cityNos[i] = 0;
               }
            }
        }
    }
}
