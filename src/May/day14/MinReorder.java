package May.day14;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * ʱ�䣺2024/5/14
 * ����������
 * n �����У��� 0 �� n-1 ��ţ���乲�� n-1 ��·�ߡ���ˣ�Ҫ����������ͬ����֮������ֻ��Ψһһ��·�߿ɹ�ѡ��·�����γ�һ��������ȥ�꣬��ͨ���䲿�������¹滮·�ߣ��Ըı佻ͨӵ�µ�״����
 * ·���� connections ��ʾ������ connections[i] = [a, b] ��ʾ�ӳ��� a �� b ��һ������·�ߡ�
 * ���꣬���� 0 ����ٰ�һ�����ͱ������ܶ��οͶ���ǰ������ 0 ��
 * ����������¹滮·�߷���ʹÿ�����ж����Է��ʳ��� 0 ��������Ҫ����������С·������
 * ��Ŀ���� ��֤ ÿ�����������¹滮·�߷�����ܵ������ 0
 * �����/���˼·��ʹ�ù��������������
 * ���룺
 */
public class MinReorder {
    /**
     * ��Ҫ������������ͼ��������Ҫ��¼������֮��ķ���
     * ʱ�临�Ӷȣ�O��n��
     * �ռ临�Ӷȣ�O��n��
     *
     * @param n
     * @param connections
     * @return
     */
    public int minReorder(int n, int[][] connections) {
        /* ����������� */
        if (n < 1 || (n - 1) != connections.length) return -1;
        /* ʹ��ͼ�Ĺ���������� */
        // �ڹ����������ʱʹ��
        boolean[] isVisited = new boolean[n];
        // �������ͼ
        LinkedList<Integer>[] map = new LinkedList[n];
        // ��¼��������֮��ķ���
        Set<Integer>[] directionMap = new HashSet[n];
        for (int i = 0; i < n; i++) {
            map[i] = new LinkedList<Integer>();
            directionMap[i] = new HashSet<Integer>();
        }
        // ��ʼ����
        for (int i = 0; i < connections.length; i++) {
            map[connections[i][0]].addLast(connections[i][1]);
            map[connections[i][1]].addLast(connections[i][0]);
            directionMap[connections[i][0]].add(connections[i][1]);
        }
        // ʹ�ù����������
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
