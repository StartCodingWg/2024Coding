package april.day26;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 时间：2024/4/26
 * 问题描述：
 * 给你一个下标从 0 开始、大小为 n x n 的整数矩阵 grid ，返回满足 Ri 行和 Cj 列相等的行列对 (Ri, Cj) 的数目。
 *
 * 如果行和列以相同的顺序包含相同的元素（即相等的数组），则认为二者是相等的。
 * 切入点/解决思路：使用 hash / 搜索树
 * 感想：这题如果要难的话，需要自己写 hash 算法，来快速找到
 */
public class EqualPairs {
    public int equalPairs(int[][] grid) {
        /* 特殊情况处理 */
        if (grid == null || grid[0].length == 0) return 0;
        /* 开始计算 */
        /* 保存每行的排列顺序 */
        HashMap<String, Integer> lines = new HashMap<>();
        for (int i = 0; i < grid.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < grid[i].length; j++) {
                sb.append(grid[i][j]).append(",");
            }
            String s = sb.toString();
            lines.put(s, lines.getOrDefault(s, 0) + 1);
        }
        /* 判断某列是否与某行拥有同样的排列 */
        int res = 0;
        for (int i = 0; i < grid[0].length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < grid.length; j++) {
                sb.append(grid[j][i]).append(",");
            }
            res += lines.getOrDefault(sb.toString(), 0);
        }
        return res;
    }
}
