package May.day15;

import java.util.LinkedList;

/**
 * ʱ�䣺2024/5/16
 * ����������
 * �ڸ����� m x n ���� grid �У�ÿ����Ԫ���������������ֵ֮һ��
 * ֵ 0 ����յ�Ԫ��
 * ֵ 1 �����������ӣ�
 * ֵ 2 �����õ����ӡ�
 * ÿ���ӣ����õ����� ��Χ 4 ������������ ���������Ӷ��ḯ�á�
 * ���� ֱ����Ԫ����û����������Ϊֹ�����뾭������С����������������ܣ����� -1 ��
 * �����/���˼·��
 * ���룺
 */
public class OrangesRotting {
    public int orangesRotting(int[][] grid) {
        /* ����������� */
        if (grid == null) return 0;
        /* ʹ�ù���������� */
        boolean[][] isVisited = new boolean[grid.length][grid[0].length];
        LinkedList<int[]> queue = new LinkedList<>();
        int[][] helper = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int totalFresh = 0;
        // ���Ѿ����õ����Ӽ��뵽�����У�����ͳ���ܹ��ж��ٸ���������
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) queue.addLast(new int[]{i, j});
                else if (grid[i][j] == 1) totalFresh++;
            }
        }
        // ��ʼ�����������
        int minutes = 0;
        while (!queue.isEmpty()) {
            if (totalFresh == 0) return minutes;
            /* ������ɢ */
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cell = queue.removeFirst();
                for (int j = 0; j < helper.length; j++) {
                    int x = cell[0] + helper[j][0];
                    int y = cell[1] + helper[j][1];
                    // ��δ������е��������Ӽ��뵽������
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
