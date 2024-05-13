package May.day13;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * ʱ�䣺2024/5/13
 * ����������
 * �� n �����䣬���䰴�� 0 �� n - 1 ��š�������� 0 �ŷ�������������з��䶼����ס�����Ŀ���ǽ������еķ��䡣Ȼ�����㲻����û�л��Կ�׵�ʱ�������ס�ķ��䡣
 * �������һ�����䣬����ܻ��������ҵ�һ�ײ�ͬ��Կ�ף�ÿ��Կ���϶��ж�Ӧ�ķ���ţ�����ʾԿ�׿��Դ򿪵ķ��䡣�������������Կ��ȥ�����������䡣
 * ����һ������ rooms ���� rooms[i] ������� i �ŷ�����Ի�õ�Կ�׼��ϡ�����ܽ��� ���� ���䷵�� true�����򷵻� false��
 * �����/���˼·��ͼ�������������
 * ���룺
 */
public class CanVisitAllRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        /* ����������� */
        if (rooms == null || rooms.size() < 2) return true;
        /* ��ʼ��������������� */
        Set<Integer> indexSet = new HashSet<Integer>();
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(0);
        indexSet.add(0);
        while (!queue.isEmpty()) {
            int index = queue.pollFirst();
            rooms.get(index).forEach(ele -> {
                if (indexSet.add(ele)) {
                    queue.addLast(ele);
                }
            });
        }
        return indexSet.size() == rooms.size();
    }

}
