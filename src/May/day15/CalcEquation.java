package May.day15;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 时间：2024/5/16
 * 问题描述：
 * 给你一个变量对数组 equations 和一个实数值数组 values 作为已知条件，其中 equations[i] = [Ai, Bi] 和 values[i] 共同表示等式 Ai / Bi = values[i] 。每个 Ai 或 Bi 是一个表示单个变量的字符串。
 * 另有一些以数组 queries 表示的问题，其中 queries[j] = [Cj, Dj] 表示第 j 个问题，请你根据已知条件找出 Cj / Dj = ? 的结果作为答案。
 * 返回 所有问题的答案 。如果存在某个无法确定的答案，则用 -1.0 替代这个答案。如果问题中出现了给定的已知条件中没有出现的字符串，也需要用 -1.0 替代这个答案。
 * 注意：输入总是有效的。你可以假设除法运算中不会出现除数为 0 的情况，且不存在任何矛盾的结果。
 * 注意：未在等式列表中出现的变量是未定义的，因此无法确定它们的答案。
 * 切入点/解决思路：
 * 感想：
 */
public class CalcEquation {
    /**
     * 构建一张有向图，并且表明每条边的权重，最后计算即可
     * @param equations
     * @param values
     * @param queries
     * @return
     */
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        /* 特殊情况处理 */
        if (equations == null || queries == null) return new double[0];
        /* 使用矩阵保存带权重的有向图 */
        Map<String, Integer> stringToIndex = new HashMap<>();
        int startIndex = 0;
        // 将每个表达式映射到一个唯一的下标中
        double[] res = new double[queries.size()];
        for (int i = 0; i < equations.size(); i++) {
            String start = equations.get(i).get(0);
            String end = equations.get(i).get(1);
            if (!stringToIndex.containsKey(start)) stringToIndex.put(start, startIndex++);
            if (!stringToIndex.containsKey(end)) stringToIndex.put(end, startIndex++);
        }
        // 构建矩阵
        double[][] matrix = new double[startIndex][startIndex];
        for (int i = 0; i < equations.size(); i++) {
            String start = equations.get(i).get(0);
            String end = equations.get(i).get(1);
            matrix[stringToIndex.get(start)][stringToIndex.get(end)] = values[i];
            matrix[stringToIndex.get(end)][stringToIndex.get(start)] = 1 / values[i];
        }
        // 计算结果（采用无缓存的方式）
        for (int i = 0; i < queries.size(); i++) {
            int start = stringToIndex.getOrDefault(queries.get(i).get(0), -1);
            int end = stringToIndex.getOrDefault(queries.get(i).get(1), -1);
            res[i] = dfs(start, end, matrix);
        }
        return res;
    }

    private double dfs(int start, int end, double[][] matrix) {
        if (start == -1 || end == -1) return -1d;
        if (start == end) return 1d;
        boolean[] isVisited = new boolean[matrix.length];
        LinkedList<Integer> nodeQueue = new LinkedList<>();
        LinkedList<Double> valQueue = new LinkedList<>();
        isVisited[start] = true;
        nodeQueue.addLast(start);
        valQueue.addLast(1d);
        while (!nodeQueue.isEmpty()) {
            Integer node = nodeQueue.removeFirst();
            Double val = valQueue.removeFirst();
            for (int i = 0; i < matrix[node].length; i++) {
                if (matrix[node][i] != 0d && !isVisited[i]) {
                    nodeQueue.addLast(i);
                    valQueue.addLast(val * matrix[node][i]);
                    isVisited[i] = true;
                    if (i == end) return val * matrix[node][i];
                }
            }
        }
        return -1d;
    }

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        String[][] arr = new String[][]{{"a","b"},{"b","c"},{"d","e"},{"a","d"}};
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i][0])) map.put(arr[i][0], index++);
            if (!map.containsKey(arr[i][1])) map.put(arr[i][1], index++);
        }
        System.out.println(index);
    }
}
