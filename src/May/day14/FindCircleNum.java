package May.day14;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * ʱ�䣺2024/5/14
 * ����������
 * �� n �����У�����һЩ�˴���������һЩû��������������� a ����� b ֱ���������ҳ��� b ����� c ֱ����������ô���� a ����� c ���������
 * ʡ�� ��һ��ֱ�ӻ��������ĳ��У����ڲ�������û�������ĳ��С�
 * ����һ�� n x n �ľ��� isConnected ������ isConnected[i][j] = 1 ��ʾ�� i �����к͵� j ������ֱ���������� isConnected[i][j] = 0 ��ʾ���߲�ֱ��������
 * ���ؾ����� ʡ�� ��������
 * �����/���˼·��ʹ�������������������¼����״̬
 * ���룺
 */
public class FindCircleNum {
    /**
     * ʱ�临�Ӷȣ�O��n*m��
     * �ռ临�Ӷȣ�O��n*m��
     * @param isConnected
     * @return
     */
    public int findCircleNum(int[][] isConnected) {
        /* ����������� */
        if (isConnected == null) return -1;
        /* ʹ������������� */
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
        // ��Ϊ�Ѿ�����
        cityNos[indexX] = 0;
        /* �����������ӵĳ�����Ϊ�Ѿ������� */
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
