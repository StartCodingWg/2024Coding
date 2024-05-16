package May.day15;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * ʱ�䣺2024/5/16
 * ����������
 * ����һ������������ equations ��һ��ʵ��ֵ���� values ��Ϊ��֪���������� equations[i] = [Ai, Bi] �� values[i] ��ͬ��ʾ��ʽ Ai / Bi = values[i] ��ÿ�� Ai �� Bi ��һ����ʾ�����������ַ�����
 * ����һЩ������ queries ��ʾ�����⣬���� queries[j] = [Cj, Dj] ��ʾ�� j �����⣬���������֪�����ҳ� Cj / Dj = ? �Ľ����Ϊ�𰸡�
 * ���� ��������Ĵ� ���������ĳ���޷�ȷ���Ĵ𰸣����� -1.0 �������𰸡���������г����˸�������֪������û�г��ֵ��ַ�����Ҳ��Ҫ�� -1.0 �������𰸡�
 * ע�⣺����������Ч�ġ�����Լ�����������в�����ֳ���Ϊ 0 ��������Ҳ������κ�ì�ܵĽ����
 * ע�⣺δ�ڵ�ʽ�б��г��ֵı�����δ����ģ�����޷�ȷ�����ǵĴ𰸡�
 * �����/���˼·��
 * ���룺
 */
public class CalcEquation {
    /**
     * ����һ������ͼ�����ұ���ÿ���ߵ�Ȩ�أ������㼴��
     * @param equations
     * @param values
     * @param queries
     * @return
     */
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        /* ����������� */
        if (equations == null || queries == null) return new double[0];
        /* ʹ�þ��󱣴��Ȩ�ص�����ͼ */
        Map<String, Integer> stringToIndex = new HashMap<>();
        int startIndex = 0;
        // ��ÿ�����ʽӳ�䵽һ��Ψһ���±���
        double[] res = new double[queries.size()];
        for (int i = 0; i < equations.size(); i++) {
            String start = equations.get(i).get(0);
            String end = equations.get(i).get(1);
            if (!stringToIndex.containsKey(start)) stringToIndex.put(start, startIndex++);
            if (!stringToIndex.containsKey(end)) stringToIndex.put(end, startIndex++);
        }
        // ��������
        double[][] matrix = new double[startIndex][startIndex];
        for (int i = 0; i < equations.size(); i++) {
            String start = equations.get(i).get(0);
            String end = equations.get(i).get(1);
            matrix[stringToIndex.get(start)][stringToIndex.get(end)] = values[i];
            matrix[stringToIndex.get(end)][stringToIndex.get(start)] = 1 / values[i];
        }
        // �������������޻���ķ�ʽ��
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
