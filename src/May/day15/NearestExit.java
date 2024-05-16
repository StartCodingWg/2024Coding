package May.day15;

import java.util.LinkedList;

/**
 * ʱ�䣺2024/5/16
 * ����������
 * ����һ�� m x n ���Թ����� maze ���±�� 0 ��ʼ�����������пո��ӣ��� '.' ��ʾ����ǽ���� '+' ��ʾ����ͬʱ�����Թ������ entrance ���� entrance = [entrancerow, entrancecol] ��ʾ��һ��ʼ���ڸ��ӵ��к��С�
 * ÿһ��������������� �ϣ��£��� ���� �� �ƶ�һ�����ӡ��㲻�ܽ���ǽ���ڵĸ��ӣ���Ҳ�����뿪�Թ������Ŀ�����ҵ��� entrance ��� �ĳ��ڡ����� �ĺ����� maze �߽� �ϵ� �ո��ӡ�entrance ���� ���� ���ڡ�
 * ���㷵�ش� entrance ��������ڵ����·���� ���� �����������������·�������㷵�� -1 ��
 * �����/���˼·��ʹ��ͼ�Ĺ����������
 * ���룺easy
 */
public class NearestExit {
    /**
     * ʱ�临�Ӷȣ�O��n * m��
     * @param maze
     * @param entrance
     * @return
     */
    public int nearestExit(char[][] maze, int[] entrance) {
        /* ����������� */
        if (maze == null || maze.length == 0 || entrance == null || entrance.length!= 2) return -1;
        /* ��ʼ���й���������� */
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
